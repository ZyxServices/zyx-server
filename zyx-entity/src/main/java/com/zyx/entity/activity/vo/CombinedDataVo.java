package com.zyx.entity.activity.vo;

import com.zyx.entity.BaseEntity;
import com.zyx.entity.activity.Activity;

/**
 * Created by Rainbow on 2016/8/16.
 */
public class CombinedDataVo extends BaseEntity {

    /**
     * 组合id
     */
    private Integer combinedId;

    private ActivityVo activityVo;

    /**
     * 是否屏蔽 （0 正常 1 屏蔽）
     */
    private Integer mask;

    public Integer getCombinedId() {
        return combinedId;
    }

    public void setCombinedId(Integer combinedId) {
        this.combinedId = combinedId;
    }

    public ActivityVo getActivityVo() {
        return activityVo;
    }

    public void setActivityVo(ActivityVo activityVo) {
        this.activityVo = activityVo;
    }

    public Integer getMask() {
        return mask;
    }

    public void setMask(Integer mask) {
        this.mask = mask;
    }

    @Override
    public String toString() {
        return "CombinedDataVo{" +
                "combinedId=" + combinedId +
                ", activityVo=" + activityVo +
                ", mask=" + mask +
                '}';
    }
}
