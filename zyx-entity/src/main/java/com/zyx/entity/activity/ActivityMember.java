package com.zyx.entity.activity;

import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by Rainbow on 16-6-12.
 *
 * 活动报名者
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title com.zyx.entity.activity
 */
public class ActivityMember {

    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer id;

    /**
     * 活动ID
     */
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer activityId;

    /**
     * 用户ID
     */
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer userId;

    /**
     * 用户昵称
     */
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String userNick;

    /**
     * 报名时间
     */
    @Column
    @ColumnType(jdbcType = JdbcType.DATE)
    private Date joinTime;

    /**
     * 审核状态（默认为审核通过，如果发起者开启审核则不同）
     * true 通过， false 未通过
     */
    @Column
    @ColumnType(jdbcType = JdbcType.BOOLEAN)
    private boolean examineType;

    /**
     * 报名者联系电话
     */
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String phone;

    /**
     * 报名者详细信息
     */
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String memberInfo;

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

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public boolean isExamineType() {
        return examineType;
    }

    public void setExamineType(boolean examineType) {
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

    @Override
    public String toString() {
        return "ActivityMember{" +
                "id=" + id +
                ", activityId=" + activityId +
                ", userId=" + userId +
                ", userNick='" + userNick + '\'' +
                ", joinTime=" + joinTime +
                ", examineType=" + examineType +
                ", phone='" + phone + '\'' +
                ", memberInfo='" + memberInfo + '\'' +
                '}';
    }
}
