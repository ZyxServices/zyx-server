package com.zyx.service.pg.impl;

import com.zyx.constants.Constants;
import com.zyx.entity.pg.CircleItem;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.pg.CircleItemService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.service.pg.impl
 * Create by XiaoWei on 2016/6/21
 */
@Service
public class CircleItemServiceImpl extends BaseServiceImpl<CircleItem> implements CircleItemService {
    @Override
    public Map<String, Object> addCircleItem(Integer circle_id, Integer create_id, String title, String content) {
        Map<String, Object> map = new HashMap<>();
        try {
            CircleItem circleItem = new CircleItem();
            Optional.ofNullable(circle_id).ifPresent(circleItem::setCircle_id);
            Optional.ofNullable(create_id).ifPresent(circleItem::setCreate_id);
            Optional.ofNullable(title).ifPresent(circleItem::setTitle);
            Optional.ofNullable(content).ifPresent(circleItem::setContent);
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
}
