package com.zyx.rpc.system.impl;

import com.zyx.rpc.system.ReplyFacade;
import com.zyx.service.system.ReplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.rpc.system.impl
 * Create by XiaoWei on 2016/8/31
 */
@Service("replyFacade")
public class ReplyFacadeImpl implements ReplyFacade {

    @Resource
    ReplyService replyService;

    @Override
    public Map<String, Object> addReply(Integer replyType, Integer replyParentId, Integer replyFromUser, Integer replyToUser, String replyContent, Integer replyState) {
        return replyService.addReply(replyType, replyParentId, replyFromUser, replyToUser, replyContent, replyState);
    }
}
