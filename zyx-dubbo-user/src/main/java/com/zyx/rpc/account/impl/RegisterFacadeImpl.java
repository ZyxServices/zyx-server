package com.zyx.rpc.account.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.account.AccountConstants;
import com.zyx.entity.account.AccountInfo;
import com.zyx.entity.account.UserLoginParam;
import com.zyx.rpc.account.RegisterFacade;
import com.zyx.service.account.AccountInfoService;
import com.zyx.service.account.AccountRedisService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.account.AccountInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by WeiMinSheng on 2016/6/12.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @ RegisterFacadeImpl.java
 */
@Service("registerFacade")
public class RegisterFacadeImpl implements RegisterFacade {

    @Autowired
    private AccountInfoService accountInfoService;

    @Autowired
    protected RedisTemplate<String, String> stringRedisTemplate;

    @Autowired
    private AccountRedisService accountRedisService;

    @Override
    public Map<String, Object> validatePhoneCode(UserLoginParam userLoginParam) {
        // 判断缓存中手机号码和验证码是否对应
        String redis_code = stringRedisTemplate.opsForValue().get("tyj_phone_code:" + userLoginParam.getPhone());

        if (StringUtils.isEmpty(redis_code)) {
            return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50011, AccountConstants.ACCOUNT_ERROR_CODE_50011_MSG);
        }

        if (!userLoginParam.getCode().equals(redis_code)) {
            return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50006, AccountConstants.ACCOUNT_ERROR_CODE_50006_MSG);
        }
        // 验证成功
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("phone", userLoginParam.getPhone());
        map.put("code", userLoginParam.getCode());
        return MapUtils.buildSuccessMap(Constants.SUCCESS, "手机号和验证码匹配成功", map);
    }

    @Override
    public Map<String, Object> registerAccount(UserLoginParam userLoginParam) {
        // 判断手机号是否已经注册
        int count = accountInfoService.selectAccountByPhone(userLoginParam.getPhone());
        if (count != 0) {// 手机号码重复
            return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50005, AccountConstants.ACCOUNT_ERROR_CODE_50005_MSG);
        }

        // 判断缓存中手机号码和验证码是否对应
        String redis_code = stringRedisTemplate.opsForValue().get("tyj_phone_code:" + userLoginParam.getPhone());
//        if (!userLoginParam.getCode().equals(redis_code)) {
//            map.put(Constants.STATE, AccountConstants.ACCOUNT_ERROR_CODE_50006);
//            map.put(Constants.ERROR_MSG, AccountConstants.ACCOUNT_ERROR_CODE_50006_MSG);
//            return map;
//        }

        if (StringUtils.isEmpty(redis_code)) {
            return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50011, AccountConstants.ACCOUNT_ERROR_CODE_50011_MSG);
        }

        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setPhone(userLoginParam.getPhone());
        accountInfo.setPassword(userLoginParam.getPassword());
        accountInfo.setNickname(userLoginParam.getNickname());
        accountInfo.setAvatar(userLoginParam.getAvatar());
        accountInfo.setCreateTime(System.currentTimeMillis());
        int result = accountInfoService.save(accountInfo);
        if (result == 0) {
            return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50010, AccountConstants.ACCOUNT_ERROR_CODE_50010_MSG);
        }
        return MapUtils.buildSuccessMap(Constants.SUCCESS, AccountConstants.ACCOUNT_SUCCESS_CODE_50013_MSG, accountInfo);
    }

    @Override
    public Map<String, Object> renewpwd(UserLoginParam userLoginParam) {
        String phone = stringRedisTemplate.opsForValue().get("tyj_token:" + userLoginParam.getToken());
        if (phone == null) {// token失效
            return Constants.MAP_TOKEN_FAILURE;
        }
        userLoginParam.setPhone(phone);
        userLoginParam.setPassword(userLoginParam.getPassword());
        List<AccountInfoVo> list = accountInfoService.selectAccountByParam(userLoginParam);
        if (list == null || list.size() == 0) {
            return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50001, AccountConstants.ACCOUNT_ERROR_CODE_50001_MSG);
        }
        userLoginParam.setPassword2(userLoginParam.getPassword2());
        int result = accountInfoService.renewpwd(userLoginParam);
        if (result == 0) {
            return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50002, AccountConstants.ACCOUNT_ERROR_CODE_50002_MSG);
        }
        return MapUtils.buildSuccessMap(Constants.SUCCESS, "用户密码修改成功", null);
    }

    @Override
    public Map<String, Object> retrievepwd(UserLoginParam userLoginParam) {

        // 判断缓存中手机号码和验证码是否对应
        String redis_code = stringRedisTemplate.opsForValue().get("tyj_phone_code:" + userLoginParam.getPhone());
//        if (!userLoginParam.getCode().equals(redis_code)) {
//            map.put(Constants.STATE, AccountConstants.ACCOUNT_ERROR_CODE_50006);
//            map.put(Constants.ERROR_MSG, AccountConstants.ACCOUNT_ERROR_CODE_50006_MSG);
//            return map;
//        }

        if (StringUtils.isEmpty(redis_code)) {
            return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50011, AccountConstants.ACCOUNT_ERROR_CODE_50011_MSG);
        }

        // 验证密码是否输入一致
        if (!userLoginParam.getPassword().equals(userLoginParam.getPassword2())) {
            return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50012, AccountConstants.ACCOUNT_ERROR_CODE_50012_MSG);
        }

        userLoginParam.setPassword2(userLoginParam.getPassword2());
        int result = accountInfoService.renewpwd(userLoginParam);
        if (result == 0) {
            return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50002, AccountConstants.ACCOUNT_ERROR_CODE_50002_MSG);
        } else {
            stringRedisTemplate.delete("tyj_phone_code:" + userLoginParam.getPhone());
            String temp = stringRedisTemplate.opsForValue().get("tyj_phone:" + userLoginParam.getPhone());
            if (temp != null) {
                String token = temp.substring(temp.indexOf("【") + 1, temp.indexOf("】"));
                stringRedisTemplate.delete("tyj_token:" + token);
                stringRedisTemplate.delete("tyj_phone:" + userLoginParam.getPhone());
                accountRedisService.delete(userLoginParam.getPhone());
            }
            return MapUtils.buildSuccessMap(Constants.SUCCESS, "用户密码修改成功", null);
        }
    }

}
