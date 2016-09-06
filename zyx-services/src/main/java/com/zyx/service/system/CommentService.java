package com.zyx.service.system;

import com.zyx.entity.system.Comment;
import com.zyx.service.BaseService;

import java.util.Map;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.service.system
 * Create by XiaoWei on 2016/8/26
 */
public interface CommentService extends BaseService<Comment> {
    Map<String, Object> addComment(Integer commentType, Integer commentId, String commentContent, Integer commentAccount,Integer commentState);

    Map<String,Object> queryComment(Integer commentType,Integer commentId);
}
