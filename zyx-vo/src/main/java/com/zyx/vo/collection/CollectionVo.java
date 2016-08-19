package com.zyx.vo.collection;

import com.zyx.entity.activity.vo.ActivityVo;
import com.zyx.vo.live.LiveInfoVo;

/**
 * Created by MrDeng on 2016/8/18.
 */
public class CollectionVo {
    private Integer usrId;
    private Integer model;
    private Integer modelId;
    private LiveInfoVo liveInfoVo;
    private ActivityVo activityVo;
    TempVO temp;
    class TempVO{
        private Integer model;
        private Integer modelId;
    }
    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }
    public void setModel(Integer model) {
        this.model = model;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Integer getUsrId() {
        return usrId;
    }

    public Integer getModel() {
        return model;
    }

    public Integer getModelId() {
        return modelId;
    }
}
