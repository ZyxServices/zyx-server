package com.zyx.entity.system;

import com.zyx.entity.BaseEntity;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.entity.pg
 * Create by XiaoWei on 2016/6/27
 */
@Table(name = "reply")
public class Reply extends BaseEntity {
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer replyType;//回复主体类型，-1为回复id，0为圈子，1为帖子，2为活动，3为动态
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer replyId;//id对应回复类型
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer replyAccountId;//回复用户id
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String content;//回复内容
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer replyState;//回复类型,0为公开回复，其他类型预留


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getReplyType() {
        return replyType;
    }

    public void setReplyType(Integer replyType) {
        this.replyType = replyType;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Integer getReplyAccountId() {
        return replyAccountId;
    }

    public void setReplyAccountId(Integer replyAccountId) {
        this.replyAccountId = replyAccountId;
    }

    public Integer getReplyState() {
        return replyState;
    }

    public void setReplyState(Integer replyState) {
        this.replyState = replyState;
    }
}