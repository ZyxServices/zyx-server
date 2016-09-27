package com.zyx.param;

import java.io.Serializable;

/**
 * Created by MrDeng on 2016/8/17.
 */
public class Pager implements Serializable {

    private static final long serialVersionUID = -7214542879825312475L;

    private Integer pageSize = 10;
    private Integer pageNum;
    private Long count;
    private Integer offset;

    public Pager(Integer pageNum, Integer pageSize) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        if (this.pageNum != null && this.pageSize != null) {
            offset = (pageNum - 1) * pageSize;
        }
    }

    public Integer getOffset() {
        if (this.pageNum != null && this.pageSize != null) {
            offset = (pageNum - 1) * pageSize;
        } else {
            offset = 0;
        }
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        if (this.pageNum != null && this.pageSize != null) {
            offset = (pageNum - 1) * pageSize;
        }
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
        if (this.pageNum != null && this.pageSize != null) {
            offset = (pageNum - 1) * pageSize;
        }
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

    public boolean verifyPager() {
        if (this.pageSize != null && this.pageNum != null) {
            if (getOffset() != null && getOffset() >= 0) {
                return true;
            }
        }
        return false;
    }
}
