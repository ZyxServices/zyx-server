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

    private Long createTime;

    /**
     * 环信ID
     */
    private Long number;

    /**
     * 0-未开始，1-正在直播，2-直播结束
     */
    private Integer state;

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

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}
