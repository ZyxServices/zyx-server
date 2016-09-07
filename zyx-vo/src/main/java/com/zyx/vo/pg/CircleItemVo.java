package com.zyx.vo.pg;

import com.zyx.entity.activity.PageViews;
import com.zyx.entity.pg.CircleItem;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.entity.pg.dto
 * Create by XiaoWei on 2016/8/9
 */
public class CircleItemVo extends CircleItem {
    private String nickname;
    private String avatar;
    private Integer zanCount;
    private Integer meetCount;
    private String circleTitle;
    private String authInfo;
    private PageViews pageViews;

    public Integer getZanCount() {
        return zanCount;
    }

    public void setZanCount(Integer zanCount) {
        this.zanCount = zanCount;
    }

    public Integer getMeetCount() {
        return meetCount;
    }

    public void setMeetCount(Integer meetCount) {
        this.meetCount = meetCount;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCircleTitle() {
        return circleTitle;
    }

    public void setCircleTitle(String circleTitle) {
        this.circleTitle = circleTitle;
    }

    public String getAuthInfo() {
        return authInfo;
    }

    public void setAuthInfo(String authInfo) {
        this.authInfo = authInfo;
    }

    public PageViews getPageViews() {
        return pageViews;
    }

    public void setPageViews(PageViews pageViews) {
        this.pageViews = pageViews;
    }
}
