package com.zyx.rpc.activity.impl;

import com.zyx.param.activity.QueryHistoryParm;
import com.zyx.rpc.activity.ActivityFacade;
import com.zyx.param.activity.QueryActivityParm;
import com.zyx.rpc.activity.utils.ActivityUtils;
import com.zyx.service.activity.ActivityService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Rainbow on 16-6-12.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title com.rpc.activity.impl
 */
@Service("activityFacade")
public class ActivityFacadeImpl implements ActivityFacade {

    @Resource
    private ActivityService activityService;

    private static Logger logger = Logger.getLogger(ActivityFacadeImpl.class);

    @Override
    public Map<String, Object> insertActivity(Integer createId, String title, String desc, String image, Long startTime,
                                              Long endTime, Long lastTime, Integer maxPeople, Integer visible,
                                              String phone, Double price, Integer type, String address, Integer examine,
                                              String memberTemplate, Long groupId) {
        try {
            return activityService.insterActivity(createId, title, desc, image, startTime, endTime, lastTime, maxPeople, visible, phone, price, type, address, examine, memberTemplate, groupId);
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
            return ActivityUtils.Error500();
        }
    }

    @Override
    public Map<String, Object> queryActivity(QueryActivityParm parm) {
        try {
            return activityService.queryActivity(parm);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return ActivityUtils.Error500();
        }
    }

    @Override
    public Map<String, Object> queryActivityMember(Integer id) {
        try {
            return activityService.queryActivityMember(id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return ActivityUtils.Error500();
        }
    }

    @Override
    public Map<String, Object> queryActivityGroupName(String name) {
        try {
            return activityService.queryActivityGroupName(name);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return ActivityUtils.Error500();
        }
    }

    @Override
    public Map<String, Object> queryActivityHistory(QueryHistoryParm history) {
        try {
            return activityService.queryActivityHistory(history);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return ActivityUtils.Error500();
        }
    }
}
