package com.zyx.service.pg.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.pg.PgConstants;
import com.zyx.entity.pg.CircleItem;
import com.zyx.mapper.collection.CollectionMapper;
import com.zyx.param.collection.CollectionParam;
import com.zyx.service.activity.PageViwesService;
import com.zyx.service.pg.ConcernService;
import com.zyx.vo.collection.CollectionVo;
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

    @Resource
    private CollectionMapper collectionMapper;

    @Resource
    private ConcernService concernService;


    @Resource
    private PageViwesService pageViwesService;

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
            Optional.ofNullable(content).ifPresent(circleItem::setBaseContent);
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
                    if(!Objects.equals(circleItem.getImgUrl(),null)||!Objects.equals(circleItem.getImgUrl(),"")){
                        sb.append("<img src='http://image.tiyujia.com/" + circleItem.getImgUrl()     + "'></img>");
                        circleItem.setContent(circleItem.getContent() + sb.toString());
                    }
                }
            }
            save(circleItem);
            concernService.fromConcern(circleItem.getId(),Constants.DYNAMIC_CIRCLE_ITEM,circleItem);
            return MapUtils.buildSuccessMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_33000_MSG, null);
        } catch (Exception e) {
            e.printStackTrace();
            return PgConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> circleItemList(Integer circleId, Integer start, Integer pageSize) {
        try {
            start = Optional.ofNullable(start).orElse(0);
            pageSize = Optional.ofNullable(pageSize).orElse(0);
            List<CircleItemVo> list = circleItemMapper.circleItemList(circleId, start * pageSize, pageSize);
            list.stream().forEach(s -> s.setPageViews(pageViwesService.getPageViwesByInternal(3, s.getId())));
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
    public Map<String, Object> getOneCircleItem(Integer circleItemId, Integer accountId) {
        try {
            if (Objects.equals(circleItemId, null)) {
                return MapUtils.buildErrorMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_30033_MSG);
            }
            CircleItemLunBoVo vo = circleItemMapper.getOneCircleItem(circleItemId);
            CollectionParam param = new CollectionParam();
            Boolean isCollection = false;
            if (!Objects.equals(accountId, null)) {
                param.setUserId(accountId);
                param.setModel(Constants.MODEL_CIRCLE_ITEM);
                param.setModelId(circleItemId);
                CollectionVo collectionFind = collectionMapper.existCollection(param);
                if (!Objects.equals(collectionFind, null)) {
                    isCollection = true;
                }
            }
            Map resultMap = new HashMap<>();
            resultMap.put("circleItem", vo);
            resultMap.put("isCollection", isCollection);
            return MapUtils.buildSuccessMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_34000_MSG, resultMap);
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

    @Override
    public List<CircleItemVo> getCircleItemByIds(List<Integer> ids) {
        return circleItemMapper.selectCircleItemByIds(ids);
    }
}
