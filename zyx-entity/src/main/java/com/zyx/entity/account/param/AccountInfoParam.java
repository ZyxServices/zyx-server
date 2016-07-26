package com.zyx.entity.account.param;

import java.io.Serializable;

/**
 * Created by wms on 2016/7/25.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title AccountInfoParam.java
 */
public class AccountInfoParam implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String token;

    // 昵称
    private String nickname;

    // 性别
    private Integer sex;

    // 头像
    private String avatar;

    // 生日
    private Long birthday;

    // 地址
    private String address;

    // 签名
    private String signature;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "AccountInfoParam{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex=" + sex +
                ", avatar='" + avatar + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}
