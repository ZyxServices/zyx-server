package com.zyx.vo.pg;

import com.zyx.entity.pg.Circle;

import java.io.Serializable;

/**
 * Created by MrDeng on 2016/9/1.
 */
public class DevaCircleVo implements Serializable{

    private Integer id;
    private Long createTime;
    private String title;
    private Integer createId;
    private Integer type;//圈子类型,0未普通圈子，1位明星圈子
    private String headImgUrl;
    private Integer top;//1位置顶，其他都为不置顶
    private Integer hot;//热度
    private Integer circleItemCount;

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Integer getCircleItemCount() {
        return circleItemCount;
    }

    public void setCircleItemCount(Integer circleItemCount) {
        this.circleItemCount = circleItemCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }
}
