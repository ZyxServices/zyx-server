package com.zyx.service.account.impl;

import com.zyx.entity.account.UserMsgInfo;
import com.zyx.mapper.account.UserMsgMapper;
import com.zyx.param.account.UserMsgParam;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.account.UserMsgService;
import com.zyx.vo.account.MsgVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wms on 2016/9/27.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/9/27
 */
@Service("userMsgService")
public class UserMsgServiceImpl extends BaseServiceImpl<UserMsgInfo> implements UserMsgService {

    @Autowired
    private UserMsgMapper userMsgMapper;

    public UserMsgServiceImpl() {
        super(UserMsgInfo.class);
    }


    @Override
    public Long queryMsgCount(UserMsgParam userMsgParam) {
        return userMsgMapper.queryMsgCount(userMsgParam);
    }

    @Override
    public List<MsgVo> queryMsgList(UserMsgParam userMsgParam) {
        return null;
    }
}
