package com.zyx.rpc.activity.impl;

import com.zyx.entity.Devaluation;
import com.zyx.entity.activity.Activity;
import com.zyx.rpc.activity.ActivityDevaFacade;
import com.zyx.rpc.activity.utils.ActivityUtils;
import com.zyx.service.activity.ActivityDevaluationService;
import com.zyx.service.activity.ActivityService;
import org.apache.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by SubDong on 16-6-28.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title ActivityDevaFacadeImpl
 * @package com.zyx.rpc.activity.impl
 * @update 16-6-28 下午3:35
 */
@Service("activityDevaFacade")
public class ActivityDevaFacadeImpl implements ActivityDevaFacade {

    @Resource
    private ActivityDevaluationService activityDevaluationService;
    @Resource
    private RedisTemplate<String, List<Activity>> redisTemplate;

    private static Logger logger = Logger.getLogger(ActivityFacadeImpl.class);

    @Override
    public List<Activity>  queryActivityDeva() {
            return activityDevaluationService.queryActivityDeva();
      
    }

    @Override
    public Map<String, Object> insterActivityDeva(Devaluation devaluation) {
        try {
            return activityDevaluationService.insterActivityDeva(devaluation);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return ActivityUtils.Error500();
        }
    }

    @Override
    public Map<String, Object> delActivityDeva(Devaluation devaluation) {
        try {
            return activityDevaluationService.delActivityDeva(devaluation);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return ActivityUtils.Error500();
        }
    }
}
