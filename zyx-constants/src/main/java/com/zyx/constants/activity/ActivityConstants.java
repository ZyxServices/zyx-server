package com.zyx.constants.activity;

import java.text.SimpleDateFormat;

/**
 * Created by Rainbow on 16-6-12.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title com.zyx.constants.activity
 */
public interface ActivityConstants {

    /****************
     * 常用常量
     *******************/
    String defaultDatePattern = "yyyy-MM-dd HH:mm:ss";

    SimpleDateFormat SDF = new SimpleDateFormat(defaultDatePattern);

    String AUTH_SUCCESS = "result";

    /*************************
     * 活动返回码
     ****************************************/

    //活动发布失败
    int AUTH_ERROR_10000 = 10000;
    //活动已被关闭
    int AUTH_ERROR_10001 = 10001;
    //查无数据
    int AUTH_ERROR_10002 = 10002;
    //分页参数无效
    int AUTH_ERROR_10003 = 10003;
    //活动报名失败
    int AUTH_ERROR_10004 = 10004;
    //活动报名信息已存在
    int AUTH_ERROR_10005 = 10005;
    //活动报名信息审核失败
    int AUTH_ERROR_10006 = 10006;
}
