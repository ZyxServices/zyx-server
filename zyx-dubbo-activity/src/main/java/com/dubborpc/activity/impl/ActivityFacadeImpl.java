package com.dubborpc.activity.impl;

import com.dubborpc.activity.ActivityFacade;
import com.zyx.entity.activity.parm.QueryActivityParm;
import com.zyx.service.activity.ActivityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Rainbow on 16-6-12.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title com.dubborpc.activity.impl
 */
@Service("activityFacade")
public class ActivityFacadeImpl implements ActivityFacade {

    @Resource
    private ActivityService activityService;

    @Override
    public Map<String, Object> insertActivity(Integer createId, String title, String desc, String image, Long startTime,
                                              Long endTime, Long lastTime, Integer maxPeople, Integer visible,
                                              String phone, Double price, Integer type, String address, Integer examine,
                                              String memberTemplate) {
        return activityService.insterActivity(createId, title, desc, image, startTime, endTime, lastTime, maxPeople, visible, phone, price, type, address, examine, memberTemplate);
    }

    @Override
    public Map<String, Object> queryActivity(QueryActivityParm parm) {
        return activityService.queryActivity(parm);
    }

    @Override
    public Map<String, Object> queryActivityMember(Integer id) {
        return activityService.queryActivityMember(id);
    }
}
