package com.zyx.param.account;

import com.zyx.param.BaseParam;

/**
 * Created by wms on 2016/9/18.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/9/18
 */
public class UserAuthParam extends BaseParam {

    private static final long serialVersionUID = 4884863210309653763L;

    private Integer id;

    private Integer userId;

    private Integer authenticate;

    private String authName;

    private String authIDCard;

    private String authMob;

    private String authFile;

    private String authInfo;

    private String authFileWork;

    private long modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAuthenticate() {
        return authenticate;
    }

    public void setAuthenticate(Integer authenticate) {
        this.authenticate = authenticate;
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

    public String getAuthFile() {
        return authFile;
    }

    public void setAuthFile(String authFile) {
        this.authFile = authFile;
    }

    public String getAuthInfo() {
        return authInfo;
    }

    public void setAuthInfo(String authInfo) {
        this.authInfo = authInfo;
    }

    public String getAuthFileWork() {
        return authFileWork;
    }

    public void setAuthFileWork(String authFileWork) {
        this.authFileWork = authFileWork;
    }

    public long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(long modifyTime) {
        this.modifyTime = modifyTime;
    }
}