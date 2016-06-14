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
public interface AuthActivityConstants {

    /****************常用常量*******************/
    String defaultDatePattern = "yyyy-MM-dd HH:mm:ss";

    SimpleDateFormat SDF = new SimpleDateFormat(defaultDatePattern);

    /*************************活动返回码****************************************/

    //活动发布失败
    int AUTH_SUCCESS_10000 = 10000;
    //活动已被关闭
    int AUTH_SUCCESS_10001 = 10001;
    //查无数据
    int AUTH_SUCCESS_10002 = 10002;
    //分页参数无效
    int AUTH_SUCCESS_10003 = 10003;
}
