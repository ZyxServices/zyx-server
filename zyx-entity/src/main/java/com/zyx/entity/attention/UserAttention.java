package com.zyx.entity.attention;

import com.zyx.entity.BaseEntity;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Created by wms on 2016/8/16.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title UserAttention.java
 */
@Table(name = "USER_ATTENTION")
public class UserAttention extends BaseEntity {
    private static final long serialVersionUID = -4661869687692595600L;

    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer fromUserId;

    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer toUserId;

    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer relType;

    /**
     * 用户 A 的 id
     *
     * @return fromUserId
     */
    public Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    /**
     * 用户 B 的 id
     *
     * @return toUserId
     */
    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    /**
     * 关系类型（0拉黑，1粉丝/关注）
     *
     * @return relType
     */
    public Integer getRelType() {
        return relType;
    }

    public void setRelType(Integer relType) {
        this.relType = relType;
    }
}
