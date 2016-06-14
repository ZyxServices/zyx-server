package com.zyx.entity.pg;

import com.zyx.entity.BaseEntity;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by XiaoWei on 2016/6/13.
 */
@Table(name = "circle")
public class Circle extends BaseEntity {
    private static final long serialVersionUID = 1L;
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String title;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer create_id;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer state;
    //    private String circleMaster;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer circle_master_id;
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String details;
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String head_img_url;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCreate_id() {
        return create_id;
    }

    public void setCreate_id(Integer create_id) {
        this.create_id = create_id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCircle_master_id() {
        return circle_master_id;
    }

    public void setCircle_master_id(Integer circle_master_id) {
        this.circle_master_id = circle_master_id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getHead_img_url() {
        return head_img_url;
    }

    public void setHead_img_url(String head_img_url) {
        this.head_img_url = head_img_url;
    }
}
