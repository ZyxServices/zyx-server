package com.dubborpc.activity;

import com.zyx.entity.activity.parm.QueryActivityParm;

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
     *
     * @param createId       创建者ID
     * @param title          活动标题
     * @param desc           活动描述内容
     * @param image          活动图片
     * @param startTime      活动开始时间
     * @param endTime        活动结束时间
     * @param lastTime       活动报名结束时间
     * @param maxPeople      活动人数上线
     * @param visible        活动可见范围（0,所有人可见  1,朋友可见）
     * @param phone          发起人联系电话
     * @param price          活动价格
     * @param type           活动类型：线上或者线下(0 线上活动, 1线下活动)
     * @param address        活动地址
     * @param examine        是否需要审核（主要用户发起者审核报名者,0 不要需要审核, 1需要审核）
     * @param memberTemplate 报名活动模版
     * @return
     */
    Map<String,Object> insertActivity(Integer createId, String title, String desc, String image, Long startTime,
                                      Long endTime, Long lastTime, Integer maxPeople, Integer visible,
                                      String phone, Double price, Integer type, String address, Integer examine,
                                      String memberTemplate);

    /**
     * 多条条件查询活动
     * @param parm
     * @return
     */
    Map<String, Object> queryActivity(QueryActivityParm parm);
}
