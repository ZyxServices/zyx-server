package com.zyx.rpc.account.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.account.AccountConstants;
import com.zyx.rpc.account.AccountCommonFacade;
import com.zyx.service.account.AccountInfoService;
import com.zyx.utils.HttpClientUtils;
import com.zyx.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by WeiMinSheng on 2016/6/15.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title AccountCommonFacadeImpl.java
 */
@Service("accountCommonFacade")
public class AccountCommonFacadeImpl implements AccountCommonFacade {

    private static final String CHARSET_UTF_8 = "UTF-8";

    private static final String SEND_URL = "http://www.mxtong.net.cn/GateWay/Services.asmx/DirectSend";

    @Autowired
    private AccountInfoService accountInfoService;

    @Autowired
    protected RedisTemplate<String, String> jedisTemplate;

    @Override
    public Map<String, Object> sendPhoneCode(String phone, String message) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            // 判断手机号是否已经注册
            int count = accountInfoService.selectAccountByPhone(phone);
            if (count != 0) {// 手机号码重复
                map.put(Constants.STATE, AccountConstants.ACCOUNT_ERROR_CODE_50005);
                map.put(Constants.ERROR_MSG, AccountConstants.ACCOUNT_ERROR_CODE_50005_MSG);
                return map;
            }

            String phone_code = jedisTemplate.opsForValue().get(phone);
            if (phone_code != null) {// 存在验证码
                map.put(Constants.STATE, AccountConstants.ACCOUNT_ERROR_CODE_50007);
                map.put(Constants.ERROR_MSG, AccountConstants.ACCOUNT_ERROR_CODE_50007_MSG);
                return map;
            }

            String random = RandomUtil.generateNumString(6);//  验证码

            String content;
            if (message != null && !message.equals("")) {
                content = java.net.URLEncoder.encode(message + "【体育家】", "UTF-8");
            } else {
                content = java.net.URLEncoder.encode("验证码" + random + "，你正在使用体育家，感谢你的支持，体育家将持续为你服务！！！【体育家】", "UTF-8");
            }
            Properties props = new Properties();
            props.load(new InputStreamReader(RegisterFacadeImpl.class.getClassLoader().getResourceAsStream("SMS.properties"), CHARSET_UTF_8));

            Map<String, Object> props_map = new HashMap<String, Object>();
            props_map.put("UserID", props.getProperty("sms.id"));
            props_map.put("Account", props.getProperty("sms.account"));
            props_map.put("Password", props.getProperty("sms.password"));
            props_map.put("SendType", props.getProperty("sms.sendType"));
            props_map.put("PostFixNumber", props.getProperty("sms.PostFixNumber"));
            props_map.put("SendTime", "");
            props_map.put("Phones", phone);
            props_map.put("Content", content);

            String request = null;
            for (int i = 0; i < 3; i++) {
                request = HttpClientUtils.postRequest(SEND_URL, props_map);
                if (request != null) {
                    break;
                }
            }
            if (request == null) {
                map.put(Constants.STATE, AccountConstants.ACCOUNT_ERROR_CODE_50009);
                map.put(Constants.ERROR_MSG, AccountConstants.ACCOUNT_ERROR_CODE_50009_MSG);
                return map;
            }

            int beginPoint = request.indexOf("<RetCode>");
            int endPoint = request.indexOf("</RetCode>");

            String substring = request.substring(beginPoint + 9, endPoint);
            if (substring.equals("Sucess")) {
                jedisTemplate.opsForValue().set("tyj_phone_code:" + phone, random, 30 * 60, TimeUnit.SECONDS);
                jedisTemplate.opsForValue().set(phone, "", 60, TimeUnit.SECONDS);
                map.put(Constants.STATE, Constants.SUCCESS);
                map.put(Constants.SUCCESS_MSG, "验证码发送成功！！！");
                map.put("code", random);
            } else {
                map.put(Constants.STATE, AccountConstants.ACCOUNT_ERROR_CODE_50009);
                map.put(Constants.ERROR_MSG, AccountConstants.ACCOUNT_ERROR_CODE_50009_MSG);
            }
            return map;
        } catch (IOException e) {
            map.put(Constants.STATE, AccountConstants.ACCOUNT_ERROR_CODE_50008);
            map.put(Constants.ERROR_MSG, AccountConstants.ACCOUNT_ERROR_CODE_50008_MSG);
            return map;
        }

    }

}
