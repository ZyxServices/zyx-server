package com.zyx.vo.activity;

import java.io.Serializable;

/**
 * Created by Rainbow on 16-6-14.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title com.zyx.entity.activity.vo
 */
public class MemberTemplate implements Serializable{

    private Integer id;

    private Integer userId;

    private String template;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    @Override
    public String toString() {
        return "MemberTemplate{" +
                "id=" + id +
                ", userId=" + userId +
                ", template='" + template + '\'' +
                '}';
    }
}
