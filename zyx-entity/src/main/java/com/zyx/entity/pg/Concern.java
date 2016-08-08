package com.zyx.entity.pg;

import com.zyx.entity.BaseEntity;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by XiaoWei on 2016/6/3.
 */
@Table(name = "concern")
public class Concern extends BaseEntity {
    private static final long serialVersionUID = 1L;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer userId;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer type;//动态类型1为个人动态，2为活动动态，3为明星动态，4为圈子动态
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String topicTitle;
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String topicContent;
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String imgUrl;
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String videoUrl;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer topicVisible;//0所有可见，1好友可见
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer state;//动态状态，-2未屏蔽，-1为删除

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Integer getTopicVisible() {
        return topicVisible;
    }

    public void setTopicVisible(Integer topicVisible) {
        this.topicVisible = topicVisible;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
