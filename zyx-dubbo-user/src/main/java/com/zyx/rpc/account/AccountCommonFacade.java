package com.zyx.rpc.account;

import com.zyx.vo.account.AccountInfoVo;

import java.util.Map;

/**
 * Created by wms on 2016/6/15.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 */
public interface AccountCommonFacade {

    /**
     * 发送验证码
     *
     * @param phone 手机号码
     * @param type  发送类型。register需要验证手机号是否已经被注册
     * @param msg   需要发送的自定义内容
     */
    Map<String, Object> sendPhoneCode(String phone, String type, String msg);

    /**
     * 验证token是否存在,true存在,false不存在
     *
     * @param token token字符串
     */
    boolean validateToken(String token);

    AccountInfoVo getAccountVoByToken(String token);
}
