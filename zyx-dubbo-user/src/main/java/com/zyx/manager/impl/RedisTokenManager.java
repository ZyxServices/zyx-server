package com.zyx.manager.impl;

import com.zyx.manager.TokenManager;
import com.zyx.token.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by wms on 2016/7/6.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title RedisTokenManager.java
 */
@Component
public class RedisTokenManager implements TokenManager {

    @Autowired
    protected RedisTemplate<String, String> stringRedisTemplate;

    @Override
    public TokenModel createToken(String phone) {
        //使用uuid作为源token
        String token = UUID.randomUUID().toString().replace("-", "");
        TokenModel model = new TokenModel(phone, token);
        //存储到redis不设置过期时间
        stringRedisTemplate.boundValueOps(phone).set(token);
        return model;
    }

    @Override
    public TokenModel getToken(String authentication) {
        if (authentication == null || authentication.length() == 0) {
            return null;
        }
        String[] param = authentication.split("_");
        if (param.length != 2) {
            return null;
        }
        //使用phone和源token简单拼接成的token，可以增加加密措施
        String phone = param[0];
        String token = param[1];
        return new TokenModel(phone, token);
    }

    @Override
    public boolean checkToken(TokenModel model) {
        if (model == null) {
            return false;
        }
        String token = stringRedisTemplate.boundValueOps(model.getPhone()).get();
        if (token == null || !token.equals(model.getToken())) {
            return false;
        }
        //如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
        //stringRedisTemplate.boundValueOps(model.getPhone()).expire(72, TimeUnit.HOURS);
        return true;
    }

    @Override
    public void deleteToken(String phone) {
        stringRedisTemplate.delete(phone);
    }
}
