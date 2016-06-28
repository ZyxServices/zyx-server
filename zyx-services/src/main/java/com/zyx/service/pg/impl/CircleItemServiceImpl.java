package com.zyx.service.pg.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.pg.PgConstants;
import com.zyx.entity.pg.CircleItem;
import com.zyx.mapper.pg.CircleItemMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.pg.CircleItemService;
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

    @Override
    public Map<String, Object> addCircleItem(Integer circle_id, Integer create_id, String title, String content) {
        Map<String, Object> map = new HashMap<>();
        try {
            CircleItem circleItem = new CircleItem();
            Optional.ofNullable(circle_id).ifPresent(circleItem::setCircle_id);
            if (circle_id == null) {
                map.put(Constants.ERROR_CODE, PgConstants.PG_ERROR_CODE_30001);
                map.put(Constants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30001_MSG);
                return map;
            }
            Optional.ofNullable(create_id).ifPresent(circleItem::setCreate_id);
            if (create_id == null) {
                map.put(Constants.ERROR_CODE, PgConstants.PG_ERROR_CODE_30005);
                map.put(Constants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30005_MSG);
                return map;
            }
            Optional.ofNullable(title).ifPresent(circleItem::setTitle);
            if (title == null) {
                map.put(Constants.ERROR_CODE, PgConstants.PG_ERROR_CODE_30006);
                map.put(Constants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30006_MSG);
                return map;
            }
            Optional.ofNullable(content).ifPresent(circleItem::setContent);
            if (content == null) {
                map.put(Constants.ERROR_CODE, PgConstants.PG_ERROR_CODE_30007);
                map.put(Constants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30007_MSG);
                return map;
            }
            circleItem.setCreateTime(new Date().getTime());
            save(circleItem);
            map.put(Constants.STATE, Constants.SUCCESS);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Constants.STATE, Constants.ERROR_500);
            return map;
        }
    }

    @Override
    public Map<String, Object> circleItemList(Integer max) {
        Map<String, Object> map = new HashMap<>();
        try {
            Optional.ofNullable(max).orElse(10);
            List<CircleItem> list = circleItemMapper.circleItemList(max);
            map.put(Constants.STATE, Constants.SUCCESS);
            map.put(PgConstants.PG_RESULT, list);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Constants.STATE, Constants.ERROR_500);
            return map;
        }
    }
}
