package com.zyx.entity.activity.parm;

import java.io.Serializable;

/**
 * Created by Rainbow on 16-6-14.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title com.zyx.entity.activity.parm
 */
public class AddMemberInfoParm implements Serializable{

    /**
     * 活动ID
     */
    private Integer activityId;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 用户昵称
     */
    private String userNick;

    /**
     * 报名者联系电话
     */
    private String phone;

    /**
     * 报名者详细信息
     */
    private String memberInfo;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMemberInfo() {
        return memberInfo;
    }

    public void setMemberInfo(String memberInfo) {
        this.memberInfo = memberInfo;
    }

    @Override
    public String toString() {
        return "AddMemberInfoParm{" +
                "activityId=" + activityId +
                ", userId=" + userId +
                ", userNick='" + userNick + '\'' +
                ", phone='" + phone + '\'' +
                ", memberInfo='" + memberInfo + '\'' +
                '}';
    }
}
