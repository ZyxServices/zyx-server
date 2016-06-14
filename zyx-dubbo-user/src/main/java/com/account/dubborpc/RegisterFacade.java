package com.account.dubborpc;

import com.zyx.entity.account.UserLoginParam;

import java.util.Map;

/**
 * Created by WeiMinSheng on 2016/6/12.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title RegisterFacade.java
 */
public interface RegisterFacade {
    /**
     * 发送验证码
     *
     * @param phone 手机号码
     * @param msg   需要发送的自定义内容
     * @return
     */
    int sendPhoneCode(String phone, String msg);

    /**
     * 注册
     *
     * @param userLoginParam
     * @return
     */
    Map<String, Object> registerAccount(UserLoginParam userLoginParam);

    /**
     * 更新密码
     *
     * @param userLoginParam
     * @return
     */
    Map<String, Object> renewpwd(UserLoginParam userLoginParam);

}
