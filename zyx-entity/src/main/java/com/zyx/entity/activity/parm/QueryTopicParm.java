package com.zyx.entity.activity.parm;

import java.io.Serializable;

/**
 * Created by SubDong on 16-6-16.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title QueryTopicParm
 * @package com.zyx.entity.activity.parm
 * @update 16-6-16 下午6:12
 */
public class QueryTopicParm implements Serializable {

    private Integer activityId;

    private Integer pageNumber;

    private Integer pages;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "QueryTopicParm{" +
                "activityId=" + activityId +
                ", pageNumber=" + pageNumber +
                ", pages=" + pages +
                '}';
    }
}
