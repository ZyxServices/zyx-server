package com.zyx.entity.system;

import com.zyx.entity.BaseEntity;
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
     * 对面模块类型 1、活动，2,直播，3,圈子，4动态，5用户，6帖子
     */
    @Column(name = "model")
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer model;
    /**
     * 对应模块首推数据ID
     */
    @Column(name = "model_id")
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer modelId;

    @Column(name = "image_url")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String imageUrl;
    @Column(name = "area")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private Integer area;//默认1,2为操场模块推荐

    public void setModel(Integer model) {
        this.model = model;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Integer getModel() {
        return model;
    }

    public Integer getModelId() {
        return modelId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getArea() {
        return area;
    }
}
