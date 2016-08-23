package com.zyx.param;

import java.io.Serializable;

/**
 * Created by MrDeng on 2016/8/17.
 */
public class Pager implements Serializable{

    private Integer pageSize;
    private Integer pageNum;
    private Long count;
    private Integer offset;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        if(this.pageNum!=null&&this.pageSize!=null){
            offset=(pageNum-1)*pageSize;
        }
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
