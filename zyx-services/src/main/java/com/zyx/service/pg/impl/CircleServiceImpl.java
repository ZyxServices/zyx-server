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
    public Map<String, Object> insertCircle(String title, Integer createId, Integer state, Integer type, String details, String headImgUrl) {
        Map<String, Object> map = new HashMap<>();
        try {
            Circle insertCircle = new Circle();
            Optional.ofNullable(title).ifPresent(insertCircle::setTitle);
            Optional.ofNullable(createId).ifPresent(insertCircle::setCreate_id);
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

    @Override
    public Map<String, Object> setMaster(Integer circle_id, Integer master_id, Integer account_id) {
        Integer result = circleMapper.setMaster(circle_id, master_id, account_id);
        Map<String, Object> resultMap = new HashMap<>();
        if(circle_id==null){
            resultMap.put(Constants.MSG_ERROR,PgConstants.PG_ERROR_CODE_30001_MSG);
            return resultMap;
        }if(master_id==null){
            resultMap.put(Constants.MSG_ERROR,PgConstants.PG_ERROR_CODE_30002_MSG);
            return resultMap;
        }  if(account_id==null){
            resultMap.put(Constants.MSG_ERROR,PgConstants.PG_ERROR_CODE_30003_MSG);
            return resultMap;
        }
        result = circleMapper.setMaster(circle_id, master_id, account_id);
        if (result > 0) {
            resultMap.put(Constants.STATE, Constants.SUCCESS);
            return resultMap;
        } else {
            resultMap.put(Constants.STATE, Constants.ERROR_500);
            return resultMap;
        }
    }
}
