package com.zyx.mapper.account;

import com.zyx.entity.account.UserAddressInfo;
import com.zyx.entity.account.param.UserAddressParam;
import com.zyx.mapper.BaseMapper;
import com.zyx.vo.account.UserAddressVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by WeiMinSheng on 2016/6/21.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title UserAddressMapper.java
 */
@Repository("userAddressMapper")
public interface UserAddressMapper extends BaseMapper<UserAddressInfo> {

    UserAddressVo queryAddressInfo(UserAddressParam userAddressParam);

    List<UserAddressVo> queryAddressList(UserAddressParam userAddressParam);

    int deleteByAddressId(UserAddressParam userAddressParam);

    int setDefaultReceiptAddress(UserAddressParam userAddressParam);

    int cancelDefaultReceiptAddress(UserAddressParam userAddressParam);

    int editReceiptAddress(UserAddressParam userAddressParam);
}
