package com.zyx.entity.pg.dto;

import java.io.Serializable;

/**
 * Created by MrDeng on 2016/7/21.
 */
public class ZanCountDto implements Serializable{
    private Integer bodyType;
    private Integer bodyId;
    private Integer zanCount;

    public void setBodyType(Integer bodyType) {
        this.bodyType = bodyType;
    }

    public Integer getBodyType() {
        return bodyType;
    }

    public void setBodyId(Integer bodyId) {
        this.bodyId = bodyId;
    }

    public void setZanCount(Integer zanCount) {
        this.zanCount = zanCount;
    }

    public Integer getBodyId() {
        return bodyId;
    }

    public Integer getZanCount() {
        return zanCount;
    }
}
