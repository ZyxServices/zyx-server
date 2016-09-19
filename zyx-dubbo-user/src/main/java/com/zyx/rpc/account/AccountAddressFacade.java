package com.zyx.rpc.account;

import com.zyx.param.account.UserAddressParam;

import java.util.Map;

/**
 * Created by wms on 2016/6/21.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 */
public interface AccountAddressFacade {

    /**
     * 新增收货地址
     *
     * @param param
     * @return
     */
    Map<String, Object> insertAccountAddressInfo(UserAddressParam param);

    /**
     * 查询收货地址
     *
     * @param param
     * @return
     */
    Map<String, Object> queryAccountAddressInfo(UserAddressParam param);

    /**
     * 查询收货地址列表
     *
     * @param param
     * @return
     */
    Map<String, Object> queryAccountAddressList(UserAddressParam param);

    /**
     * 删除收货地址
     *
     * @param param
     * @return
     */
    Map<String, Object> deleteAccountAddressInfo(UserAddressParam param);

    /**
     * 编辑收货地址
     *
     * @param param
     * @return
     */
    Map<String, Object> editReceiptAddress(UserAddressParam param);

    /**
     * 设置默认收货地址
     *
     * @param param
     * @return
     */
    Map<String, Object> setDefaultReceiptAddress(UserAddressParam param);

}
