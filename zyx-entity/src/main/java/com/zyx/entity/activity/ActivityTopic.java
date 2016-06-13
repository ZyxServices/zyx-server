package com.zyx.entity.activity;

import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by Rainbow on 16-6-12.
 *
 * 活动(动态)
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title com.zyx.entity.activity
 */
public class ActivityTopic {

    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer id;

    /**
     * 用户ID
     */
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer userId;

    /**
     * 动态类型 3 活动
     */
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer type;

    /**
     * 动态标题
     */
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String topicTitle;

    /**
     * 动态内容
     */
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String topicContent;

    /**
     * 动态发布时间
     */
    @Column
    @ColumnType(jdbcType = JdbcType.DATE)
    private Date topicDate;

    /**
     * 浏览数
     */
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer browseNumber;

    /**
     * 点赞数
     */
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer Praise;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
    }

    public Date getTopicDate() {
        return topicDate;
    }

    public void setTopicDate(Date topicDate) {
        this.topicDate = topicDate;
    }

    public Integer getBrowseNumber() {
        return browseNumber;
    }

    public void setBrowseNumber(Integer browseNumber) {
        this.browseNumber = browseNumber;
    }

    public Integer getPraise() {
        return Praise;
    }

    public void setPraise(Integer praise) {
        Praise = praise;
    }

    @Override
    public String toString() {
        return "ActivityTopic{" +
                "id=" + id +
                ", userId=" + userId +
                ", type=" + type +
                ", topicTitle='" + topicTitle + '\'' +
                ", topicContent='" + topicContent + '\'' +
                ", topicDate=" + topicDate +
                ", browseNumber=" + browseNumber +
                ", Praise=" + Praise +
                '}';
    }
}
