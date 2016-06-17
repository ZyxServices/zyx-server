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
    private Integer user_id;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer type;
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String topic_title;
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String topic_content;
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String img_url;
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String video_url;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer topic_visible;


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getTopic_title() {
        return topic_title;
    }

    public void setTopic_title(String topic_title) {
        this.topic_title = topic_title;
    }

    public String getTopic_content() {
        return topic_content;
    }

    public void setTopic_content(String topic_content) {
        this.topic_content = topic_content;
    }


    public Integer getTopic_visible() {
        return topic_visible;
    }

    public void setTopic_visible(Integer topic_visible) {
        this.topic_visible = topic_visible;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }
}
