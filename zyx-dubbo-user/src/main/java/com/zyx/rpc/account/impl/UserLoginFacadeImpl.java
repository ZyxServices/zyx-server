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

import java.util.Map;
import java.util.UUID;

/**
 * Created by wms on 2016/6/12.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
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
        try {
            // 判断手机号码是否注册
            int count = accountInfoService.selectAccountByPhone(phone);
            if (count == 0) {// 未注册
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50003, AccountConstants.ACCOUNT_ERROR_CODE_50003_MSG);
            }
            // 判断用户名密码是否正确
            AccountInfoVo accountInfo = userLoginService.loginByPhoneAndPassword(phone, password);
            if (accountInfo == null) {// 登陆失败
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50001, AccountConstants.ACCOUNT_ERROR_CODE_50001_MSG);
            }
            // 判断是否已经登录,已登录的情况下删除登录信息
            String phoneTime = stringRedisTemplate.opsForValue().get(AccountConstants.REDIS_KEY_TYJ_PHONE + phone);
            if (phoneTime != null) {
                // 获取登陆TOKEN
                String token = phoneTime.substring(phoneTime.indexOf("【") + 1, phoneTime.indexOf("】"));
                stringRedisTemplate.delete(AccountConstants.REDIS_KEY_TYJ_TOKEN + token);
                stringRedisTemplate.delete(AccountConstants.REDIS_KEY_TYJ_PHONE + phone);
                String token_new = UUID.randomUUID().toString().replaceAll("-", "");
                String _newTyjPhone = phoneTime.replaceAll(token, token_new);
                stringRedisTemplate.opsForValue().set(AccountConstants.REDIS_KEY_TYJ_TOKEN + token_new, phone);
                stringRedisTemplate.opsForValue().set(AccountConstants.REDIS_KEY_TYJ_PHONE + phone, _newTyjPhone);
                accountInfo.setToken(token_new);
            } else {
                // 登录成功返回
                String token = UUID.randomUUID().toString().replaceAll("-", "");
                stringRedisTemplate.opsForValue().set(AccountConstants.REDIS_KEY_TYJ_TOKEN + token, phone);
                stringRedisTemplate.opsForValue().set(AccountConstants.REDIS_KEY_TYJ_PHONE + phone, System.currentTimeMillis() + "【" + token + "】");
                accountInfo.setToken(token);
            }
            accountRedisService.put(accountInfo);
            return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "登录成功", accountInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return AccountConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> signout(String token) {
        try {
            String phone = stringRedisTemplate.opsForValue().get(AccountConstants.REDIS_KEY_TYJ_TOKEN + token);
            // 判断token是否失效
            if (phone == null) {
                return AccountConstants.MAP_TOKEN_FAILURE;
            }
            stringRedisTemplate.delete(AccountConstants.REDIS_KEY_TYJ_TOKEN + token);
            stringRedisTemplate.delete(AccountConstants.REDIS_KEY_TYJ_PHONE + phone);
            AccountInfoVo accountInfoVo = new AccountInfoVo();
            accountInfoVo.setPhone(phone);
            accountRedisService.delete(phone);
            return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "退出成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return AccountConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> refreshtoken(String token) {
        try {
            String phone = stringRedisTemplate.opsForValue().get(AccountConstants.REDIS_KEY_TYJ_TOKEN + token);
            // 判断token是否失效
            if (phone == null) {
                return AccountConstants.MAP_TOKEN_FAILURE;
            }
            String token_new = UUID.randomUUID().toString().replaceAll("-", "");
            String _newTyjPhone = stringRedisTemplate.opsForValue().get(AccountConstants.REDIS_KEY_TYJ_PHONE + phone).replaceAll(token, token_new);
            stringRedisTemplate.delete(AccountConstants.REDIS_KEY_TYJ_TOKEN + token);
            stringRedisTemplate.delete(AccountConstants.REDIS_KEY_TYJ_PHONE + phone);
            stringRedisTemplate.opsForValue().set(AccountConstants.REDIS_KEY_TYJ_TOKEN + token_new, phone);
            stringRedisTemplate.opsForValue().set(AccountConstants.REDIS_KEY_TYJ_PHONE + phone, _newTyjPhone);
            return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "TOKEN刷新成功", token_new);
        } catch (Exception e) {
            e.printStackTrace();
            return AccountConstants.MAP_500;
        }
    }

}
