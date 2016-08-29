package com.zyx.entity.system;

import com.zyx.entity.BaseEntity;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.entity.system
 * Create by XiaoWei on 2016/8/26
 */
@Table(name = "comment")
public class Comment  extends BaseEntity{
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer commentType;//评论类型：0圈子,1:帖子，2：活动，3：动态,4：直播
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer commentId;//被评论主题id
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String commentContent;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer commentAccount;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer commentState;//回复方式，0：公开评论

    public Integer getCommentType() {
        return commentType;
    }

    public void setCommentType(Integer commentType) {
        this.commentType = commentType;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getCommentAccount() {
        return commentAccount;
    }

    public void setCommentAccount(Integer commentAccount) {
        this.commentAccount = commentAccount;
    }

    public Integer getCommentState() {
        return commentState;
    }

    public void setCommentState(Integer commentState) {
        this.commentState = commentState;
    }
}
