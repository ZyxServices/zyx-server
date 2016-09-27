package com.zyx.rpc.system;

import com.zyx.param.account.UserMsgParam;

import java.util.Map;

/**
 * Created by wms on 2016/9/27.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/9/27
 */
public interface MsgFacade {

    Map<String, Object> insertMsg(UserMsgParam userMsgParam);

    Map<String, Object> queryMsgCount(UserMsgParam userMsgParam);

    Map<String, Object> queryMsgList(UserMsgParam userMsgParam);

}
