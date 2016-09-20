package com.zyx.service.account;

import com.zyx.entity.account.AccountInfo;
import com.zyx.param.account.UserAuthParam;
import com.zyx.param.account.UserLoginParam;
import com.zyx.param.account.AccountInfoParam;
import com.zyx.service.BaseService;
import com.zyx.vo.account.AccountAuthVo;
import com.zyx.vo.account.AccountInfoVo;
import com.zyx.vo.account.MyCenterInfoVo;

import java.util.List;

/**
 * Created by wms on 2016/6/13.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title AccountInfoService.java
 */
public interface AccountInfoService extends BaseService<AccountInfo> {
    /**
     * 通过手机号码查询用户数量
     *
     * @param phone
     * @return
     */
    int selectAccountByPhone(String phone);

    /**
     * 通过参数查询用户列表
     *
     * @param userLoginParam
     * @return
     */
    List<AccountInfoVo> selectAccountByParam(UserLoginParam userLoginParam);


    /**
     * 更新密码
     *
     * @param userLoginParam
     * @return
     */
    int renewpwd(UserLoginParam userLoginParam);

    /**
     * 修改用户信息
     *
     * @param param
     * @return
     */
    int updateAccountByParam(AccountInfoParam param);

    /**
     * 查询多个用户信息的基础信息
     *
     * @param ids
     * @return
     */
    List<AccountInfo> selectBaseInfo(List<Integer> ids);

    /**
     * 个人中心用户信息查询接口
     *
     * @param userLoginParam
     * @return
     */
    MyCenterInfoVo queryMyCenterInfo(UserLoginParam userLoginParam);

    /**
     * 审核信息提交接口
     *
     * @param userAuthParam
     * @return
     */
    int submitAccountAuthByParam(UserAuthParam userAuthParam);

    AccountAuthVo queryMyAuthInfo(int userId);
}
