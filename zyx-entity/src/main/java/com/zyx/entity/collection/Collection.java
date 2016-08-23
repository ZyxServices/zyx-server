package com.zyx.entity.collection;

import com.zyx.entity.BaseEntity;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Created by MrDeng on 2016/8/16.
 *
 * 收藏表
 */
@Table(name = "t_collection")
public class Collection extends BaseEntity{

    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer userId;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer model;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer modelId;

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public void setModel(Integer model) {
        this.model = model;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getModel() {
        return model;
    }

    public Integer getModelId() {
        return modelId;
    }
}
