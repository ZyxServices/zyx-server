package com.zyx.mapper.account;

import com.zyx.entity.account.AccountInfo;
import com.zyx.param.account.UserAuthParam;
import com.zyx.param.account.UserLoginParam;
import com.zyx.param.account.AccountInfoParam;
import com.zyx.mapper.BaseMapper;
import com.zyx.vo.account.AccountInfoVo;
import com.zyx.vo.account.QueryUserInfoVo;
import org.springframework.stereotype.Repository;
import com.zyx.vo.account.MyCenterInfoVo;

import java.util.List;

/**
 * Created by wms on 2016/6/13.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 */
@Repository("accountInfoMapper")
public interface AccountInfoMapper extends BaseMapper<AccountInfo> {
    int selectAccountByPhone(String phone);

    List<AccountInfoVo> selectAccountByParam(UserLoginParam userLoginParam);

    int renewpwd(UserLoginParam userLoginParam);

    int updateAccountByParam(AccountInfoParam param);

    /**
     * 通过ID查询用户简单信息
     */
    QueryUserInfoVo selectAccountById(Integer id);

    MyCenterInfoVo queryMyCenterInfo(UserLoginParam userLoginParam);

    int updateAccountAuthStatusByParam(UserAuthParam userAuthParam);

    int insertAccountAuthByParam(UserAuthParam userAuthParam);

    int updateAccountAuthByParam(UserAuthParam userAuthParam);

    int selectAccountAuthCount(Integer user_id);
}
