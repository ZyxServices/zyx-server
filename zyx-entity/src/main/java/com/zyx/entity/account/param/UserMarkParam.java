package com.zyx.entity.account.param;

import java.io.Serializable;

/**
 * Created by WeiMinSheng on 2016/6/16.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title UserMarkParam.java
 */
public class UserMarkParam implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String token;

    private Integer userId;

    private Long markTime;

    private String markHistory;

    private Integer markCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getMarkTime() {
        return markTime;
    }

    public void setMarkTime(Long markTime) {
        this.markTime = markTime;
    }

    public String getMarkHistory() {
        return markHistory;
    }

    public void setMarkHistory(String markHistory) {
        this.markHistory = markHistory;
    }

    public Integer getMarkCount() {
        return markCount;
    }

    public void setMarkCount(Integer markCount) {
        this.markCount = markCount;
    }
}
