package com.zyx.constants;

/**
 * Created by Rainbow on 16-6-12.
 *
 * @author SubDong
 * @version V1.0 Copyright (c)2016 tyj-版权所有
 * @title com.zyx.constants
 */
public interface Constants {

    // String AUTH_STATE = "state";
    // String AUTH_SUCCESS = "result";
    // String AUTH_ERROR_CODE = "error_code";
    // String AUTH_ERRORMSG = "error";

    /***************************
     * 返回code信息
     ***************************************/

    // 未知错误
    // int AUTH_ERROR_100 = 100;
    // // 成功
    // int AUTH_SUCCESS_200 = 200;
    // // 参数无效,参数缺省
    // int AUTH_ERROR_300 = 300;
    // // 不合法的Token，一般是有其它相同终端登录
    // int AUTH_ERROR_301 = 307;
    // // 过期的Token
    // int AUTH_ERROR_308 = 308;
    // // 未认证，客户端没有传入合法的Cookie
    // int AUTH_RRROR_310 = 310;
    // //
    // int AUTH_ERROR_404 = 404;
    // //
    // int AUTH_ERROR_500 = 500;
    // // 图片上传文件大于5MB
    // int AUTH_ERROR_901 = 901;
    // // 文件上传失败
    // int AUTH_ERROR_902 = 902;
    // // 文件格式错误
    // int AUTH_ERROR_903 = 903;

    ////////////// 系统标识符 开始//////////////////
    /**
     * 状态 标志
     */
    String STATE = "state";
    /**
     * 错误代码 标志
     */
    String ERROR_CODE = "errcode";
    /**
     * 错误消息 标志
     */
    String ERROR_MSG = "errmsg";

    /**
     * 成功消息 标志
     */
    String SUCCESS_MSG = "successmsg";
    ////////////// 系统标识符 结束//////////////////

    ////////////// 系统状态码 开始//////////////////
    ////////
    /**
     * 请求失败
     */
    int ERROR = 100;
    /**
     * 请求成功
     */
    int SUCCESS = 200;
    /// 参数相关代码 300~399
    /**
     * 参数错误代码
     */
    int PARAM_ERROR = 300;
    /**
     * 参数缺失
     */
    int PARAM_MISS = 301;

    /**
     * 非法参数 如大小 长度 类型不正确
     */
    int PARAM_ILIGAL = 302;

    /// 请求类型代码
    /**
     * 请求错误
     */
    int REQUEST_ERROR = 400;
    /**
     * 无权限请求
     */
    int REQUEST_UNAUTHORIZED = 401;

    //文件类型 900+

    /**
     * 图片上传文件大于5MB
     */
    int AUTH_ERROR_901 = 901;
    /**
     * 服务器错误
     */
    int ERROR_500 = 500;
    /**
     * 文件上传失败
     */
    int AUTH_ERROR_902 = 902;
    /**
     * 文件格式错误
     */
    int AUTH_ERROR_903 = 903;
    ////////
    ////////////// 系统状态码 结束//////////////////

    ////////////// 系统消息 开始//////////////////
    /**
     * 错误
     */
    String MSG_ERROR = "error";
    /**
     * 成功
     */
    String MSG_SUCCESS = "success";

    String MSG_PARAM_ERROR = "input paragrams is error";

    String MSG_PARAM_MISS = "missing paragrams";

    String MSG_PARAM_ILIGAL = "iligal paragram";

    String MSG_REQUEST_ERROR = "request error";

    String MSG_REQUEST_UNAUTHORIZED = "unauthorized request";

    ////////////// 系统消息 结束//////////////////
}
