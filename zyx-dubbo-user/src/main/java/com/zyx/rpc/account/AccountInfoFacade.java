package com.zyx.rpc.account;

import java.util.Map;

/**
 * Created by WeiMinSheng on 2016/6/17.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title AccountInfoFacade.java
 */
public interface AccountInfoFacade {
    Map<String, Object> queryAccountInfo(String token, int userId);
}
