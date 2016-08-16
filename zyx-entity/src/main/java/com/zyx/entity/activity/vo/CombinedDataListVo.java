package com.zyx.entity.activity.vo;

import com.zyx.entity.BaseEntity;
import com.zyx.entity.activity.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rainbow on 2016/8/16.
 */
public class CombinedDataListVo extends BaseEntity {

    /**
     * 组合id
     */
    private Integer combinedId;

    /**
     * 组合名称
     */
    private String name;

    /**
     * 组合照片
     */
    private String image;

    /**
     * 数据ID（活动ID）
     */
    private List<ActivityVo> activityVos;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<ActivityVo> getActivityVos() {
        if(activityVos == null){
            activityVos = new ArrayList<>();
        }
        return activityVos;
    }

    public void setActivityVos(List<ActivityVo> activityVos) {
        this.activityVos = activityVos;
    }

    public Integer getMask() {
        return mask;
    }

    public void setMask(Integer mask) {
        this.mask = mask;
    }

    @Override
    public String toString() {
        return "CombinedDataListVo{" +
                "combinedId=" + combinedId +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", activityVos=" + activityVos +
                ", mask=" + mask +
                '}';
    }
}
