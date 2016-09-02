package com.zyx.service.attention;

import com.zyx.entity.attention.UserAttention;
import com.zyx.param.attention.AttentionParam;
import com.zyx.service.BaseService;
import com.zyx.vo.attention.AttentionVo;

import java.util.List;

/**
 * Created by wms on 2016/8/16.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title UserAttentionService.java
 */

public interface UserAttentionService extends BaseService<UserAttention> {

    List<AttentionVo> myFSList(AttentionParam attentionParam);

    List<AttentionVo> myGZList(AttentionParam attentionParam);

    int selectAttentionCount(AttentionParam attentionParam);

    List<AttentionVo> myDKGZList(AttentionParam attentionParam);

    int deleteAttention(AttentionParam attentionParam);
}
