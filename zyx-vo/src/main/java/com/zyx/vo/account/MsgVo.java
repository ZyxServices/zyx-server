package com.zyx.vo.account;

import java.io.Serializable;

/**
 * Created by wms on 2016/9/27.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/9/27
 */
public class MsgVo implements Serializable {

    private static final long serialVersionUID = -5278908906329475152L;
    private Integer id;

    private String fromContent;
    private String toContent;

    private Integer bodyId;
    private Integer bodyType;

    private Long createTime;

    private UserIconVo userVo;

    private MsgToVo toObject;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromContent() {
        return fromContent;
    }

    public void setFromContent(String fromContent) {
        this.fromContent = fromContent;
    }

    public String getToContent() {
        return toContent;
    }

    public void setToContent(String toContent) {
        this.toContent = toContent;
    }

    public Integer getBodyId() {
        return bodyId;
    }

    public void setBodyId(Integer bodyId) {
        this.bodyId = bodyId;
    }

    public Integer getBodyType() {
        return bodyType;
    }

    public void setBodyType(Integer bodyType) {
        this.bodyType = bodyType;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public UserIconVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserIconVo userVo) {
        this.userVo = userVo;
    }

    public MsgToVo getToObject() {
        return toObject;
    }

    public void setToObject(MsgToVo toObject) {
        this.toObject = toObject;
    }
}