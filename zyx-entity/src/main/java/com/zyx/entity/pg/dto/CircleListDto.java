package com.zyx.entity.pg.dto;

import java.io.Serializable;

/**
 * Created by wms on 2016/8/11.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title CircleListDto.java
 */
public class CircleListDto implements Serializable {
    private static final long serialVersionUID = 6886892223576540427L;
    private Integer id;
    private String title;
    private String details;
    private String headImgUrl;
    private Integer circleItemCount;

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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public Integer getCircleItemCount() {
        return circleItemCount;
    }

    public void setCircleItemCount(Integer circleItemCount) {
        this.circleItemCount = circleItemCount;
    }
}
