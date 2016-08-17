package com.zyx.rpc.attention;

import com.zyx.param.attention.AttentionParam;

import java.util.Map;

/**
 * Created by wms on 2016/8/15.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title UserAttentionFacade.java
 */
public interface UserAttentionFacade {

    Map<String, Object> attentionFromAToB(AttentionParam attentionParam);

    Map<String, Object> myFSList(AttentionParam attentionParam);

    Map<String, Object> myGZList(AttentionParam attentionParam);

}
