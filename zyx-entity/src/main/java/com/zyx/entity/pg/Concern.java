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
    private Integer type;
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String topicTitle;
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String topicContent;
    @Column
    @ColumnType(jdbcType = JdbcType.DATE)
    private Date topicDate;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer topicVisible;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer topicZan;

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

    public Integer getTopicVisible() {
        return topicVisible;
    }

    public void setTopicVisible(Integer topicVisible) {
        this.topicVisible = topicVisible;
    }

    public Integer getTopicZan() {
        return topicZan;
    }

    public void setTopicZan(Integer topicZan) {
        this.topicZan = topicZan;
    }
}
