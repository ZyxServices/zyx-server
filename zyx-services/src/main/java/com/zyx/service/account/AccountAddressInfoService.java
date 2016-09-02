package com.zyx.service.account;

import com.zyx.entity.account.UserAddressInfo;
import com.zyx.entity.account.param.UserAddressParam;
import com.zyx.service.BaseService;
import com.zyx.vo.account.UserAddressVo;

import java.util.List;

/**
 * Created by WeiMinSheng on 2016/6/21.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title AccountAddressInfoService.java
 */
public interface AccountAddressInfoService extends BaseService<UserAddressInfo> {
    UserAddressVo selectAddressByAddressId(UserAddressParam userAddressParam);

    List<UserAddressVo> selectAddressList(UserAddressParam userAddressParam);

    int insertAccountAddressInfo(UserAddressParam userAddressParam);

    int deleteByAddressId(UserAddressParam userAddressParam);

    int setDefaultReceiptAddress(UserAddressParam userAddressParam) throws Exception;

    int editReceiptAddress(UserAddressParam userAddressParam);
}
