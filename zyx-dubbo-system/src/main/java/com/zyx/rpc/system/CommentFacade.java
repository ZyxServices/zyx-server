package com.zyx.rpc.system;

import java.util.Map;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.rpc.system
 * Create by XiaoWei on 2016/8/29
 */
public interface CommentFacade {
    Map<String, Object> addComment(Integer commentType, Integer commentId, String commentContent, Integer commentAccount, Integer commentState);
}
