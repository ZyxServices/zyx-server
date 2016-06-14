package com.zyx.service.pg.impl;

import com.zyx.constants.AuthConstants;
import com.zyx.entity.pg.Circle;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.pg.CircleService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
            map.put(AuthConstants.AUTH_SUCCESS, AuthConstants.AUTH_SUCCESS_200);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put(AuthConstants.AUTH_ERRORMSG, AuthConstants.AUTH_SUCCESS_500);
            return map;
        }
    }

    @Override
    public Map<String, Object> circleMeet(Integer accountId, Integer circleId) {
        return null;
    }
}
