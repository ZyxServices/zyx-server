package com.zyx.vo.pg;

import java.util.List;

/**
 * Created by MrDeng on 2016/7/21.
 */
public class ZanVo {
    private Integer type;
    private List<Integer> bodyIds;

    public void setType(Integer type) {
        this.type = type;
    }

    public void setBodyIds(List<Integer> bodyIds) {
        this.bodyIds = bodyIds;
    }

    public Integer getType() {
        return type;
    }

    public List<Integer> getBodyIds() {
        return bodyIds;
    }
}
