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
    private SearchAccountVo account;

    /**
     * 动态标题
     */
    private String topicContent;

    /**
     * 当前动态点赞数
     */
    private Integer zanCount;

    /**
     * 当前动态弹幕数
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


    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
    }

    public Integer getZanCount() {
        if (zanCount == null) zanCount = 0;
        return zanCount;
    }

    public void setZanCount(Integer zanCount) {
        this.zanCount = zanCount;
    }

    public Integer getMsgCount() {
        if (msgCount == null) msgCount = 0;
        return msgCount;
    }

    public void setMsgCount(Integer msgCount) {
        this.msgCount = msgCount;
    }
}
