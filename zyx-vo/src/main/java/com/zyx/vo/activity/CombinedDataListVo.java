package com.zyx.vo.activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rainbow on 2016/8/16.
 */
public class CombinedDataListVo {

    private Integer id;
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

    /** 创建时间 **/
    private Long createTime;

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

    @Override
    public String toString() {
        return "CombinedDataListVo{" +
                "id=" + id +
                ", combinedId=" + combinedId +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", activityVos=" + activityVos +
                ", mask=" + mask +
                ", createTime=" + createTime +
                '}';
    }
}
