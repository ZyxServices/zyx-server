package com.zyx.service.activity.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.activity.ActivityConstants;
import com.zyx.entity.Devaluation;
import com.zyx.entity.activity.Activity;
import com.zyx.mapper.activity.ActivityMapper;
import com.zyx.mapper.activity.DevaluationMapper;
import com.zyx.service.activity.ActivityDevaluationService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by SubDong on 16-6-28.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title ActivityDevaluationServiceImpl
 * @package com.zyx.service.activity.impl
 * @update 16-6-28 下午3:19
 */
@Service
public class ActivityDevaluationServiceImpl implements ActivityDevaluationService {

    @Resource
    private DevaluationMapper devaluationMapper;
    @Resource
    private ActivityMapper activityMapper;
    @Resource
    private RedisTemplate<String, Map> redisTemplate;


    @Override
    public Map<String, Object> queryActivityDeva() {

        Map<String, Object> map = new HashMap<>();
        List<Devaluation> devaluations = devaluationMapper.queryDevaluation(1);
        if (devaluations.size() > 0) {
            List<Integer> longs = new ArrayList<>();
            devaluations.forEach(e -> longs.add(e.getDevaluationId()));
            List<Activity> activities = activityMapper.queryActivityDevaluation(longs);
            if (activities.size() > 0) {
                map.put(Constants.STATE, Constants.SUCCESS);
                map.put(Constants.SUCCESS_MSG, activities);
            } else {
                map.put(Constants.STATE, ActivityConstants.AUTH_ERROR_10002);
                map.put(Constants.ERROR_MSG, "查无数据");
            }
        } else {
            map.put(Constants.STATE, ActivityConstants.AUTH_ERROR_10002);
            map.put(Constants.ERROR_MSG, "查无数据");
        }
        return map;
    }

    @Override
    public Map<String, Object> insterActivityDeva(Devaluation devaluation) {
        Map<String, Object> map = new HashMap<>();
        if (devaluation.getTypes() != null && devaluation.getDevaluationId() != null) {
            devaluation.setCreateTime(new Date().getTime());
            int insert = devaluationMapper.insert(devaluation);
            if (insert > 0) {
                map.put(Constants.STATE, Constants.SUCCESS);
                map.put(Constants.SUCCESS_MSG, "首推成功");
                redisTemplate.delete(ActivityConstants.stringsDeva);
            } else {
                map.put(Constants.STATE, Constants.ERROR);
                map.put(Constants.ERROR_MSG, "首推失败");
            }
        } else {
            map.put(Constants.STATE, Constants.PARAM_MISS);
            map.put(Constants.ERROR_MSG, "参数缺失");
        }
        return map;
    }

    @Override
    public Map<String, Object> delActivityDeva(Devaluation devaluation) {
        Map<String, Object> map = new HashMap<>();

        if (devaluation.getDevaluationId() != null && devaluation.getTypes() != null) {
            int del = devaluationMapper.deleteDevaluation(devaluation);
            if (del > 0) {
                map.put(Constants.STATE, Constants.SUCCESS);
                map.put(Constants.SUCCESS_MSG, "取消首推成功");
                redisTemplate.delete(ActivityConstants.stringsDeva);
            } else {
                map.put(Constants.STATE, Constants.ERROR);
                map.put(Constants.ERROR_MSG, "取消首推失败");
            }
        } else {
            map.put(Constants.STATE, Constants.PARAM_MISS);
            map.put(Constants.ERROR_MSG, "参数缺失");
        }
        return map;
    }
}
