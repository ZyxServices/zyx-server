package com.zyx.entity.pg;

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
    private Integer reply_type;//回复主体类型，0为圈子，1为帖子，2为活动，3为动态
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer reply_id;//id对应回复类型
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer reply_account_id;//回复用户id
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String content;//回复内容
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer reply_state;//回复类型,0为公开回复，其他类型预留

    public Integer getReply_type() {
        return reply_type;
    }

    public void setReply_type(Integer reply_type) {
        this.reply_type = reply_type;
    }

    public Integer getReply_id() {
        return reply_id;
    }

    public void setReply_id(Integer reply_id) {
        this.reply_id = reply_id;
    }

    public Integer getReply_account_id() {
        return reply_account_id;
    }

    public void setReply_account_id(Integer reply_account_id) {
        this.reply_account_id = reply_account_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getReply_state() {
        return reply_state;
    }

    public void setReply_state(Integer reply_state) {
        this.reply_state = reply_state;
    }
}