package com.zyx.param.live;

import com.zyx.param.Pager;

import java.io.Serializable;

/**
 * Created by MrDeng on 2016/8/17.
 */
public class LiveInfoParam implements Serializable{
    Integer lab;
    Pager pager;

    public void setLab(Integer lab) {
        this.lab = lab;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    public Integer getLab() {
        return lab;
    }

    public Pager getPager() {
        return pager;
    }
}
