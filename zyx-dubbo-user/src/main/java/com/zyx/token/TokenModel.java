package com.zyx.token;

/**
 * Created by WMS on 2016/7/5.
 * Token的Model类，可以增加字段提高安全性，例如时间戳、url签名
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title TokenModel.java
 */
public class TokenModel {

    // 用户手机号码
    private String phone;

    // 随机生成的uuid
    private String token;

    public TokenModel(String phone, String token) {
        this.phone = phone;
        this.token = token;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static void main(String[] args) {
        System.out.println(1 != Integer.valueOf(1));
    }
}
