package com.zyx.vo.system;

import com.zyx.vo.account.AccountAttentionVo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Rainbow on 2016/8/23.
 */
public class SearchActivityVo implements Serializable {
    /**
     * 主键ID
     **/
    private Integer id;
    /**
     * 创建者(用户ID)
     */
    private AccountAttentionVo user;

    /**
     * 活动标题
     */
    private String title;

    /**
     * 活动图片
     */
    private String imgUrls;

    /**
     * 活动开始时间
     */
    private Long startTime;

    /**
     *
     */
    private Long createTime;

    /**
     * 当前活动点赞数
     */
    private Integer zanCount;

    /**
     * 当前活动弹幕数
     */
    private Integer msgCount;

    /**
     * 是否屏蔽(0正常 1屏蔽)
     */
    private Integer mask;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AccountAttentionVo getUser() {
        return user;
    }

    public void setUser(AccountAttentionVo user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(String imgUrls) {
        this.imgUrls = imgUrls;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Integer getMask() {
        return mask;
    }

    public void setMask(Integer mask) {
        this.mask = mask;
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
