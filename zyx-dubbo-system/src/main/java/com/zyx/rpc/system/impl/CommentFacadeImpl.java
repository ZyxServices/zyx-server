package com.zyx.rpc.system.impl;

import com.zyx.rpc.system.CommentFacade;
import com.zyx.service.system.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.rpc.system.impl
 * Create by XiaoWei on 2016/8/29
 */
@Service("commentFacade")
public class CommentFacadeImpl implements CommentFacade {
    @Resource
    private CommentService commentService;
    @Override
    public Map<String, Object> addComment(Integer commentType, Integer commentId, String commentContent, Integer commentAccount, Integer commentState) {
        return commentService.addComment(commentType,commentId,commentContent,commentAccount,commentState);
    }
}
