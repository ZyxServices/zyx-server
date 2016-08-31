package com.zyx.vo.account;

import java.io.Serializable;

/**
 * Created by wms on 2016/6/14.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title AccountInfoVo.java
 */
public class AccountInfoVo implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 3007058842595308501L;

    private static final String OBJECT_KEY = "TYJ_USER";

    private Integer id;

    private String phone;

//    private String password;

    private String nickname;

    private Integer sex;

    private String avatar;

    private Integer del;

    private Integer mask;

    private String token;

    private long birthday;

    private String signature;

    private String address;

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

//    public String getPassword() {
//        return password;
//    }

//    public void setPassword(String password) {
//        this.password = password;
//    }

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

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public Integer getMask() {
        return mask;
    }

    public void setMask(Integer mask) {
        this.mask = mask;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "AccountInfoVo{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex=" + sex +
                ", avatar='" + avatar + '\'' +
                ", del=" + del +
                ", mask=" + mask +
                ", token='" + token + '\'' +
                ", birthday=" + birthday +
                ", signature='" + signature + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static String getObjectKey() {
        return OBJECT_KEY;
    }
}
