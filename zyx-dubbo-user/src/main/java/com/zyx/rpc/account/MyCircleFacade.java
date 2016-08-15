package com.zyx.rpc.account;

import java.util.Map;

/**
 * Created by wms on 2016/8/11.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title MyCircleFacade.java
 */
public interface MyCircleFacade {

    Map<String, Object> myCircleList(String token, Integer accountId);

    Map<String, Object> myCreateList(String token, Integer createId);

    Map<String, Object> myConcernList(String token, Integer accountId);
}
