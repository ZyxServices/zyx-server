package com.zyx.vo.activity;

import java.io.Serializable;

/**
 * Created by SubDong on 16-6-14.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title QueryMemberParm
 * @package com.zyx.entity.activity.parm
 * @update 16-6-14 下午5:01
 */
public class QueryMemberVo implements Serializable {

    private Integer id;
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
     * 用户头像
     */
    private String avatar;

    /**
     * 报名时间
     */
    private Long joinTime;

    /**
     * 审核状态（默认为审核通过，如果发起者开启审核则不同）
     * true 通过， false 未通过
     */
    private int examineType;

    /**
     * 报名者联系电话
     */
    private String phone;

    /**
     * 报名者详细信息
     */
    private String memberInfo;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 出生日期
     */
    private Long birthday;

    /**
     * 是否屏蔽 （0正常 1屏蔽）
     */
    private Integer mask;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Long getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Long joinTime) {
        this.joinTime = joinTime;
    }

    public int getExamineType() {
        return examineType;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setExamineType(int examineType) {
        this.examineType = examineType;
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public Integer getMask() {
        return mask;
    }

    public void setMask(Integer mask) {
        this.mask = mask;
    }

    @Override
    public String toString() {
        return "QueryMemberVo{" +
                "id=" + id +
                ", activityId=" + activityId +
                ", userId=" + userId +
                ", userNick='" + userNick + '\'' +
                ", avatar='" + avatar + '\'' +
                ", joinTime=" + joinTime +
                ", examineType=" + examineType +
                ", phone='" + phone + '\'' +
                ", memberInfo='" + memberInfo + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", mask=" + mask +
                '}';
    }
}
