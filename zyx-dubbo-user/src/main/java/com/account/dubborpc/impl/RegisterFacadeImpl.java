package com.account.dubborpc.impl;

import com.account.dubborpc.RegisterFacade;
import com.zyx.constants.AuthConstants;
import com.zyx.constants.account.AuthAccountConstants;
import com.zyx.entity.account.AccountInfo;
import com.zyx.entity.account.UserLoginParam;
import com.zyx.service.account.AccountInfoService;
import com.zyx.utils.CipherUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.*;

/**
 * Created by WeiMinSheng on 2016/6/12.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title RegisterFacadeImpl.java
 */
public class RegisterFacadeImpl implements RegisterFacade {

    @Autowired
    private AccountInfoService accountInfoService;

    @Autowired
    protected RedisTemplate<String, String> jedisTemplate;

    @Override
    public Map<String, Object> registerAccount(UserLoginParam userLoginParam) {
        Map<String, Object> map = new HashMap<String, Object>();
        // 判断手机号是否已经注册
        int count = accountInfoService.selectAccountByPhone(userLoginParam.getPhone());
        if (count != 0) {// 手机号码重复
            map.put(AuthConstants.AUTH_ERROR_CODE, AuthAccountConstants.ACCOUNT_ERROR_CODE_50005);
            map.put(AuthConstants.AUTH_ERRORMSG, AuthAccountConstants.ACCOUNT_ERROR_CODE_50005_MSG);
            return map;
        }

        // 判断缓存中手机号码和验证码是否对应
        String redis_code = jedisTemplate.opsForValue().get("tyj_phone_code:" + userLoginParam.getPhone());
        if (!userLoginParam.getCode().equals(redis_code)) {
            map.put(AuthConstants.AUTH_ERROR_CODE, AuthAccountConstants.ACCOUNT_ERROR_CODE_50006);
            map.put(AuthConstants.AUTH_ERRORMSG, AuthAccountConstants.ACCOUNT_ERROR_CODE_50006_MSG);
            return map;
        }

        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setPhone(userLoginParam.getPhone());
        accountInfo.setPassword(CipherUtil.generatePassword(userLoginParam.getPassword()));
        accountInfo.setNickname("体育家【" + userLoginParam.getPhone() + "】");
        accountInfo.setCreateTime(System.currentTimeMillis());
        int result = accountInfoService.save(accountInfo);
        if (result == 0) {
            map.put(AuthConstants.AUTH_ERROR_CODE, AuthAccountConstants.ACCOUNT_REGISTER_ERROR);
            map.put(AuthConstants.AUTH_ERRORMSG, AuthAccountConstants.ACCOUNT_REGISTER_ERROR_MSG);
        } else {
            map.put(AuthConstants.AUTH_STATE, AuthConstants.AUTH_SUCCESS_200);
        }
        return map;
    }

    @Override
    public Map<String, Object> renewpwd(UserLoginParam userLoginParam) {
        Map<String, Object> map = new HashMap<String, Object>();
        String phone = jedisTemplate.opsForValue().get("tyj_token:" + userLoginParam.getToken());
        if (phone == null) {// token失效
            map.put(AuthConstants.AUTH_STATE, AuthAccountConstants.ACCOUNT_ERROR_CODE_50000);
            map.put(AuthConstants.AUTH_ERRORMSG, AuthAccountConstants.ACCOUNT_ERROR_CODE_50000_MSG);
            return map;
        }
        userLoginParam.setPhone(phone);
        userLoginParam.setPassword(CipherUtil.generatePassword(userLoginParam.getPassword()));
        List<AccountInfo> list = accountInfoService.selectAccountByParam(userLoginParam);
        if (list == null || list.size() == 0) {
            map.put(AuthConstants.AUTH_STATE, AuthAccountConstants.ACCOUNT_ERROR_CODE_50001);
            map.put(AuthConstants.AUTH_ERRORMSG, AuthAccountConstants.ACCOUNT_ERROR_CODE_50001_MSG);
            return map;
        }
        userLoginParam.setPassword2(CipherUtil.generatePassword(userLoginParam.getPassword2()));
        int result = accountInfoService.renewpwd(userLoginParam);
        if (result == 0) {
            map.put(AuthConstants.AUTH_STATE, AuthAccountConstants.ACCOUNT_ERROR_CODE_50002);
            map.put(AuthConstants.AUTH_ERRORMSG, AuthAccountConstants.ACCOUNT_ERROR_CODE_50002_MSG);
        } else {
            map.put(AuthConstants.AUTH_STATE, AuthConstants.AUTH_SUCCESS_200);
        }
        return map;
    }

    @Override
    public Map<String, Object> retrievepwd(UserLoginParam userLoginParam) {
        Map<String, Object> map = new HashMap<String, Object>();

        // 判断缓存中手机号码和验证码是否对应
        String redis_code = jedisTemplate.opsForValue().get("tyj_phone_code:" + userLoginParam.getPhone());
        if (!userLoginParam.getCode().equals(redis_code)) {
            map.put(AuthConstants.AUTH_STATE, AuthAccountConstants.ACCOUNT_ERROR_CODE_50006);
            map.put(AuthConstants.AUTH_ERRORMSG, AuthAccountConstants.ACCOUNT_ERROR_CODE_50006_MSG);
            return map;
        }

        userLoginParam.setPassword2(CipherUtil.generatePassword(userLoginParam.getPassword2()));
        int result = accountInfoService.renewpwd(userLoginParam);
        if (result == 0) {
            map.put(AuthConstants.AUTH_STATE, AuthAccountConstants.ACCOUNT_ERROR_CODE_50002);
            map.put(AuthConstants.AUTH_ERRORMSG, AuthAccountConstants.ACCOUNT_ERROR_CODE_50002_MSG);
        } else {
            String temp = jedisTemplate.opsForValue().get("tyj_phone:" + userLoginParam.getPhone());
            String token = temp.substring(temp.indexOf("【") + 1, temp.indexOf("】"));
            jedisTemplate.delete("tyj_phone:" + userLoginParam.getPhone());
            jedisTemplate.delete("tyj_token:" + token);
            map.put(AuthConstants.AUTH_STATE, AuthConstants.AUTH_SUCCESS_200);
        }
        return map;
    }

}
