package com.zyx.param.live;

import com.zyx.param.Pager;

import java.io.Serializable;

/**
 * Created by MrDeng on 2016/8/17.
 */
public class LiveInfoParam implements Serializable{
    Integer id;
    Integer lab;
    /**
     * 查看该直播的用户ID
     */
    Integer viewUserId;
    Pager pager;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getViewUserId() {
        return viewUserId;
    }

    public void setViewUserId(Integer viewUserId) {
        this.viewUserId = viewUserId;
    }
}
