package com.zyx.vo.collection;

import java.io.Serializable;

/**
 * Created by MrDeng on 2016/8/18.
 */
public class CollectionVo implements Serializable {
    private Integer id;
    private Long createTime;
    private Integer userId;
    private Integer model;
    private Integer modelId;
//    private CollLiveVo liveInfoVo;
//    public CollLiveVo getLiveInfoVo() {
//        return liveInfoVo;
//    }
//    public void setLiveInfoVo(CollLiveVo liveInfoVo) {
//        this.liveInfoVo = liveInfoVo;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

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
