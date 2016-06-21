package com.zyx.service.pg.impl;

import java.util.*;

import com.zyx.constants.Constants;
import com.zyx.constants.pg.PgConstants;
import com.zyx.entity.pg.Meet;
import com.zyx.mapper.pg.CircleMapper;
import com.zyx.service.pg.MeetService;
import org.springframework.stereotype.Service;

import com.zyx.entity.pg.Circle;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.pg.CircleService;

import javax.annotation.Resource;

/**
 * Created by XiaoWei on 2016/6/13.
 */
@Service
public class CircleServiceImpl extends BaseServiceImpl<Circle> implements CircleService {
    @Resource
    private MeetService meetService;
    @Resource
    CircleMapper circleMapper;

    @Override
    public Map<String, Object> insertCircle(String title, Integer createId, Integer circleMasterId, Integer state, Integer type, String details, String headImgUrl) {
        Map<String, Object> map = new HashMap<>();
        try {
            Circle insertCircle = new Circle();
            Optional.ofNullable(title).ifPresent(insertCircle::setTitle);
            Optional.ofNullable(createId).ifPresent(insertCircle::setCreate_id);
            Optional.ofNullable(circleMasterId).ifPresent(insertCircle::setCircle_master_id);
            Optional.ofNullable(state).ifPresent(insertCircle::setState);
            Optional.ofNullable(type).ifPresent(insertCircle::setType);
            Optional.ofNullable(details).ifPresent(insertCircle::setDetails);
            Optional.ofNullable(headImgUrl).ifPresent(insertCircle::setHead_img_url);
            insertCircle.setCreateTime(new Date().getTime());
            insertCircle.setState(0);
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
        return meetService.addMeet(circleId, accountId);
    }

    @Override
    public Map<String, Object> circleList(Integer max) {
        Map<String, Object> map = new HashMap<>();
        try {
            Optional.ofNullable(max).orElse(10);
            List<Circle> list = circleMapper.circleList(max);
            map.put(Constants.STATE, Constants.SUCCESS);
            map.put(PgConstants.PG_RESULT, list);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Constants.STATE, Constants.ERROR_500);
        }
        return map;
    }
}
