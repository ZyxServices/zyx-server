package com.zyx.rpc.common;

import java.util.Map;

/**
 * Created by wms on 2016/7/6.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title TokenFacade.java
 */
public interface TokenFacade {
    boolean preHandle(String anthorization);

    boolean isTokenFailure(String token);

    boolean isTokenFailure(String token, Integer userId);

    Map<String, Object> validateToken(String token);

    Map<String, Object> validateToken(String token, Integer userId);

    Map<String, Object> validateTokenIncludeOther(String token, Integer userId);
}
