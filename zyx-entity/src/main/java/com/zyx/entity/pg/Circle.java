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
    private Integer createId;
    @Column
    @ColumnType(jdbcType = JdbcType.DATE)
    private Date createTime;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer state;
    //    private String circleMaster;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer circleMasterId;
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String details;
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String headImgUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCircleMasterId() {
        return circleMasterId;
    }

    public void setCircleMasterId(Integer circleMasterId) {
        this.circleMasterId = circleMasterId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }
}
