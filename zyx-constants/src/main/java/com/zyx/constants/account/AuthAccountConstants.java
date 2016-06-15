package com.zyx.constants.account;

/**
 * Created by WeiMinSheng on 2016/6/14.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title AuthAccountConstants.java
 */
public interface AuthAccountConstants {

    /**
     * 未登录
     */
    int ACCOUNT_ERROR_CODE_50000 = 50000;
    String ACCOUNT_ERROR_CODE_50000_MSG = "token失效";

    /**
     * 用户名密码错误
     */
    int ACCOUNT_ERROR_CODE_50001 = 50001;
    String ACCOUNT_ERROR_CODE_50001_MSG = "用户名、密码错误";

    /**
     * 用户信息修改失败
     */
    int ACCOUNT_ERROR_CODE_50002 = 50002;
    String ACCOUNT_ERROR_CODE_50002_MSG = "用户信息修改失败";

    /**
     * 手机号码未注册
     */
    int ACCOUNT_ERROR_CODE_50003 = 50003;
    String ACCOUNT_ERROR_CODE_50003_MSG = "手机号码未注册";

    /**
     * 重复登录
     */
    int ACCOUNT_ERROR_CODE_50004 = 50004;
    String ACCOUNT_ERROR_CODE_50004_MSG = "重复登录";


    /**
     * 验证码输入错误
     */
    int ACCOUNT_CODE_ERROR = 10003;
    String ACCOUNT_CODE_ERROR_MSG = "验证码输入错误";

    /**
     * 注册用户失败，未知错误
     */
    int ACCOUNT_REGISTER_ERROR = 10004;
    String ACCOUNT_REGISTER_ERROR_MSG = "注册用户失败，未知错误";

    /**
     * 注册用户失败，手机号已存在
     */
    int ACCOUNT_REGISTER_PHONE_ERROR = 10005;
    String ACCOUNT_REGISTER_PHONE_ERROR_MSG = "注册用户失败，手机号已存在";
}
