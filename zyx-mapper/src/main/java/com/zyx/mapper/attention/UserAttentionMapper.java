package com.zyx.mapper.attention;

import com.zyx.entity.attention.UserAttention;
import com.zyx.mapper.BaseMapper;
import com.zyx.param.attention.AttentionParam;
import com.zyx.vo.account.AccountAttentionVo;
import com.zyx.vo.attention.AttentionVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wms on 2016/8/16.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title UserAttentionMapper.java
 */
@Repository("userAttentionMapper")
public interface UserAttentionMapper extends BaseMapper<UserAttention> {

    List<AttentionVo> myFSList(AttentionParam attentionParam);

    List<AttentionVo> myGZList(AttentionParam attentionParam);
}
