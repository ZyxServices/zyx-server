package com.zyx.vo.system;

/**
 * Created by MrDeng on 2016/9/22.
 */
public class CircleItemDevaVo extends BaseDevaVo{
    private String title;
    private Integer createId;
    private String baseContent;
    private Long createTime;
    /**
     * 当前直播的点赞数量
     */
    private Integer zanCount;

    /**
     * 当前直播消息数量
     */
    private Integer msgCount;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public String getBaseContent() {
        return baseContent;
    }

    public void setBaseContent(String baseContent) {
        this.baseContent = baseContent;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
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
