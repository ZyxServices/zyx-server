package com.zyx.entity.activity;

import java.io.Serializable;

/**
 * Created by SubDong on 16-6-23.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title PageViews
 * @package com.zyx.sheduler.entity
 * @update 16-6-23 下午4:15
 */
public class PageViews implements Serializable{

    /**
     * 表ID
     */
    private Integer id;

    /**
     * 浏览量
     */
    private Integer pageviews;

    /**
     * 所属板块（0 直播  1 动态  2 活动  3 帖子  4 个人主页）
     */
    private Integer types;

    /**
     * 具体ID
     */
    private Integer typeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPageviews() {
        return pageviews;
    }

    public void setPageviews(Integer pageviews) {
        this.pageviews = pageviews;
    }

    public Integer getTypes() {
        return types;
    }

    public void setTypes(Integer types) {
        this.types = types;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "PageViews{" +
                "id=" + id +
                ", pageviews=" + pageviews +
                ", types=" + types +
                ", typeId=" + typeId +
                '}';
    }
}
