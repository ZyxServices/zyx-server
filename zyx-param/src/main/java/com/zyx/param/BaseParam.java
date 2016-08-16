package com.zyx.param;

import java.io.Serializable;

/**
 * Created by wms on 2016/8/15.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title BaseParam.java
 */
public class BaseParam implements Serializable {
    private static final long serialVersionUID = -871424628305263963L;

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
