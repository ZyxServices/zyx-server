package com.zyx.service.activity.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.activity.ActivityConstants;
import com.zyx.entity.Devaluation;
import com.zyx.entity.activity.Activity;
import com.zyx.mapper.activity.ActivityMapper;
import com.zyx.mapper.activity.DevaluationMapper;
import com.zyx.service.activity.ActivityDevaluationService;
import com.zyx.utils.MapUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by SubDong on 16-6-28.
 *
 * @author SubDong
 * @version V1.0 Copyright (c)2016 tyj-版权所有
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
    private RedisTemplate<String, List<Activity>> redisTemplate;

    @Override
    public List<Activity> queryActivityDeva() {
        @SuppressWarnings("unchecked")
        List<Activity> devaluations1 = redisTemplate.opsForList().leftPop(ActivityConstants.ACTIVITY_DEVA);
        if (devaluations1 != null && devaluations1.size() > 0) {
            return devaluations1;
        } else {
            List<Devaluation> devaluations = devaluationMapper.queryDevaluation(1);
            if (devaluations.size() > 0) {
                List<Integer> longs = new ArrayList<>();
                devaluations.forEach(e -> longs.add(e.getDevaluationId()));
                List<Activity> activities = activityMapper.queryActivityDevaluation(longs);
                redisTemplate.opsForList().leftPush(ActivityConstants.ACTIVITY_DEVA, activities);
                return activities;
            } else {
                return null;
            }
        }
    }

    @Override
    public Map<String, Object> insterActivityDeva(Devaluation devaluation) {
        if (devaluation.getTypes() != null && devaluation.getDevaluationId() != null) {
            devaluation.setCreateTime(new Date().getTime());
            int insert = devaluationMapper.insert(devaluation);
            if (insert > 0) {
                deleteDeavRedis(devaluation);
                return MapUtils.buildSuccessMap(Constants.SUCCESS, "首推成功", null);
            } else {
                return MapUtils.buildErrorMap(Constants.ERROR, "首推失败");
            }
        } else {
            return MapUtils.buildErrorMap(Constants.PARAM_MISS, "参数缺失");
        }
    }

    @Override
    public Map<String, Object> delActivityDeva(Devaluation devaluation) {
        if (devaluation.getDevaluationId() != null && devaluation.getTypes() != null) {
            int del = devaluationMapper.deleteDevaluation(devaluation);
            if (del > 0) {
                deleteDeavRedis(devaluation);
                return MapUtils.buildSuccessMap(Constants.SUCCESS, "取消首推成功", null);
            } else {
                return MapUtils.buildErrorMap(Constants.ERROR, "取消首推失败");
            }
        } else {
            return MapUtils.buildErrorMap(Constants.PARAM_MISS, "参数缺失");
        }
    }

    private void deleteDeavRedis(Devaluation devaluation) {
        switch (devaluation.getTypes()) {
            case 1:
                redisTemplate.delete(Constants.ACTIVITY_DEVA);
                break;
            case 2:
                redisTemplate.delete(Constants.LIVE_DEVA);
                break;
            case 3:
                redisTemplate.delete(Constants.CIRLE_DEVA);
                break;
            case 4:
                redisTemplate.delete(Constants.CONCER_DEVA);
                break;
            case 5:
                redisTemplate.delete(Constants.ACCOUNT_DEVA);
                break;
        }
    }
}
