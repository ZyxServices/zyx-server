package com.zyx.service.account;

import com.zyx.vo.account.AccountInfoVo;

/**
 * Created by skmbg on 2016/6/27.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title AccountRedisService.java
 */
public interface AccountRedisService {

    void put(AccountInfoVo user);

    void delete(String phone);

    AccountInfoVo get(String phone);
}