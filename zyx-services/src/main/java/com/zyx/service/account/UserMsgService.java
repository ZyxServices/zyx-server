package com.zyx.service.account;

import com.zyx.entity.account.UserMsgInfo;
import com.zyx.param.account.UserMsgParam;
import com.zyx.service.BaseService;
import com.zyx.vo.account.MsgVo;

import java.util.List;

/**
 * Created by wms on 2016/9/27.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/9/27
 */
public interface UserMsgService extends BaseService<UserMsgInfo> {
    Long queryMsgCount(UserMsgParam userMsgParam);

    List<MsgVo> queryMsgList(UserMsgParam userMsgParam);
}
