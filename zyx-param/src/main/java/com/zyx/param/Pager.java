package com.zyx.param;

import java.io.Serializable;

/**
 * Created by MrDeng on 2016/8/17.
 */
public class Pager implements Serializable{

    private Integer pageSize;
    private Integer pageNum;
    private Long count;

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public Long getCount() {
        return count;
    }
}
