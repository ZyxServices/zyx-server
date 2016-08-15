package com.zyx.rpc.account;

import java.util.Map;

/**
 * Created by wms on 2016/8/12.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title MyConcernFacade.java
 */
public interface MyConcernFacade {
    Map<String, Object> myList(String token, Integer accountId);
}
