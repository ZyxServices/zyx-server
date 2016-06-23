package com.zyx.vo.account;

import com.zyx.vo.BaseVo;

/**
 * Created by WeiMinSheng on 2016/6/21.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title UserAddressVo.java
 */
public class UserAddressVo extends BaseVo {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer userId;// 用户ID

    private String addressId;// 地址ID

    private String receiver;// 收货人姓名

    private String phone;// 手机

    private String zipCode;// 邮编

    private String content;// 具体地址

    private Boolean status;// 是否默认收货地址

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

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
