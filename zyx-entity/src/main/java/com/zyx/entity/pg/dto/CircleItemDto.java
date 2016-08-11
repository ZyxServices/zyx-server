package com.zyx.entity.pg.dto;

import com.zyx.entity.pg.CircleItem;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.entity.pg.dto
 * Create by XiaoWei on 2016/8/9
 */
public class CircleItemDto extends CircleItem {
    private String nickname;
    private String avatar;
    private Integer zanCount;
    private Integer meetCount;
    private String circleTitle;

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
}
