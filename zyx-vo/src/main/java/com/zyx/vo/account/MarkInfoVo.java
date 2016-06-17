package com.zyx.vo.account;

import com.zyx.vo.BaseVo;

/**
 * Created by WeiMinSheng on 2016/6/16.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title MarkInfoVo.java
 */
public class MarkInfoVo extends BaseVo {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer userId;

    private Long markTime;

    private Integer markCount;

    private String markHistory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getMarkCount() {
        return markCount;
    }

    public void setMarkCount(Integer markCount) {
        this.markCount = markCount;
    }

    public String getMarkHistory() {
        return markHistory;
    }

    public void setMarkHistory(String markHistory) {
        this.markHistory = markHistory;
    }
}
