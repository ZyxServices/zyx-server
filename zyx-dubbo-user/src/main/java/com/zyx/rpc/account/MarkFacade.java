package com.zyx.rpc.account;

import com.zyx.param.account.UserMarkParam;

import java.util.Map;

/**
 * Created by WeiMinSheng on 2016/6/16.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title MarkFacade.java
 */
public interface MarkFacade {

    /**
     * 签到
     *
     * @param userMarkParam
     * @return
     */
    Map<String, Object> sign(UserMarkParam userMarkParam);

    /**
     * 签到查询
     *
     * @param userMarkParam
     * @return
     */
    Map<String, Object> querySign(UserMarkParam userMarkParam);

}
