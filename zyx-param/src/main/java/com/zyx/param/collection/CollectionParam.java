package com.zyx.param.collection;

import com.zyx.param.BaseParam;

/**
 * Created by MrDeng on 2016/8/16.
 */
public class CollectionParam extends BaseParam {
    private Integer userId;
    private Integer model;
    private Integer modelId;

    public CollectionParam() {
    }

    public CollectionParam(Integer userId, Integer model) {
        this.userId = userId;
        this.model = model;
    }

    public CollectionParam(Integer userId, Integer model, Integer modelId) {
        this.userId = userId;
        this.model = model;
        this.modelId = modelId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getModel() {
        return model;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Integer getModelId() {
        return modelId;
    }
}
