package com.zyx.vo.system;

import java.io.Serializable;

/**
 * Created by Rainbow on 2016/8/24.
 */
public class SearchAccountVo implements Serializable {
    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户头像
     */
    private String avatar;

    private boolean isAtten;

    private Integer authenticate;

    private SearchUserAuthVo auth;

    private Long createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public boolean isAtten() {
        return isAtten;
    }

    public void setAtten(boolean atten) {
        isAtten = atten;
    }

    public SearchUserAuthVo getAuth() {
        return auth;
    }

    public void setAuth(SearchUserAuthVo auth) {
        this.auth = auth;
    }

    public Integer getAuthenticate() {
        return authenticate;
    }

    public void setAuthenticate(Integer authenticate) {
        this.authenticate = authenticate;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
