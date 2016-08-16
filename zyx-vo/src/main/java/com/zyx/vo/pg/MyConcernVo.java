package com.zyx.vo.pg;

import com.zyx.entity.pg.MyConcern;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.entity.pg.dto
 * Create by XiaoWei on 2016/8/10
 */
public class MyConcernVo extends MyConcern {
    private Integer userId;
    private String userName;
    private String nickName;
    private String avatar;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
