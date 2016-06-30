package com.zyx.rpc.account;

import com.zyx.entity.Devaluation;
import com.zyx.vo.account.AccountInfoVo;

import java.util.List;
import java.util.Map;

/**
 * Created by skmbg on 2016/6/29.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title UserDevaFacade.java
 */
public interface UserDevaFacade {

    /**
     * 用户首推查询
     *
     * @return
     */
	List<AccountInfoVo> queryUserDeva();


    /**
     * 用户首推
     *
     * @return
     */
    Map<String, Object> insertUserDeva(Devaluation devaluation);

}
