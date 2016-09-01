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

    /**
     * 取消关注，取消拉黑
     *
     * @param attentionParam
     * @return
     */
    Map<String, Object> unAttentionFromAToB(AttentionParam attentionParam);

    Map<String, Object> myFSList(AttentionParam attentionParam);

    Map<String, Object> myGZList(AttentionParam attentionParam);

    /**
     * 我的关注大咖列表
     *
     * @param attentionParam
     * @return
     */
    Map<String, Object> myDKGZList(AttentionParam attentionParam);

}
