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
            if (title == null || Objects.equals(title, "")) {
                map.put(Constants.ERROR_CODE, PgConstants.PG_ERROR_CODE_30006);
                map.put(Constants.ERROR_CODE, PgConstants.PG_ERROR_CODE_30006_MSG);
                return map;
            }
            Optional.ofNullable(title).ifPresent(insertCircle::setTitle);
            if (createId == null || Objects.equals(createId, "")) {
                map.put(Constants.ERROR_CODE, PgConstants.PG_ERROR_CODE_30005);
                map.put(Constants.ERROR_CODE, PgConstants.PG_ERROR_CODE_30005_MSG);
                return map;
            }
            Optional.ofNullable(createId).ifPresent(insertCircle::setCreate_id);
            if (state == null) {
                map.put(Constants.ERROR_CODE, PgConstants.PG_ERROR_CODE_30005);
                map.put(Constants.ERROR_CODE, PgConstants.PG_ERROR_CODE_30005_MSG);
                return map;
            }
            if (state == null) {
                map.put(Constants.ERROR_CODE, PgConstants.PG_ERROR_CODE_30011);
                map.put(Constants.ERROR_CODE, PgConstants.PG_ERROR_CODE_30011_MSG);
                return map;
            }
            Optional.ofNullable(state).ifPresent(insertCircle::setState);
            if (type == null) {
                map.put(Constants.ERROR_CODE, PgConstants.PG_ERROR_CODE_30012);
                map.put(Constants.ERROR_CODE, PgConstants.PG_ERROR_CODE_30012_MSG);
                return map;
            }
            Optional.ofNullable(type).ifPresent(insertCircle::setType);
            if (details==null||Objects.equals(details,"")){
                map.put(Constants.ERROR_CODE, PgConstants.PG_ERROR_CODE_30010);
                map.put(Constants.ERROR_CODE, PgConstants.PG_ERROR_CODE_30010_MSG);
                return map;
            }
            Optional.ofNullable(details).ifPresent(insertCircle::setDetails);
            if (headImgUrl==null||Objects.equals(headImgUrl,"")){
                map.put(Constants.ERROR_CODE, PgConstants.PG_ERROR_CODE_30013);
                map.put(Constants.ERROR_CODE, PgConstants.PG_ERROR_CODE_30013_MSG);
                return map;
            }
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
        Map<String, Object> resultMap = new HashMap<>();
        if (circle_id == null) {
            resultMap.put(Constants.MSG_ERROR, PgConstants.PG_ERROR_CODE_30001_MSG);
            return resultMap;
        }
        if (master_id == null) {
            resultMap.put(Constants.MSG_ERROR, PgConstants.PG_ERROR_CODE_30002_MSG);
            return resultMap;
        }
        if (account_id == null) {
            resultMap.put(Constants.MSG_ERROR, PgConstants.PG_ERROR_CODE_30003_MSG);
            return resultMap;
        }
        Circle existCircle = circleMapper.existMaster(circle_id, master_id);
        if (existCircle != null) {
            resultMap.put(Constants.MSG_ERROR, PgConstants.PG_ERROR_CODE_30004_MSG);
            return resultMap;
        }
        Integer result = circleMapper.setMaster(circle_id, master_id, account_id);
        if (result > 0) {
            resultMap.put(Constants.STATE, Constants.SUCCESS);
            return resultMap;
        } else {
            resultMap.put(Constants.STATE, Constants.ERROR_500);
            return resultMap;
        }
    }

    @Override
    public Map<String, Object> delete(Integer circle_id) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            Integer result = circleMapper.deleteCircle(circle_id);
            if (result > 0) {
                resultMap.put(Constants.STATE, Constants.SUCCESS);
                return resultMap;
            } else {
                resultMap.put(Constants.STATE, Constants.ERROR);
                return resultMap;
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put(Constants.STATE, Constants.ERROR_500);
            return resultMap;
        }
    }

    @Override
    public Map<String, Object> setTop(Integer circle_id) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            Optional.ofNullable(circle_id).orElse(-1);
            Integer result = circleMapper.setTop(circle_id);
            if (result > 0) {
                resultMap.put(Constants.STATE, Constants.SUCCESS);
            } else {
                resultMap.put(Constants.STATE, Constants.PARAM_MISS);
            }
            return resultMap;
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put(Constants.STATE, Constants.ERROR_500);
            return resultMap;
        }
    }

    @Override
    public Map<String, Object> top(Integer max) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            Optional.ofNullable(max).orElse(3);
            List<Circle> topList = circleMapper.top(max);
            resultMap.put(Constants.STATE, Constants.SUCCESS);
            resultMap.put(PgConstants.PG_RESULT, topList);
            return resultMap;
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put(Constants.STATE, Constants.ERROR_500);
            return resultMap;
        }
    }
}
