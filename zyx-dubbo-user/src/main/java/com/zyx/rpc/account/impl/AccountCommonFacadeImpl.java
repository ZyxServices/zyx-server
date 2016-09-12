package com.zyx.rpc.account.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.account.AccountConstants;
import com.zyx.rpc.account.AccountCommonFacade;
import com.zyx.service.account.AccountInfoService;
import com.zyx.service.account.AccountRedisService;
import com.zyx.test.HttpSender;
import com.zyx.utils.MapUtils;
import com.zyx.utils.RandomUtil;
import com.zyx.vo.account.AccountInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStreamReader;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by wms on 2016/6/15.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 */
@Service("accountCommonFacade")
public class AccountCommonFacadeImpl implements AccountCommonFacade {

    private static final String CHARSET_UTF_8 = "UTF-8";

    private static final String SEND_URL = "http://www.mxtong.net.cn/GateWay/Services.asmx/DirectSend";

    @Autowired
    protected RedisTemplate<String, String> stringRedisTemplate;

    @Autowired
    private AccountRedisService accountRedisService;

    @Autowired
    private AccountInfoService accountInfoService;

    @Override
    public Map<String, Object> sendPhoneCode(String phone, String type, String message) {
        try {
            if (phone == null || type == null) {
                return Constants.MAP_PARAM_MISS;
            }
            if (type.equals(AccountConstants.SEND_PUBLIC)) {
                return doSendPhoneCode(phone, message);
            }
            if (type.equals(AccountConstants.SEND_REGISTER)) {
                // 判断手机号是否已经注册
                if (accountInfoService.selectAccountByPhone(phone) != 0) {// 手机号码重复
                    return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50005, AccountConstants.ACCOUNT_ERROR_CODE_50005_MSG);
                }
                return doSendPhoneCode(phone, message);
            }
            return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50101, AccountConstants.ACCOUNT_ERROR_CODE_50101_MSG);
        } catch (Exception e) {
            e.printStackTrace();
            return AccountConstants.MAP_500;
        }

    }

    private Map<String, Object> doSendPhoneCode(String phone, String message) throws Exception {

        String phone_code = stringRedisTemplate.opsForValue().get(phone);
        if (phone_code != null) {// 存在验证码
            return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50007, AccountConstants.ACCOUNT_ERROR_CODE_50007_MSG);
        }

        String random = RandomUtil.generateNumString(6);//  验证码

        String content;
        if (message != null && !message.equals("")) {
//                content = java.net.URLEncoder.encode(message, "UTF-8");
            content = message;
        } else {
//                content = java.net.URLEncoder.encode("验证码" + random + "，你正在使用体育家，感谢你的支持，体育家将持续为你服务！！！", "UTF-8");
            content = "验证码" + random + "，你正在使用体育家，感谢你的支持，体育家将持续为你服务！！！";
        }
        Properties props = new Properties();
//            props.load(new InputStreamReader(RegisterFacadeImpl.class.getClassLoader().getResourceAsStream("SMS.properties"), CHARSET_UTF_8));
        props.load(new InputStreamReader(RegisterFacadeImpl.class.getClassLoader().getResourceAsStream("CLMSG.properties"), CHARSET_UTF_8));

//            Map<String, Object> props_map = new HashMap<String, Object>();
//            props_map.put("UserID", props.getProperty("sms.id"));
//            props_map.put("Account", props.getProperty("sms.account"));
//            props_map.put("Password", props.getProperty("sms.password"));
//            props_map.put("SendType", props.getProperty("sms.sendType"));
//            props_map.put("PostFixNumber", props.getProperty("sms.PostFixNumber"));
//            props_map.put("SendTime", "");
//            props_map.put("Phones", phone);
//            props_map.put("Content", content);
//
//            String request = null;
//            for (int i = 0; i < 3; i++) {
//                request = HttpClientUtils.postRequest(SEND_URL, props_map);
//                if (request != null) {
//                    break;
//                }
//            }
//            if (request == null) {
//                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50009, AccountConstants.ACCOUNT_ERROR_CODE_50009_MSG);
//            }

//            int beginPoint = request.indexOf("<RetCode>");
//            int endPoint = request.indexOf("</RetCode>");
//
//            String substring = request.substring(beginPoint + 9, endPoint);
        String returnString = HttpSender.batchSend(props.getProperty("CLMSG.URL"), props.getProperty("CLMSG.ACCOUNT"), props.getProperty("CLMSG.PSWD"), phone, content, true, null);


        if (returnString.contains(",0")) {
            stringRedisTemplate.opsForValue().set(AccountConstants.REDIS_KEY_TYJ_PHONE_CODE + phone, random, 30 * 60, TimeUnit.SECONDS);
            stringRedisTemplate.opsForValue().set(phone, "", 60, TimeUnit.SECONDS);
            return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "验证码发送成功！！！", random);
        } else {
            if (returnString.contains(",103")) {
                return MapUtils.buildErrorMap(Constants.SUBMIT_OFTEN, Constants.SUBMIT_OFTEN_MSG);
            } else if (returnString.contains(",107")) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50014, AccountConstants.ACCOUNT_ERROR_CODE_50014_MSG);
            } else {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50009, AccountConstants.ACCOUNT_ERROR_CODE_50009_MSG);
            }
        }
    }

    @Override
    public boolean validateToken(String token) {
        String phone = stringRedisTemplate.opsForValue().get(AccountConstants.REDIS_KEY_TYJ_TOKEN + token);
        return !StringUtils.isEmpty(phone);
    }

    @Override
    public AccountInfoVo getAccountVoByToken(String token) {
        String phone = stringRedisTemplate.opsForValue().get(AccountConstants.REDIS_KEY_TYJ_TOKEN + token);
        if (StringUtils.isEmpty(phone)) {
            return null;
        }
        return accountRedisService.get(phone);
    }

}
