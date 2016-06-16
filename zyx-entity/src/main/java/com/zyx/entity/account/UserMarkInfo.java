package com.zyx.entity.account;

import com.zyx.entity.BaseEntity;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;

/**
 * Created by WeiMinSheng on 2016/6/15.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title UserMarkInfo.java
 */
public class UserMarkInfo extends BaseEntity {

    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer userId;

    @Column
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long markTime;

    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String markString;

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

    public String getMarkString() {
        return markString;
    }

    public void setMarkString(String markString) {
        this.markString = markString;
    }
}
