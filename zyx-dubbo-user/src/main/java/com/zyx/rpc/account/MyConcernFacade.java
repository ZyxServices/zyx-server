package com.zyx.rpc.account;

import com.zyx.param.account.UserConcernParam;

import java.util.Map;

/**
 * Created by wms on 2016/8/12.
 * 我的动态相关接口
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 */
public interface MyConcernFacade {

    /**
     * 我的动态列表
     */
    Map<String, Object> myList(UserConcernParam userConcernParam);

}
