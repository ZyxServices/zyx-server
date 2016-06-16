package com.zyx.service.pg.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.zyx.constants.Constants;
import org.springframework.stereotype.Service;

import com.zyx.entity.pg.Circle;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.pg.CircleService;

/**
 * Created by XiaoWei on 2016/6/13.
 */
@Service
public class CircleServiceImpl extends BaseServiceImpl<Circle> implements CircleService {
    @Override
    public Map<String, Object> insertCircle(String title, Integer createId, Integer circleMasterId, String details, String headImgUrl) {
        Map<String, Object> map = new HashMap<>();
        try {
            Circle insertCircle = new Circle();
            Optional.ofNullable(title).ifPresent(insertCircle::setTitle);
            Optional.ofNullable(details).ifPresent(insertCircle::setDetails);
            Optional.ofNullable(createId).ifPresent(insertCircle::setCreate_id);
            Optional.ofNullable(circleMasterId).ifPresent(insertCircle::setCircle_master_id);
            mapper.insert(insertCircle);
            map.put(Constants.STATE, Constants.SUCCESS);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Constants.STATE, Constants.ERROR_500);
            return map;
        }
    }

    @Override
    public Map<String, Object> circleMeet(Integer accountId, Integer circleId) {
        return null;
    }
}
