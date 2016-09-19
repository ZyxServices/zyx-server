package com.zyx.rpc.account.impl;

import com.zyx.constants.account.AccountConstants;
import com.zyx.entity.account.AccountInfo;
import com.zyx.param.account.UserLoginParam;
import com.zyx.rpc.account.RegisterFacade;
import com.zyx.service.account.AccountInfoService;
import com.zyx.service.account.AccountRedisService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.account.AccountInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WeiMinSheng on 2016/6/12.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
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
        try {
            // 判断缓存中手机号码和验证码是否对应
            String redis_code = stringRedisTemplate.opsForValue().get(AccountConstants.REDIS_KEY_TYJ_PHONE_CODE + userLoginParam.getPhone());

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
            return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "手机号和验证码匹配成功", map);
        } catch (Exception e) {
            e.printStackTrace();
            return AccountConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> registerAccount(UserLoginParam userLoginParam) {
        try {
            // 判断手机号是否已经注册
            int count = accountInfoService.selectAccountByPhone(userLoginParam.getPhone());
            if (count != 0) {// 手机号码重复
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50005, AccountConstants.ACCOUNT_ERROR_CODE_50005_MSG);
            }

            // 判断缓存中手机号码和验证码是否对应
            String redis_code = stringRedisTemplate.opsForValue().get(AccountConstants.REDIS_KEY_TYJ_PHONE_CODE + userLoginParam.getPhone());
//        if (!userLoginParam.getCode().equals(redis_code)) {
//            map.put(Constants.STATE, AccountConstants.ACCOUNT_ERROR_CODE_50006);
//            map.put(Constants.ERROR_MSG, AccountConstants.ACCOUNT_ERROR_CODE_50006_MSG);
//            return map;
//        }
            // 判断缓存中手机号码是否存在验证码
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
            return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, AccountConstants.ACCOUNT_SUCCESS_CODE_50013_MSG, accountInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return AccountConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> renewpwd(UserLoginParam userLoginParam) {
        try {
            String phone = stringRedisTemplate.opsForValue().get(AccountConstants.REDIS_KEY_TYJ_TOKEN + userLoginParam.getToken());
            // 判断token是否失效
            if (phone == null) {
                return AccountConstants.MAP_TOKEN_FAILURE;
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
            return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "用户密码修改成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return AccountConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> retrievepwd(UserLoginParam userLoginParam) {
        try {
            // 判断缓存中手机号码和验证码是否对应
            String redis_code = stringRedisTemplate.opsForValue().get(AccountConstants.REDIS_KEY_TYJ_PHONE_CODE + userLoginParam.getPhone());
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
            }
            stringRedisTemplate.delete(AccountConstants.REDIS_KEY_TYJ_PHONE_CODE + userLoginParam.getPhone());
            String temp = stringRedisTemplate.opsForValue().get(AccountConstants.REDIS_KEY_TYJ_PHONE + userLoginParam.getPhone());
            if (temp != null) {
                String token = temp.substring(temp.indexOf("【") + 1, temp.indexOf("】"));
                stringRedisTemplate.delete(AccountConstants.REDIS_KEY_TYJ_TOKEN + token);
                stringRedisTemplate.delete(AccountConstants.REDIS_KEY_TYJ_PHONE + userLoginParam.getPhone());
                accountRedisService.delete(userLoginParam.getPhone());
            }
            return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "用户密码修改成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return AccountConstants.MAP_500;
        }
    }

}
