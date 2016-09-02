package com.zyx.rpc.account;

import com.zyx.param.account.AccountInfoParam;

import java.util.Map;

/**
 * Created by wms on 2016/6/17.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title AccountInfoFacade.java
 */
public interface AccountInfoFacade {
    Map<String, Object> queryAccountInfo(String token, int userId);

    Map<String, Object> editAccountInfo(String token, int userId, AccountInfoParam param);

    /**
     * 个人中心用户信息接口
     *
     * @param token
     * @param userId
     * @return
     */
    Map<String, Object> queryMyCenterInfo(String token, int userId);
}
