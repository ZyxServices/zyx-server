package com.zyx.vo.system;

import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;

/**
 * Created by MrDeng on 2016/9/22.
 */
public class BaseDevaVo implements Serializable {
    private Integer id;
    private Integer model;
//    private Integer modelId;
    private String imageUrl;
    private Integer sequence;
    private Integer area;//默认1,2为操场模块推荐
    private String bgmUrl;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

//    public Integer getModelId() {
//        return modelId;
//    }
//
//    public void setModelId(Integer modelId) {
//        this.modelId = modelId;
//    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getBgmUrl() {
        return bgmUrl;
    }

    public void setBgmUrl(String bgmUrl) {
        this.bgmUrl = bgmUrl;
    }
}
