package com.account.dubborpc.impl;

import com.account.dubborpc.UserLoginFacade;
import com.zyx.constants.AuthConstants;
import com.zyx.constants.account.AuthAccountConstants;
import com.zyx.entity.account.UserMarkInfo;
import com.zyx.service.account.AccountInfoService;
import com.zyx.service.account.UserLoginService;
import com.zyx.service.account.UserMarkService;
import com.zyx.vo.account.AccountInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Calendar;
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
public class UserLoginFacadeImpl implements UserLoginFacade {

    @Autowired
    private UserLoginService userLoginService;

    @Autowired
    private AccountInfoService accountInfoService;

    @Autowired
    private UserMarkService userMarkService;

    @Autowired
    protected RedisTemplate<String, String> jedisTemplate;

    @Override
    public Map<String, Object> loginByPhoneAndPassword(String phone, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        // 判断手机号码是否注册
        int count = accountInfoService.selectAccountByPhone(phone);
        if (count == 0) {// 未注册
            map.put(AuthConstants.AUTH_STATE, AuthAccountConstants.ACCOUNT_ERROR_CODE_50003);
            map.put(AuthConstants.AUTH_ERRORMSG, AuthAccountConstants.ACCOUNT_ERROR_CODE_50003_MSG);
            return map;
        }
        // 判断是否已经登录
        String phoneTime = jedisTemplate.opsForValue().get("tyj_phone:" + phone);
        if (phoneTime != null) {
            map.put(AuthConstants.AUTH_STATE, AuthAccountConstants.ACCOUNT_ERROR_CODE_50004);
            map.put(AuthConstants.AUTH_ERRORMSG, AuthAccountConstants.ACCOUNT_ERROR_CODE_50004_MSG);
            return map;
        }

        AccountInfoVo accountInfo = userLoginService.loginByPhoneAndPassword(phone, password);
        if (accountInfo == null) {// 登陆失败
            map.put(AuthConstants.AUTH_STATE, AuthAccountConstants.ACCOUNT_ERROR_CODE_50001);
            map.put(AuthConstants.AUTH_ERRORMSG, AuthAccountConstants.ACCOUNT_ERROR_CODE_50001_MSG);
            return map;
        }

        // 登录成功返回
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        jedisTemplate.opsForValue().set("tyj_token:" + token, phone);
        jedisTemplate.opsForValue().set("tyj_phone:" + phone, System.currentTimeMillis() + "【" + token + "】");
        map.put(AuthConstants.AUTH_STATE, AuthConstants.AUTH_SUCCESS_200);
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("token", token);
        map2.put("tyj", accountInfo);
        map.put("result", map2);
        return map;
    }

    @Override
    public Map<String, Object> signout(String token) {
        Map<String, Object> map = new HashMap<String, Object>();
        String phone = jedisTemplate.opsForValue().get("tyj_token:" + token);
        // 退出时的处理
        if (phone == null) {// token失效
            map.put(AuthConstants.AUTH_STATE, AuthAccountConstants.ACCOUNT_ERROR_CODE_50000);
            map.put(AuthConstants.AUTH_ERRORMSG, AuthAccountConstants.ACCOUNT_ERROR_CODE_50000_MSG);
        } else {
            jedisTemplate.delete("tyj_token:" + token);
            jedisTemplate.delete("tyj_phone:" + phone);
            map.put(AuthConstants.AUTH_STATE, AuthConstants.AUTH_SUCCESS_200);
        }
        return map;
    }

    @Override
    public Map<String, Object> refreshtoken(String token) {
        Map<String, Object> map = new HashMap<String, Object>();
        String phone = jedisTemplate.opsForValue().get("tyj_token:" + token);
        if (phone == null) {// token已经失效
            map.put(AuthConstants.AUTH_STATE, AuthAccountConstants.ACCOUNT_ERROR_CODE_50000);
            map.put(AuthConstants.AUTH_ERRORMSG, AuthAccountConstants.ACCOUNT_ERROR_CODE_50000_MSG);
        } else {
            String token_new = UUID.randomUUID().toString().replaceAll("-", "");
            jedisTemplate.delete("tyj_token:" + token);
            jedisTemplate.opsForValue().set("tyj_token:" + token_new, phone);
            map.put(AuthConstants.AUTH_STATE, AuthConstants.AUTH_SUCCESS_200);
            map.put("refreshToken", token_new);
        }
        return map;
    }

    @Override
    public Map<String, Object> sign(String token, String accountId) {
        // 判断当天是否已经签到
        String phone = jedisTemplate.opsForValue().get("tyj_sign:" + token);

        UserMarkInfo userMarkInfo = new UserMarkInfo();
        userMarkInfo.setUserId(Integer.parseInt(accountId));
        Long t = System.currentTimeMillis();
        userMarkInfo.setCreateTime(t);
        userMarkInfo.setMarkTime(t);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(t);
        String markString = String.valueOf(calendar.get(Calendar.DAY_OF_YEAR));
        userMarkInfo.setMarkString(markString);
        int result = userMarkService.save(userMarkInfo);
        if (result == 0) {

        }
        return null;
    }

}
