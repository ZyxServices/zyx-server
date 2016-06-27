package com.zyx.service.account.impl;

import com.zyx.service.account.AccountRedisService;
import com.zyx.vo.account.AccountInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by skmbg on 2016/6/27.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title AccountRedisServiceImpl.java
 */
@Service("accountRedisService")
public class AccountRedisServiceImpl implements AccountRedisService {

    @Autowired
    private RedisTemplate<String, AccountInfoVo> redisTemplate;

    @Override

    public void put(AccountInfoVo user) {
        redisTemplate.opsForHash().put(user.getObjectKey(), user.getPhone(), user);
    }

    @Override
    public void delete(String phone) {
        AccountInfoVo accountInfoVo = new AccountInfoVo();
        accountInfoVo.setPhone(phone);
        redisTemplate.opsForHash().delete(accountInfoVo.getObjectKey(), accountInfoVo.getPhone());
    }

    @Override
    public AccountInfoVo get(String phone) {
        AccountInfoVo accountInfoVo = new AccountInfoVo();
        accountInfoVo.setPhone(phone);
        return (AccountInfoVo) redisTemplate.opsForHash().get(accountInfoVo.getObjectKey(), accountInfoVo.getPhone());
    }
}
