package com.zyx.service.pg.impl;

import com.zyx.constants.pg.PgConstants;
import com.zyx.entity.pg.CircleItem;
import com.zyx.vo.pg.CircleItemLunBoVo;
import com.zyx.mapper.pg.CircleItemMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.pg.CircleItemService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.pg.CircleItemVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.service.pg.impl
 * Create by XiaoWei on 2016/6/21
 */
@Service
public class CircleItemServiceImpl extends BaseServiceImpl<CircleItem> implements CircleItemService {
    @Resource
    private CircleItemMapper circleItemMapper;

    public CircleItemServiceImpl() {
        super(CircleItem.class);
    }

    @Override
    public Map<String, Object> addCircleItem(Integer circle_id, Integer create_id, String title, String content, String img_url) {
        try {
            CircleItem circleItem = new CircleItem();
            Optional.ofNullable(circle_id).ifPresent(circleItem::setCircleId);
            if (circle_id == null) {
//                map.put(Constants.STATE, PgConstants.PG_ERROR_CODE_30001);
//                map.put(Constants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30001_MSG);
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30001, PgConstants.PG_ERROR_CODE_30001_MSG);
            }
            Optional.ofNullable(create_id).ifPresent(circleItem::setCreateId);
            if (create_id == null) {
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30005, PgConstants.PG_ERROR_CODE_30005_MSG);
//                map.put(Constants.STATE, PgConstants.PG_ERROR_CODE_30005);
//                map.put(Constants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30005_MSG);
////                Constants.MSG_PARAM_ERROR
//                return map;
            }
            Optional.ofNullable(title).ifPresent(circleItem::setTitle);
            if (title == null) {
//                map.put(Constants.STATE, PgConstants.PG_ERROR_CODE_30006);
//                map.put(Constants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30006_MSG);
//                return map;
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30006, PgConstants.PG_ERROR_CODE_30006_MSG);
            }
            Optional.ofNullable(content).ifPresent(circleItem::setContent);
            if (content == null) {
//                map.put(Constants.STATE, PgConstants.PG_ERROR_CODE_30007);
//                map.put(Constants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30007_MSG);
//                return map;
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30007, PgConstants.PG_ERROR_CODE_30007_MSG);

            }
            circleItem.setState(0);
            circleItem.setImgUrl(img_url);
            circleItem.setCreateTime(new Date().getTime());
            circleItem.setContent("<p>" + circleItem.getContent() + "</p>");
            if (circleItem.getImgUrl() != null) {
                if (circleItem.getImgUrl().contains(",")) {
                    StringBuilder sb = new StringBuilder();
                    String[] imgOne = circleItem.getImgUrl().split(",");
                    for (int i = 0; i < imgOne.length; i++) {
                        sb.append("<img src='http://image.tiyujia.com/" + imgOne[i] + "'></img><p>&nbsp;</p>");
                    }
                    circleItem.setContent(circleItem.getContent() + sb.toString());
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("<img src='http://image.tiyujia.com/" + circleItem.getImgUrl() + "'></img>");
                    circleItem.setContent(circleItem.getContent() + sb.toString());
                }
            }
            save(circleItem);
            return MapUtils.buildSuccessMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_33000_MSG, null);
        } catch (Exception e) {
            e.printStackTrace();
            return PgConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> circleItemList(Integer max, Integer circleId) {
        try {
            Optional.ofNullable(max).orElse(10);

            List<CircleItem> list = circleItemMapper.circleItemList(max, circleId);
            return MapUtils.buildSuccessMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_34000_MSG, list);
        } catch (Exception e) {
            e.printStackTrace();
            return PgConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> setTop(Integer topSize, Integer circleItemId) {
        if (topSize == null) {
            return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30032, PgConstants.PG_ERROR_CODE_30032_MSG);
        }
        if (circleItemId == null) {
            return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30033, PgConstants.PG_ERROR_CODE_30033_MSG);
        }
        Integer result = circleItemMapper.setTop(topSize, circleItemId);
        if (result > 0) {
            return MapUtils.buildErrorMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_39000_MSG);
        }
        return MapUtils.buildErrorMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_34000_MSG);

    }

    @Override
    public Map<String, Object> topList(Integer circleId, Integer max) {
        Optional.ofNullable(max).orElse(3);
        if (circleId == null) {
            return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30001, PgConstants.PG_ERROR_CODE_30001_MSG);
        }
        return MapUtils.buildSuccessMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_34000_MSG, circleItemMapper.topList(circleId, max));
    }

    @Override
    public Map<String, Object> deleteCircleItemByParams(Integer createThisId, Integer circleItemId) {
        try {
            CircleItem circleItemFind = circleItemMapper.findById(circleItemId);
            if (circleItemFind != null) {
                if (circleItemFind.getCreateId() == createThisId) {
                    Integer result = circleItemMapper.delByThisUser(createThisId, circleItemId);
                    if (result > 0) {
                        return MapUtils.buildErrorMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_37000_MSG);
                    }
                } else {
                    return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30029, PgConstants.PG_ERROR_CODE_30029_MSG);
                }
            } else {
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30031, PgConstants.PG_ERROR_CODE_30031_MSG);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_35000, PgConstants.PG_ERROR_CODE_35000_MSG);
        }
        return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_35000, PgConstants.PG_ERROR_CODE_35000_MSG);

    }

    @Override
    public Map<String, Object> lbCircleItem(Integer max) {
        {
            try {
                Optional.ofNullable(max).orElse(5);
                List<CircleItemLunBoVo> lunBos = circleItemMapper.getLunBo(max);
                return MapUtils.buildSuccessMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_34000_MSG, lunBos);
            } catch (Exception e) {
                e.printStackTrace();
                return PgConstants.MAP_500;
            }
        }
    }

    @Override
    public Map<String, Object> getOneCircleItem(Integer circleItemId) {
        try {
            if (Objects.equals(circleItemId, null)) {
                return MapUtils.buildErrorMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_30033_MSG);
            }
            CircleItemLunBoVo vo = circleItemMapper.getOneCircleItem(circleItemId);
            return MapUtils.buildSuccessMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_34000_MSG, vo);
        } catch (Exception e) {
            e.printStackTrace();
            return PgConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> getTjCircleItem(Integer start, Integer pageSize) {
        try {
            Optional.ofNullable(start).orElse(0);
            Optional.ofNullable(pageSize).orElse(0);
            List<CircleItemVo> circleItemVos = circleItemMapper.getTjCircleItem(start * pageSize, pageSize);
            return MapUtils.buildSuccessMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_34000_MSG, circleItemVos);
        } catch (Exception e) {
            e.printStackTrace();
            return PgConstants.MAP_500;
        }
    }
}
