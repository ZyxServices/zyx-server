package com.zyx.mapper.account;

import com.zyx.entity.account.UserMarkInfo;
import com.zyx.param.account.UserMarkParam;
import com.zyx.mapper.BaseMapper;
import com.zyx.vo.account.MarkInfoVo;

/**
 * Created by WeiMinSheng on 2016/6/15.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title UserMarkMapper.java
 */
public interface UserMarkMapper extends BaseMapper<UserMarkInfo> {

    MarkInfoVo queryMarkInfo(UserMarkParam userMarkParam);

    int updateMarkInfo(UserMarkParam userMarkParam);
}
