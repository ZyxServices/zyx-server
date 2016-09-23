package com.zyx.vo.system;

import com.zyx.vo.BaseVo;
import com.zyx.vo.account.UserIconVo;

/**
 * Created by MrDeng on 2016/9/22.
 */
public class LiveDevaVo extends BaseDevaVo{
    private Integer auth;
    private Integer type;
    private Long startTime;
    private Long endTime;
    private Integer userId;
    private String title;
    private Integer lab;
//    private String bgmUrl;
    private Long groupId;
    private Integer state;
    private UserIconVo userIconVo;
    public Integer getAuth() {
        return auth;
    }

    public void setAuth(Integer auth) {
        this.auth = auth;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLab() {
        return lab;
    }

    public void setLab(Integer lab) {
        this.lab = lab;
    }
//
//    public String getBgmUrl() {
//        return bgmUrl;
//    }
//
//    public void setBgmUrl(String bgmUrl) {
//        this.bgmUrl = bgmUrl;
//    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public UserIconVo getUserIconVo() {
        return userIconVo;
    }

    public void setUserIconVo(UserIconVo userIconVo) {
        this.userIconVo = userIconVo;
    }
}
