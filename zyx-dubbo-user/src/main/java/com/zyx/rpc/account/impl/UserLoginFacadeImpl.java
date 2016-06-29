package com.zyx.rpc.account.impl;

import com.zyx.constants.account.AccountConstants;
import com.zyx.rpc.account.UserLoginFacade;
import com.zyx.service.account.AccountInfoService;
import com.zyx.service.account.AccountRedisService;
import com.zyx.service.account.UserLoginService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.account.AccountInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by WeiMinSheng on 2016/6/12.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title UserLoginFacadeImpl.java
 */
@Service("userLoginFacade")
public class UserLoginFacadeImpl implements UserLoginFacade {

    @Autowired
    private UserLoginService userLoginService;

    @Autowired
    private AccountInfoService accountInfoService;

    @Autowired
    protected RedisTemplate<String, String> stringRedisTemplate;

    @Autowired
    private AccountRedisService accountRedisService;

    @Override
    public Map<String, Object> loginByPhoneAndPassword(String phone, String password) {
        // 判断手机号码是否注册
        int count = accountInfoService.selectAccountByPhone(phone);
        if (count == 0) {// 未注册
            return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50003, AccountConstants.ACCOUNT_ERROR_CODE_50003_MSG);
        }
        // 判断是否已经登录
        String phoneTime = stringRedisTemplate.opsForValue().get("tyj_phone:" + phone);
        if (phoneTime != null) {
            return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50004, AccountConstants.ACCOUNT_ERROR_CODE_50004_MSG);
        }

        AccountInfoVo accountInfo = userLoginService.loginByPhoneAndPassword(phone, password);
        if (accountInfo == null) {// 登陆失败
            return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50001, AccountConstants.ACCOUNT_ERROR_CODE_50001_MSG);
        }
        // 登录成功返回
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        stringRedisTemplate.opsForValue().set("tyj_token:" + token, phone);
        accountRedisService.put(accountInfo);
        stringRedisTemplate.opsForValue().set("tyj_phone:" + phone, System.currentTimeMillis() + "【" + token + "】");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("tyj", accountInfo);
        map.put("token", token);
        return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "登录成功", map);
    }

    @Override
    public Map<String, Object> signout(String token) {
        String phone = stringRedisTemplate.opsForValue().get("tyj_token:" + token);
        // 退出时的处理
        if (phone == null) {// token失效
            return AccountConstants.MAP_TOKEN_FAILURE;
        }
        stringRedisTemplate.delete("tyj_token:" + token);
        stringRedisTemplate.delete("tyj_phone:" + phone);
        AccountInfoVo accountInfoVo = new AccountInfoVo();
        accountInfoVo.setPhone(phone);
        accountRedisService.delete(phone);
        return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "退出成功", null);
    }

    @Override
    public Map<String, Object> refreshtoken(String token) {
        String phone = stringRedisTemplate.opsForValue().get("tyj_token:" + token);
        if (phone == null) {// token已经失效
            return AccountConstants.MAP_TOKEN_FAILURE;
        }
        String token_new = UUID.randomUUID().toString().replaceAll("-", "");
        String _newTyjPhone = stringRedisTemplate.opsForValue().get("tyj_phone:" + phone).replaceAll(token, token_new);
        stringRedisTemplate.delete("tyj_token:" + token);
        stringRedisTemplate.delete("tyj_phone:" + phone);
        stringRedisTemplate.opsForValue().set("tyj_token:" + token_new, phone);
        stringRedisTemplate.opsForValue().set("tyj_phone:" + phone, _newTyjPhone);
        return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "TOKEN刷新成功", token_new);
    }

}
