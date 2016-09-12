package com.zyx.constants.account;

import com.zyx.constants.Constants;

/**
 * Created by wms on 2016/6/14.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 */
public interface AccountConstants extends Constants {

    /**
     * 未登录
     */
    int ACCOUNT_ERROR_CODE_50000 = 50000;
    String ACCOUNT_ERROR_CODE_50000_MSG = "用户token已经失效，请重新登录";

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
     * 手机号已注册
     */
    int ACCOUNT_ERROR_CODE_50005 = 50005;
    String ACCOUNT_ERROR_CODE_50005_MSG = "手机号已注册";

    /**
     * 验证码输入错误
     */
    int ACCOUNT_ERROR_CODE_50006 = 50006;
    String ACCOUNT_ERROR_CODE_50006_MSG = "验证码输入错误";

    /**
     * 短信发送失败，短信发送过于频繁！！！
     */
    int ACCOUNT_ERROR_CODE_50007 = 50007;
    String ACCOUNT_ERROR_CODE_50007_MSG = "短信发送失败，短信发送过于频繁！！！";

    /**
     * 短信发送失败，未知错误！！！
     */
    int ACCOUNT_ERROR_CODE_50008 = 50008;
    String ACCOUNT_ERROR_CODE_50008_MSG = "短信发送失败，未知错误！！！";

    /**
     * 短信发送失败，短信服务器异常！！！
     */
    int ACCOUNT_ERROR_CODE_50009 = 50009;
    String ACCOUNT_ERROR_CODE_50009_MSG = "短信发送失败，短信服务器异常！！！";

    /**
     * 服务器DB错误，注册用户失败！！！
     */
    int ACCOUNT_ERROR_CODE_50010 = 50010;
    String ACCOUNT_ERROR_CODE_50010_MSG = "服务器DB错误，注册用户失败！！！";

    /**
     * 非法操作！！！验证码不存在
     */
    int ACCOUNT_ERROR_CODE_50011 = 50011;
    String ACCOUNT_ERROR_CODE_50011_MSG = "非法操作！！！验证码不存在";

    /**
     * 两次输入的密码不正确
     */
    int ACCOUNT_ERROR_CODE_50012 = 50012;
    String ACCOUNT_ERROR_CODE_50012_MSG = "两次输入的密码不正确！！！";

    /**
     * 注册成功
     */
    int ACCOUNT_ERROR_CODE_50013 = 50013;
    String ACCOUNT_SUCCESS_CODE_50013_MSG = "注册成功！！！";

    /**
     * 手机号码不正确
     */
    int ACCOUNT_ERROR_CODE_50014 = 50014;
    String ACCOUNT_ERROR_CODE_50014_MSG = "手机号码不正确！！！";

    /**
     * 发送验证码失败，手机号格式有误
     */
    int ACCOUNT_ERROR_CODE_50100 = 50100;
    String ACCOUNT_ERROR_CODE_50100_MSG = "发送验证码失败，手机号格式有误";

    /**
     * 发送验证码失败，短信类型设置有误
     */
    int ACCOUNT_ERROR_CODE_50101 = 50101;
    String ACCOUNT_ERROR_CODE_50101_MSG = "发送验证码失败，短信类型设置有误";


    /**
     * 该用户第一次签到，插入数据失败！！！
     */
    int ACCOUNT_ERROR_CODE_50200 = 50200;
    String ACCOUNT_ERROR_CODE_50200_MSG = "该用户第一次签到，插入数据失败！！！";

    /**
     * 该用户今天已经签过到了，更新数据失败！！！
     */
    int ACCOUNT_ERROR_CODE_50201 = 50201;
    String ACCOUNT_ERROR_CODE_50201_MSG = "该用户今天已经签过到了，更新数据失败！！！";

    /**
     * 该用户暂无签到数据！！！
     */
    int ACCOUNT_ERROR_CODE_50202 = 50202;
    String ACCOUNT_ERROR_CODE_50202_MSG = "该用户暂无签到数据！！！";

    /**
     * 签到失败，更新数据失败！！！
     */
    int ACCOUNT_ERROR_CODE_50203 = 50203;
    String ACCOUNT_ERROR_CODE_50203_MSG = "签到失败，更新数据失败！！！";

    /**
     * 无数据，查询失败！！！
     */
    int ACCOUNT_ERROR_CODE_50300 = 50300;
    String ACCOUNT_ERROR_CODE_50300_MSG = "无数据，查询失败！！！";

    /**
     * 用户ID与用户不匹配，查询失败！！！
     */
    int ACCOUNT_ERROR_CODE_50301 = 50301;
    String ACCOUNT_ERROR_CODE_50301_MSG = "用户ID与用户不匹配，查询失败！！！";

    /**
     * 服务器DB错误，插入数据失败！！！
     */
    int ACCOUNT_ERROR_CODE_50400 = 50400;
    String ACCOUNT_ERROR_CODE_50400_MSG = "服务器DB错误，插入数据失败！！！";

    /**
     * 服务器DB错误，删除数据失败！！！
     */
    int ACCOUNT_ERROR_CODE_50401 = 50401;
    String ACCOUNT_ERROR_CODE_50401_MSG = "服务器DB错误，删除数据失败！！！";

    /**
     * 服务器DB错误，修改数据失败！！！
     */
    int ACCOUNT_ERROR_CODE_50402 = 50402;
    String ACCOUNT_ERROR_CODE_50402_MSG = "服务器DB错误，修改数据失败！！！";

    /**
     * ---------------------------常量---------------------------------------------
     */

    // ----------------------首推开始----------------------
    int USER_DEVA_MODEL = 5;

    String TYJ_DEVA = "TYJ_DEVA";

    String TYJ_USER_DEVA = "TYJ_USER_DEVA";
    // ----------------------首推结束-----------------------

    //----------------------REDIS参数开始-------------------
    /**
     * token键
     */
    String REDIS_KEY_TYJ_TOKEN = "TYJ_TOKEN:";

    /**
     * phone键
     */
    String REDIS_KEY_TYJ_PHONE = "TYJ_PHONE:";

    /**
     * 验证码键
     */
    String REDIS_KEY_TYJ_PHONE_CODE = "TYJ_PHONE_CODE:";

    //----------------------REDIS参数结束-------------------

    String TIMESTAMP_LONG = "timestamp_long";

    String TIMESTAMP_STRING = "timestamp_string";

    String MARK_INFO = "mark_info";

    /**
     * 注册-发验证码
     */
    String SEND_REGISTER = "register";

    /**
     * 公共-发验证码
     */
    String SEND_PUBLIC = "public";

}
