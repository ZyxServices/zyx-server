package com.zyx.rpc.activity.impl;

import com.zyx.constants.Constants;
import com.zyx.entity.activity.parm.QueryHistoryParm;
import com.zyx.rpc.activity.ActivityFacade;
import com.zyx.entity.activity.parm.QueryActivityParm;
import com.zyx.service.activity.ActivityService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
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
                                              String memberTemplate) {
        return activityService.insterActivity(createId, title, desc, image, startTime, endTime, lastTime, maxPeople, visible, phone, price, type, address, examine, memberTemplate);
    }

    @Override
    public Map<String, Object> queryActivity(QueryActivityParm parm) {
        try {
            return activityService.queryActivity(parm);
        } catch (Exception e) {
            logger.error(e);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(Constants.STATE, Constants.ERROR_500);
            map.put(Constants.ERROR_MSG, Constants.MSG_ERROR);
            return map;
        }
    }

    @Override
    public Map<String, Object> queryActivityMember(Integer id) {
        try {
            return activityService.queryActivityMember(id);
        } catch (Exception e) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(Constants.STATE, Constants.ERROR_500);
            map.put(Constants.ERROR_MSG, Constants.MSG_ERROR);
            logger.error(e);
            return map;
        }
    }

    @Override
    public Map<String, Object> queryActivityHistory(QueryHistoryParm history) {
        try {
            return activityService.queryActivityHistory(history);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> map = new HashMap<String, Object>();
            logger.error(e);
            map.put(Constants.STATE, Constants.ERROR_500);
            map.put(Constants.ERROR_MSG, Constants.MSG_ERROR);
            return map;
        }
    }
}
