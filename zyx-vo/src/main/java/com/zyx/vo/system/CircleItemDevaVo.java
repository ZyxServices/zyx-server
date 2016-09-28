package com.zyx.vo.system;

import com.zyx.vo.account.UserIconVo;

/**
 * Created by MrDeng on 2016/9/22.
 */
public class CircleItemDevaVo extends BaseDevaVo{
    private String title;
    private Integer circleId;
    private String circleTitle;
    private Integer userId;
    private String baseContent;
    private Long createTime;
    /**
     * 当前直播的点赞数量
     */
    private Integer zanCount=0;

    /**
     * 当前直播消息数量
     */
    private Integer comCount=0;

    private Integer viewCount=0;
    private UserIconVo userIconVo;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCircleId() {
        return circleId;
    }

    public void setCircleId(Integer circleId) {
        this.circleId = circleId;
    }

    @Override
    public Integer getUserId() {
        return userId;
    }

    @Override
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCircleTitle() {
        return circleTitle;
    }

    public void setCircleTitle(String circleTitle) {
        this.circleTitle = circleTitle;
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

    public Integer getComCount() {
        return comCount;
    }

    public void setComCount(Integer comCount) {
        this.comCount = comCount;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

//    public String getNickname() {
//        return nickname;
//    }
//
//    public void setNickname(String nickname) {
//        this.nickname = nickname;
//    }

    public UserIconVo getUserIconVo() {
        return userIconVo;
    }
    public void setUserIconVo(UserIconVo userIconVo) {
        this.userIconVo = userIconVo;
//        if(userIconVo!=null){
//            if(userIconVo.getAvatar()!=null)
//            setBgmUrl(userIconVo.getAvatar());
//            if(userIconVo.getNickname()!=null)
//                setNickname(userIconVo.getNickname());
//        }
    }
}
