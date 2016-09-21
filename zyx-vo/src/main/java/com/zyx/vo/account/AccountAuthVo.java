package com.zyx.vo.account;

import java.io.Serializable;

/**
 * Created by wms on 2016/8/15.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 */
public class AccountAuthVo implements Serializable {
    private static final long serialVersionUID = 7196206868032273866L;

    private Integer id;

    private Integer user_id;

    private String authName;

    private String authIDCard;

    private String authMob;

    private String authfile;

    private String authinfo;

    private String authfilework;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getAuthIDCard() {
        return authIDCard;
    }

    public void setAuthIDCard(String authIDCard) {
        this.authIDCard = authIDCard;
    }

    public String getAuthMob() {
        return authMob;
    }

    public void setAuthMob(String authMob) {
        this.authMob = authMob;
    }

    public String getAuthfile() {
        return authfile;
    }

    public void setAuthfile(String authfile) {
        this.authfile = authfile;
    }

    public String getAuthinfo() {
        return authinfo;
    }

    public void setAuthinfo(String authinfo) {
        this.authinfo = authinfo;
    }

    public String getAuthfilework() {
        return authfilework;
    }

    public void setAuthfilework(String authfilework) {
        this.authfilework = authfilework;
    }
}
