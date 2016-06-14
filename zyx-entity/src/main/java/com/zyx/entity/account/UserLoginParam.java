package com.zyx.entity.account;

import java.io.Serializable;

/**
 * Created by WeiMinSheng on 2016/6/13.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title UserLoginParam.java
 */
public class UserLoginParam implements Serializable {

    private static final long serialVersionUID = 1L;

    private String phone;

    /**
     * 密码和旧密码
     */
    private String password;

    private String code;

    // 用于更新密码
    private String token;

    /**
     * 新密码
     */
    private String password2;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
