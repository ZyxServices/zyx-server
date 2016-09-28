package com.zyx.vo.live;

import java.io.Serializable;
import java.util.List;

import com.zyx.vo.BaseVo;
import com.zyx.vo.account.UserIconVo;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;

public class LiveInfoVo implements Serializable {
    private Integer id;
    private Integer auth;
    private Integer type;
    private Integer userId;
    private Long startTime;
    private Long endTime;
    private UserIconVo userIconVo;
    private String title;
    private Integer lab;
    private String bgmUrl;
    private Long groupId;
    private String vedioUrl;
    private Integer state;
    // 用户认证标签
    private String authInfo;
    private Integer watchNumber;
    private Long liveTime;
    private boolean isColl;
    private boolean isZan;

    public boolean getIsColl() {
        return isColl;
    }

    public void setColl(boolean coll) {
        isColl = coll;
    }

    public boolean getIsZan() {
        return isZan;
    }

    public void setZan(boolean zan) {
        isZan = zan;
    }

    public Integer getWatchNumber() {
        return watchNumber;
    }

    public void setWatchNumber(Integer watchNumber) {
        this.watchNumber = watchNumber;
    }

    /**
     * 当前直播的点赞数量
     */
    private Integer zanCount;

    /**
     * 当前直播消息数量
     */
    private Integer msgCount;

    public Long getLiveTime() {
//        if (this.watchTime == null) {
//            watchTime = (getStartTime() == null || getEndTime() == null || getStartTime() > this.getEndTime()) ? 0 : getStartTime() - getEndTime();
//        }
        return liveTime;
    }

    public void countLiveTime() {
        liveTime = (getStartTime() == null || getEndTime() == null || getStartTime() > this.getEndTime()) ? 0 : getEndTime() - getStartTime();
    }

    public void setLiveTime(Long liveTime) {
        this.liveTime = liveTime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAuth(Integer auth) {
        this.auth = auth;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserIconVo(UserIconVo userIconVo) {
        this.userIconVo = userIconVo;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLab(Integer lab) {
        this.lab = lab;
    }

    public void setBgmUrl(String bgmUrl) {
        this.bgmUrl = bgmUrl;
    }

    public void setVedioUrl(String vedioUrl) {
        this.vedioUrl = vedioUrl;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAuth() {
        return auth;
    }

    public Integer getType() {
        return type;
    }

    public UserIconVo getUserIconVo() {
        return userIconVo;
    }

    public String getTitle() {
        return title;
    }

    public Integer getLab() {
        return lab;
    }

    public String getBgmUrl() {
        return bgmUrl;
    }

    public String getVedioUrl() {
        return vedioUrl;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Integer getState() {
        return state;
    }

    public String getAuthInfo() {
        return authInfo;
    }

    public void setAuthInfo(String authInfo) {
        this.authInfo = authInfo;
    }

    public Integer getZanCount() {
        return zanCount;
    }

    public void setZanCount(Integer zanCount) {
        this.zanCount = zanCount;
    }

    public Integer getMsgCount() {
        return msgCount;
    }

    public void setMsgCount(Integer msgCount) {
        this.msgCount = msgCount;
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
}
