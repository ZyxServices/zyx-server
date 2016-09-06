package com.zyx.vo.pg;

import com.zyx.entity.system.Comment;

import java.util.List;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.vo.pg
 * Create by XiaoWei on 2016/9/6
 */
public class CommentVo extends Comment {
    List<ReplyVo> replyVos;

    public List<ReplyVo> getReplyVos() {
        return replyVos;
    }

    public void setReplyVos(List<ReplyVo> replyVos) {
        this.replyVos = replyVos;
    }
}
