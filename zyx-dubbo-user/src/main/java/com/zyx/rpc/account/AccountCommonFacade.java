package com.zyx.rpc.account;

import java.util.Map;

/**
 * Created by WeiMinSheng on 2016/6/15.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title AccountCommonFacade.java
 */
public interface AccountCommonFacade {
    /**
     * 发送验证码
     *
     * @param phone 手机号码
     * @param msg   需要发送的自定义内容
     * @return
     */
    Map<String, Object> sendPhoneCode(String phone, String msg);

    /**
     * 验证token是否存在,true存在,false不存在
     *
     * @param token token字符串
     * @return
     */
    boolean validateToken(String token);
}
