package com.zyx.constants.attention;

import com.zyx.constants.Constants;

/**
 * Created by wms on 2016/8/16.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title UserAttentionConstants.java
 */
public interface UserAttentionConstants extends Constants {

    /**
     * 关注失败
     */
    int ATTENTION_70001 = 70001;
    String ATTENTION_70001_MSG = "关注对象失败";

    /**
     * 查询失败
     */
    int ATTENTION_70002 = 70002;
    String ATTENTION_70002_MSG = "查询失败";

    /**
     * 重复关注
     */
    int ATTENTION_70003 = 70003;
    String ATTENTION_70003_MSG = "重复关注";

    /**
     * 取消关注失败
     */
    int ATTENTION_70004 = 70004;
    String ATTENTION_70004_MSG = "取消关注对象失败";

    /**
     * 关注对象失败，不能关注自己
     */
    int ATTENTION_70005 = 70005;
    String ATTENTION_70005_MSG = "关注对象失败，不能关注自己";
}
