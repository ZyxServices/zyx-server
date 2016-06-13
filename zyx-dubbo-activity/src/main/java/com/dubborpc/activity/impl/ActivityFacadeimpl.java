package com.dubborpc.activity.impl;

import com.dubborpc.activity.ActivityFacade;
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
public class ActivityFacadeimpl implements ActivityFacade {

    @Resource
    private ActivityService activityService;

    @Override
    public Map<String, Object> insertActivity(String title, String desc, String image, String startTime, String endTime, String lastTime, String maxPeople,
                                              String visible, String phone, String price, String type, String address, String examine, String memberTemplate) {
        return activityService.insterActivity(title, desc, image, startTime, endTime, lastTime, maxPeople, visible, phone, price, type, address, examine, memberTemplate);
    }
}
