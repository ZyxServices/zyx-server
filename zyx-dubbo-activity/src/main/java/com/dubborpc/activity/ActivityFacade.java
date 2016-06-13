package com.dubborpc.activity;

import java.util.Map;

/**
 * Created by Rainbow on 16-6-12.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title com.dubborpc.activity
 */
public interface ActivityFacade {
    /**
     * 发布活动
     * @param title
     * @param desc
     * @param image
     * @param startTime
     * @param endTime
     * @param lastTime
     * @param maxPeople
     * @param visible
     * @param phone
     * @param price
     * @param type
     * @param address
     * @param examine
     * @param memberTemplate
     * @return
     */
    Map<String,Object> insertActivity(String title, String desc, String image, String startTime, String endTime,
                                      String lastTime, String maxPeople, String visible, String phone, String price,
                                      String type, String address, String examine, String memberTemplate);
}
