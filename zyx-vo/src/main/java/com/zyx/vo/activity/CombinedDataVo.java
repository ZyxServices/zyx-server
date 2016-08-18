package com.zyx.vo.activity;

/**
 * Created by Rainbow on 2016/8/16.
 */
public class CombinedDataVo {

    /** 主键ID **/
    private Integer id;

    /** 创建时间 **/
    private Long createTime;
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
        return "CombinedDataVo{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", combinedId=" + combinedId +
                ", activityVo=" + activityVo +
                ", mask=" + mask +
                '}';
    }
}
