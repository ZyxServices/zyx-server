package com.zyx.rpc.account;

import java.util.Map;

/**
 * Created by WeiMinSheng on 2016/6/12.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title UserLoginFacade.java
 */
public interface UserLoginFacade {

    /**
     * 手机号密码登录
     *
     * @param phone
     * @param password
     * @return
     */
    Map<String, Object> loginByPhoneAndPassword(String phone, String password);

    /**
     * 退出登录
     *
     * @param token
     * @return
     */
    Map<String, Object> signout(String token);

    /**
     * 刷新token
     *
     * @param token
     * @return
     */
    Map<String, Object> refreshtoken(String token);

}
