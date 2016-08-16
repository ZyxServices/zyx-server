package com.zyx.entity.activity;

import com.zyx.entity.BaseEntity;

/**
 * Created by Rainbow on 2016/8/16.
 */
public class CombinedData extends BaseEntity {

    /**
     * 组合id
     */
    private Integer combinedId;

    /**
     * 数据ID（活动ID）
     */
    private Integer dataId;

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

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public Integer getMask() {
        return mask;
    }

    public void setMask(Integer mask) {
        this.mask = mask;
    }

    @Override
    public String toString() {
        return "CombinedData{" +
                "combinedId=" + combinedId +
                ", dataId=" + dataId +
                ", mask=" + mask +
                '}';
    }
}
