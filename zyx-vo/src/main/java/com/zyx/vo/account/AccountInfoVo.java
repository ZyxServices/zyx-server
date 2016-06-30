package com.zyx.vo.account;

import com.zyx.vo.BaseVo;

/**
 * Created by WeiMinSheng on 2016/6/14.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title AccountInfoVo.java
 */
public class AccountInfoVo extends BaseVo {
    /**
     *
     */
    private static final long serialVersionUID = 3007058842595308501L;

    private static final String OBJECT_KEY = "TYJ_USER";

    private Integer id;

    private String phone;

    private String password;

    private String nickname;

    private Integer sex;

    private String avatar;

    private String token;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "AccountInfoVo{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex=" + sex +
                ", avatar='" + avatar + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

    public static String getObjectKey() {
        return OBJECT_KEY;
    }
}
