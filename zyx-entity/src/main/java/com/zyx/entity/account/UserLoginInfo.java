package com.zyx.entity.account;

import java.io.Serializable;

/**
 * Created by skmbg on 2016/6/13.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title UserLoginInfo.java
 */
public class UserLoginInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String phone;

    private String password;

    private String code;

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
}
