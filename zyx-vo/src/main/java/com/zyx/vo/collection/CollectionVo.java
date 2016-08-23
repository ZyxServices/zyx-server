package com.zyx.vo.collection;

import com.zyx.vo.live.LiveInfoVo;

/**
 * Created by MrDeng on 2016/8/18.
 */
public class CollectionVo {
    private Integer userId;
    private Integer model;
    private Integer modelId;
    private LiveInfoVo liveInfoVo;
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
