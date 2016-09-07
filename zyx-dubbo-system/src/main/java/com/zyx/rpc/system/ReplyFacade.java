package com.zyx.rpc.system;

import java.util.Map;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.rpc.system
 * Create by XiaoWei on 2016/8/31
 */
public interface ReplyFacade {
    Map<String, Object> addReply(Integer replyParentId, Integer replyFromUser, Integer replyToUser, String replyContent);

}
