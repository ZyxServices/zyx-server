package com.zyx.service.account.impl;

import com.zyx.entity.account.UserAddressInfo;
import com.zyx.entity.account.param.UserAddressParam;
import com.zyx.mapper.account.UserAddressMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.account.AccountAddressInfoService;
import com.zyx.vo.account.UserAddressVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wms on 2016/6/21.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title AccountAddressInfoServiceImpl.java
 */
@Service("accountAddressInfoService")
public class AccountAddressInfoServiceImpl extends BaseServiceImpl<UserAddressInfo> implements AccountAddressInfoService {

    @Autowired
    private UserAddressMapper userAddressMapper;

    public AccountAddressInfoServiceImpl() {
        super(UserAddressInfo.class);
    }

    @Override
    public int insertAccountAddressInfo(UserAddressParam param) {
        UserAddressInfo userAddressInfo = new UserAddressInfo();
        userAddressInfo.setUserId(param.getUserId());
        userAddressInfo.setAddressId(param.getAddressId());
        userAddressInfo.setReceiver(param.getReceiver());
        userAddressInfo.setPhone(param.getPhone());
        userAddressInfo.setZipCode(param.getZipCode());
        userAddressInfo.setContent(param.getContent());
        userAddressInfo.setStatus(false);
        userAddressInfo.setCreateTime(System.currentTimeMillis());
        return mapper.insert(userAddressInfo);
    }

    @Override
    public UserAddressVo selectAddressByAddressId(UserAddressParam userAddressParam) {
        UserAddressMapper userAddressMapper = (UserAddressMapper) mapper;
        return userAddressMapper.queryAddressInfo(userAddressParam);
    }

    @Override
    public List<UserAddressVo> selectAddressList(UserAddressParam userAddressParam) {
        UserAddressMapper userAddressMapper = (UserAddressMapper) mapper;
        return userAddressMapper.queryAddressList(userAddressParam);
    }

    @Override
    public int deleteByAddressId(UserAddressParam userAddressParam) {
        UserAddressMapper userAddressMapper = (UserAddressMapper) mapper;
        return userAddressMapper.deleteByAddressId(userAddressParam);
    }

    @Override
    public int editReceiptAddress(UserAddressParam userAddressParam) {
        UserAddressMapper userAddressMapper = (UserAddressMapper) mapper;
        return userAddressMapper.editReceiptAddress(userAddressParam);
    }

    @Override
    public int setDefaultReceiptAddress(UserAddressParam userAddressParam) throws Exception {
        int result = userAddressMapper.setDefaultReceiptAddress(userAddressParam);
        if (result == 1) {
            userAddressMapper.cancelDefaultReceiptAddress(userAddressParam);
        }
        return result;
    }

}
