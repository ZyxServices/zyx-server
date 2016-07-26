package com.zyx.rpc.account;

import com.zyx.entity.account.param.AccountInfoParam;

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
}
