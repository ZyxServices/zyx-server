package com.zyx.entity.activity;

import com.zyx.entity.BaseEntity;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.Table;
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
@Table(name = "activity_topic")
public class ActivityTopic extends BaseEntity {

    /**
     * 用户ID
     */
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer userId;

    /**
     * 活动id
     */
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer activityId;

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
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long topicDate;
    /**
     * 动态对应图片 每个图片以,号分割
     */
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String images;

    /**
     * 是否屏蔽
     */
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private String mask;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
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

    public Long getTopicDate() {
        return topicDate;
    }

    public void setTopicDate(Long topicDate) {
        this.topicDate = topicDate;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    @Override
    public String toString() {
        return "ActivityTopic{" +
                "userId=" + userId +
                ", activityId=" + activityId +
                ", type=" + type +
                ", topicTitle='" + topicTitle + '\'' +
                ", topicContent='" + topicContent + '\'' +
                ", topicDate=" + topicDate +
                ", images='" + images + '\'' +
                ", mask='" + mask + '\'' +
                '}';
    }
}
