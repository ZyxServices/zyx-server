package com.zyx.rpc.account;

import com.zyx.param.account.UserCollectionParam;

import java.util.Map;

/**
 * Created by wms on 2016/8/23.
 * 我的收藏相关接口
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 */
public interface MyCollectionFacade {

    /**
     * 我的收藏列表
     */
    Map<String, Object> myList(UserCollectionParam userCollectionParam);

}
