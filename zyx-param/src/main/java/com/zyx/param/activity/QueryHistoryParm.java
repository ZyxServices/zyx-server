package com.zyx.param.activity;

import java.io.Serializable;

/**
 * Created by SubDong on 16-6-17.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title QueryAcitvityHistory
 * @package com.zyx.entity.activity.parm
 * @update 16-6-17 上午10:38
 */
public class QueryHistoryParm implements Serializable{

    private Integer userId;

    private Integer pageNumber;

    private Integer pageHis;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageHis() {
        return pageHis;
    }

    public void setPageHis(Integer pageHis) {
        this.pageHis = pageHis;
    }
}
