package com.account.dubborpc.impl;

import com.account.dubborpc.RegisterFacade;
import com.zyx.constants.AuthConstants;
import com.zyx.constants.account.AuthAccountConstants;
import com.zyx.entity.account.AccountInfo;
import com.zyx.entity.account.UserLoginParam;
import com.zyx.service.account.AccountInfoService;
import com.zyx.utils.CipherUtil;
import com.zyx.utils.HttpClientUtils;
import com.zyx.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by WeiMinSheng on 2016/6/12.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title RegisterFacadeImpl.java
 */
public class RegisterFacadeImpl implements RegisterFacade {

    private static final String CHARSET_UTF_8 = "UTF-8";

    @Autowired
    private AccountInfoService accountInfoService;

    @Autowired
    protected RedisTemplate<String, String> jedisTemplate;

    @Override
    public int sendPhoneCode(String phone, String message) {
        String url = "http://www.mxtong.net.cn/GateWay/Services.asmx/DirectSend";

        try {
            String phone_code = jedisTemplate.opsForValue().get(phone);
            if (phone_code != null) {// 存在验证码
                return 502;
            }

            //验证码
            String random = RandomUtil.generateNumString(6);

            String content;
            if (message != null && !message.equals("")) {
                content = java.net.URLEncoder.encode(message + "【体育家】", "UTF-8");
            } else {
                content = java.net.URLEncoder.encode("验证码" + random + "，你正在使用体育家，感谢你的支持，体育家将持续为你服务！！！【体育家】", "UTF-8");
            }
            Properties props = new Properties();
            props.load(new InputStreamReader(RegisterFacadeImpl.class.getClassLoader().getResourceAsStream("SMS.properties"), CHARSET_UTF_8));

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("UserID", props.getProperty("sms.id"));
            map.put("Account", props.getProperty("sms.account"));
            map.put("Password", props.getProperty("sms.password"));
            map.put("SendType", props.getProperty("sms.sendType"));
            map.put("PostFixNumber", props.getProperty("sms.PostFixNumber"));
            map.put("SendTime", "");
            map.put("Phones", phone);
            map.put("Content", content);

            String request = null;
            for (int i = 0; i < 3; i++) {
                request = HttpClientUtils.postRequest(url, map);
                if (request != null) {
                    break;
                }
            }
            if (request == null) {
                return -1;
            }

            int beginPoint = request.indexOf("<RetCode>");
            int endPoint = request.indexOf("</RetCode>");

            String substring = request.substring(beginPoint + 9, endPoint);
            if (substring.equals("Sucess")) {
                //TODO：添加redis
                System.out.println(jedisTemplate);
                jedisTemplate.opsForValue().set("tyj_phone_code:" + phone, random, 30 * 60, TimeUnit.SECONDS);
                jedisTemplate.opsForValue().set(phone, "", 60, TimeUnit.SECONDS);
                return 200;
            } else {
                return 501;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }

    }

    @Override
    public Map<String, Object> registerAccount(UserLoginParam userLoginParam) {
        // TODO:判断换成中手机号码和验证码是否对应
        Map<String, Object> map = new HashMap<String, Object>();
        String redis_code = jedisTemplate.opsForValue().get("tyj_phone_code:" + userLoginParam.getPhone());
        if (!userLoginParam.getCode().equals(redis_code)) {
            map.put(AuthConstants.AUTH_ERROR_CODE, AuthConstants.ACCOUNT_CODE_ERROR);
            map.put(AuthConstants.AUTH_ERRORMSG, AuthConstants.ACCOUNT_CODE_ERROR_MSG);
            return map;
        }
        // TODO:判断手机号是否已经注册
        AccountInfo accountInfo = new AccountInfo();
        int count = accountInfoService.selectAccountByPhone(userLoginParam.getPhone());
        if (count != 0) {// 手机号码重复
            map.put(AuthConstants.AUTH_ERROR_CODE, AuthConstants.ACCOUNT_REGISTER_PHONE_ERROR);
            map.put(AuthConstants.AUTH_ERRORMSG, AuthConstants.ACCOUNT_REGISTER_PHONE_ERROR_MSG);
            return map;
        }
        accountInfo.setPhone(userLoginParam.getPhone());
        accountInfo.setPassword(CipherUtil.generatePassword(userLoginParam.getPassword()));
        accountInfo.setNickname("体育家【" + userLoginParam.getPhone() + "】");
        accountInfo.setCreateTime(System.currentTimeMillis());
        int result = accountInfoService.save(accountInfo);
        if (result == 0) {
            map.put(AuthConstants.AUTH_ERROR_CODE, AuthConstants.ACCOUNT_REGISTER_ERROR);
            map.put(AuthConstants.AUTH_ERRORMSG, AuthConstants.ACCOUNT_REGISTER_ERROR_MSG);
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
            map.put(AuthConstants.AUTH_ERROR_CODE, AuthAccountConstants.ACCOUNT_ERROR_CODE_50002);
            map.put(AuthConstants.AUTH_ERRORMSG, AuthAccountConstants.ACCOUNT_ERROR_CODE_50002_MSG);
        } else {
            map.put(AuthConstants.AUTH_STATE, AuthConstants.AUTH_SUCCESS_200);
        }
        return map;
    }
}
