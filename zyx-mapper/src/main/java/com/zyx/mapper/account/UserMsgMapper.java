package com.zyx.mapper.account;

import com.zyx.entity.account.UserMsgInfo;
import com.zyx.mapper.BaseMapper;
import com.zyx.param.account.UserMsgParam;
import org.springframework.stereotype.Repository;

/**
 * Created by wms on 2016/9/27.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/9/27
 */
@Repository("userMsgMapper")
public interface UserMsgMapper extends BaseMapper<UserMsgInfo> {
    Long queryMsgCount(UserMsgParam userMsgParam);
}
