package com.zyx.vo.attention;

import com.zyx.vo.account.AccountAttentionVo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wms on 2016/8/17.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title AttentionVo.java
 */
public class AttentionVo implements Serializable {

    private Integer id;

    private List<AccountAttentionVo> attentions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<AccountAttentionVo> getAttentions() {
        return attentions;
    }

    public void setAttentions(List<AccountAttentionVo> attentions) {
        this.attentions = attentions;
    }
}
