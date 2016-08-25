package com.zyx.vo.system;

import com.zyx.vo.account.AccountAttentionVo;

import java.io.Serializable;

/**
 * Created by Rainbow on 2016/8/24.
 */
public class SearchConcernVo implements Serializable {

    /**
     * 动态id
     */
    private Integer id;
    /**
     * 发布动态用户基础信息
     */
    private AccountAttentionVo account;


    /**
     * 动态类型1为个人动态，2为活动动态，3为明星动态，4为圈子动态
     */
    private Integer type;

    /**
     * 动态标题
     */
    private String topicTitle;

    /**
     * 图片URL
     */
    private String imgUrl;

    /**
     * 视频url
     */
    private String videoUrl;

    /**
     * 可见范围0所有可见，1好友可见
     */
    private Integer topicVisible;

    /**
     * 动态状态，-2未屏蔽，-1为删除,0为正常
     */
    private Integer state;

    /**
     * 当前登录用户是否收藏次活动
     */
    private boolean isColl;

    /**
     * 当前直播点赞数
     */
    private Integer zanCount;

    /**
     * 当前直播弹幕数
     */
    private Integer msgCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AccountAttentionVo getAccount() {
        return account;
    }

    public void setAccount(AccountAttentionVo account) {
        this.account = account;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Integer getTopicVisible() {
        return topicVisible;
    }

    public void setTopicVisible(Integer topicVisible) {
        this.topicVisible = topicVisible;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public boolean isColl() {
        return isColl;
    }

    public void setColl(boolean coll) {
        isColl = coll;
    }

    public Integer getZanCount() {
        if(zanCount == null) zanCount = 0;
        return zanCount;
    }

    public void setZanCount(Integer zanCount) {
        this.zanCount = zanCount;
    }

    public Integer getMsgCount() {
        if(msgCount == null) msgCount = 0;
        return msgCount;
    }

    public void setMsgCount(Integer msgCount) {
        this.msgCount = msgCount;
    }
}
