package com.zyx.entity;

import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by SubDong on 16-6-28.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title Devaluation
 * @package com.zyx.entity
 * @update 16-6-28 下午2:42
 */
@Table(name = "devaluation")
public class Devaluation extends BaseEntity implements Serializable{

    
	 /**serialVersionUID TODO*/ 
	
	private static final long serialVersionUID = 8846690488192906727L;
	/**
     * 对面模块类型 1、活动，2,直播，3,圈子，4动态，5用户
     */
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer types;

    /**
     * 对应模块首推数据ID
     */
    @Column(name = "devaluation_id")
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer devaluationId;

    @Column(name = "image")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String image;

    public Integer getTypes() {
        return types;
    }

    public void setTypes(Integer types) {
        this.types = types;
    }

    public Integer getDevaluationId() {
        return devaluationId;
    }

    public void setDevaluationId(Integer devaluationId) {
        this.devaluationId = devaluationId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Devaluation{" +
                "types=" + types +
                ", devaluationId=" + devaluationId +
                ", image='" + image + '\'' +
                '}';
    }
}
