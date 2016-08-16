package com.zyx.param.attention;

import com.zyx.param.BaseParam;

/**
 * Created by wms on 2016/8/15.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title AttentionParam.java
 */
public class AttentionParam extends BaseParam {
    private static final long serialVersionUID = 5872829084113496535L;

    private Integer fromId;

    private Integer toId;

    private Integer type;

    public AttentionParam() {
    }

    public AttentionParam(Integer fromId, Integer toId) {
        this(fromId, toId, 1);
    }

    public AttentionParam(Integer fromId, Integer toId, Integer type) {
        this.fromId = fromId;
        this.toId = toId;
        this.type = type;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public Integer getToId() {
        return toId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}
