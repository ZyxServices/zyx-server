package com.zyx.vo.system;

import com.zyx.vo.account.UserIconVo;

import java.io.Serializable;

/**
 * Created by Rainbow on 2016/8/24.
 */
public class SearchLiveVo implements Serializable {
    /**
     * 直播id
     */
    private Integer id;

    /**
     * 1-公开，默认 2-我的粉丝可见 3-我关注人可见 4-包括2、3情况
     */
    private Integer auth;

    /**
     * 直播类型1-图文直播 2-视频直播
     */
    private Integer type;

    /**
     * 开始时间
     */
    private Long start;

    /**
     * 结束时间
     */
    private Long end;

    /**
     * 直播创建用户
     */
    private UserIconVo account;

    /**
     * 直播标题
     */
    private String title;

    /**
     * 直播标签
     */
    private Integer lab;

    /**
     * 直播背景图片
     */
    private String bgmUrl;

    /**
     * 视频直播地址
     */
    private String vedioUrl;

    /**
     * 0-未开始，1-正在直播，2-直播结束
     */
    private Integer state;

    /**
     * 0-未开始，1-正在直播，2-直播结束
     */
    private Long createTime;

    /**
     * 当前登录用户是否收藏此直播
     */
    private boolean isColl;

    /**
     * 当前直播的点赞数量
     */
    private Integer zanCount;

    /**
     * 当前直播消息数量
     */
    private Integer msgCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

    public UserIconVo getAccount() {
        return account;
    }

    public void setAccount(UserIconVo account) {
        this.account = account;
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

    public String getBgmUrl() {
        return bgmUrl;
    }

    public void setBgmUrl(String bgmUrl) {
        this.bgmUrl = bgmUrl;
    }

    public String getVedioUrl() {
        return vedioUrl;
    }

    public void setVedioUrl(String vedioUrl) {
        this.vedioUrl = vedioUrl;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
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
