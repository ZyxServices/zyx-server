package com.zyx.param.activity;

import java.io.Serializable;

/**
 * Created by SubDong on 16-6-16.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title AddTopicParm
 * @package com.zyx.entity.activity.parm
 * @update 16-6-16 下午2:33
 */
public class AddTopicParm implements Serializable{

    private Integer userId;

    private Integer activityId;

    private String topicTitle;

    private String topicContent;

    private String images;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "AddTopicParm{" +
                "userId=" + userId +
                ", activityId=" + activityId +
                ", topicTitle='" + topicTitle + '\'' +
                ", topicContent='" + topicContent + '\'' +
                ", images='" + images + '\'' +
                '}';
    }
}
