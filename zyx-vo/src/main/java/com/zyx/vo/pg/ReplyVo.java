package com.zyx.vo.pg;

import com.zyx.entity.system.Reply;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.vo.pg
 * Create by XiaoWei on 2016/9/6
 */
public class ReplyVo extends Reply {
    private UserVo fromUserVo;
    private UserVo toUserVo;

    public UserVo getFromUserVo() {
        return fromUserVo;
    }

    public void setFromUserVo(UserVo fromUserVo) {
        this.fromUserVo = fromUserVo;
    }

    public UserVo getToUserVo() {
        return toUserVo;
    }

    public void setToUserVo(UserVo toUserVo) {
        this.toUserVo = toUserVo;
    }
}
