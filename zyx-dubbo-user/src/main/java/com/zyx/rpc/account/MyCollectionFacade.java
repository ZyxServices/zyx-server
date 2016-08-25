package com.zyx.rpc.account;

import java.util.Map;

/**
 * Created by wms on 2016/8/23.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title MyCollectionFacade.java
 */
public interface MyCollectionFacade {

    Map<String, Object> myList(String token, Integer accountId);

}
