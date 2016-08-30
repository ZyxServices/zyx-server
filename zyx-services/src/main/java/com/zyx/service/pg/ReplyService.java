package com.zyx.service.pg;

import com.zyx.entity.system.Reply;
import com.zyx.service.BaseService;

import java.util.Map;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.service.pg
 * Create by XiaoWei on 2016/6/27
 */
public interface ReplyService extends BaseService<Reply> {
    Map<String, Object> addReply(Integer reply_type, Integer reply_id, Integer account_id, String content);

}
