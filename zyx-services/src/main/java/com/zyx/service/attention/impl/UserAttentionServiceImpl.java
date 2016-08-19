package com.zyx.service.attention.impl;

import com.zyx.entity.attention.UserAttention;
import com.zyx.mapper.account.UserAddressMapper;
import com.zyx.mapper.attention.UserAttentionMapper;
import com.zyx.param.attention.AttentionParam;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.attention.UserAttentionService;
import com.zyx.vo.attention.AttentionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wms on 2016/8/16.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title UserAttentionServiceImpl.java
 */
@Service("userAttentionService")
public class UserAttentionServiceImpl extends BaseServiceImpl<UserAttention> implements UserAttentionService {

    @Autowired
    private UserAttentionMapper userAttentionMapper;

    public UserAttentionServiceImpl() {
        super(UserAttention.class);
    }

    @Override
    public List<AttentionVo> myFSList(AttentionParam attentionParam) {
        return userAttentionMapper.myFSList(attentionParam);
    }

    @Override
    public List<AttentionVo> myGZList(AttentionParam attentionParam) {
        return userAttentionMapper.myGZList(attentionParam);
    }

    @Override
    public int selectAttentionCount(AttentionParam attentionParam) {
        return userAttentionMapper.selectAttentionCount(attentionParam);
    }
}
