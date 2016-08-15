package com.zyx.entity.pg.dto;

import com.zyx.entity.pg.Concern;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.entity.pg.dto
 * Create by XiaoWei on 2016/8/15
 */
public class MyFollow extends Concern {
    private String nickName;
    private String avatar;
    private Integer accountId;
    private Integer zanCounts;
    private Integer commentCounts;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getZanCounts() {
        return zanCounts;
    }

    public void setZanCounts(Integer zanCounts) {
        this.zanCounts = zanCounts;
    }

    public Integer getCommentCounts() {
        return commentCounts;
    }

    public void setCommentCounts(Integer commentCounts) {
        this.commentCounts = commentCounts;
    }
}
