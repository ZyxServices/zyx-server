package com.zyx.vo.account;

import java.io.Serializable;

/**
 * Created by MrDeng on 2016/8/17.
 */
public class UserIconVo implements Serializable {
    private Integer id;
    private String nickname;
    private String avatar;
    private String authInfo;
    private Integer auth;
    public Integer getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getAuth() {
        return auth;
    }

    public void setAuth(Integer auth) {
        this.auth = auth;
    }

    public String getAuthInfo() {
        return authInfo;
    }

    public void setAuthInfo(String authInfo) {
        this.authInfo = authInfo;
    }
}
