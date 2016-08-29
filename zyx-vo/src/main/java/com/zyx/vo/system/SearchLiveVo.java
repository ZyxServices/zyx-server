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
     * 直播创建用户
     */
    private SearchAccountVo account;

    /**
     * 直播标题
     */
    private String title;

    /**
     * 直播背景图片
     */
    private String bgmUrl;

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

    public SearchAccountVo getAccount() {
        return account;
    }

    public void setAccount(SearchAccountVo account) {
        this.account = account;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBgmUrl() {
        return bgmUrl;
    }

    public void setBgmUrl(String bgmUrl) {
        this.bgmUrl = bgmUrl;
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
}
