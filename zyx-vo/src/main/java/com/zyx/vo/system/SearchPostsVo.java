package com.zyx.vo.system;

import com.zyx.vo.account.AccountAttentionVo;

import java.io.Serializable;

/**
 * Created by Rainbow on 2016/8/25.
 */
public class SearchPostsVo implements Serializable {

    /**
     * 帖子
     */
    private Integer id;

    private String title;

    private String content;

    private String baseContent;

    private Long createTime;

    private SearchAccountVo account;

    private String circleId;

    private String circleName;

    private Integer zanCount;

    private Integer msgCount;

    /**
     * 浏览量
     */
    private Integer pageviews;

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

    public SearchAccountVo getAccount() {
        return account;
    }

    public void setAccount(SearchAccountVo account) {
        this.account = account;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    public String getCircleId() {
        return circleId;
    }

    public void setCircleId(String circleId) {
        this.circleId = circleId;
    }

    public Integer getPageviews() {
        return pageviews;
    }

    public void setPageviews(Integer pageviews) {
        this.pageviews = pageviews;
    }

    public String getBaseContent() {
        return baseContent;
    }

    public void setBaseContent(String baseContent) {
        this.baseContent = baseContent;
    }
}
