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

    //参数缺省,未知错误
    int AUTH_ERROR_100 = 100;
    //成功
    int AUTH_SUCCESS_200 = 200;
    //
    int AUTH_SUCCESS_301 = 301;
    //
    int AUTH_ERROR_404 = 404;
    //
    int AUTH_ERROR_500 = 500;
    //图片上传文件大于5MB
    int AUTH_ERROR_901 = 901;
    //文件上传失败
    int AUTH_ERROR_902 = 902;
    //文件格式错误
    int AUTH_ERROR_903 = 903;

    // 登陆
    int ACCOUNT_LOGIN_SUCCESS = 10000;

    int ACCOUNT_INFO_ERROR = 10001;

    int ACCOUNT_LOGIN_ERROR = 10002;



}
