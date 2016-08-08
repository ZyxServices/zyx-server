package com.zyx.entity.live;

import com.zyx.entity.BaseEntity;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;

/**
 * Created by MrDeng on 2016/7/18.
 */
public class LiveLab extends BaseEntity {
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String lab;
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String desc;

    public void setLab(String lab) {
        this.lab = lab;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLab() {
        return lab;
    }
    public String getDesc() {
        return desc;
    }
}
