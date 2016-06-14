package com.zyx.constants;

/**
 * Created by Rainbow on 16-6-12.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title com.zyx.constants
 */
public interface AuthConstants {

    String AUTH_STATE = "state";
    String AUTH_SUCCESS = "result";
    String AUTH_ERROR_CODE = "error_code";
    String AUTH_ERRORMSG = "error";


    /***************************
     * 返回code信息
     ***************************************/

    //参数缺省
    int AUTH_SUCCESS_100 = 100;
    //成功
    int AUTH_SUCCESS_200 = 200;
    //
    int AUTH_SUCCESS_301 = 301;
    //
    int AUTH_SUCCESS_404 = 404;
    //
    int AUTH_SUCCESS_500 = 500;

    // 登陆
    int ACCOUNT_LOGIN_SUCCESS = 10000;

    int ACCOUNT_INFO_ERROR = 10001;

    int ACCOUNT_LOGIN_ERROR = 10002;

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
