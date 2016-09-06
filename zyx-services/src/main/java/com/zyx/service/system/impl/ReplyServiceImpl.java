package com.zyx.service.system.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.zyx.service.system.ReplyService;
import com.zyx.utils.MapUtils;
import org.springframework.stereotype.Service;

import com.zyx.constants.pg.PgConstants;
import com.zyx.entity.system.Reply;
import com.zyx.service.BaseServiceImpl;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.service.pg.impl
 * Create by XiaoWei on 2016/6/27
 */
@Service("replyService")
public class ReplyServiceImpl extends BaseServiceImpl<Reply> implements ReplyService {
    public ReplyServiceImpl() {
        super(Reply.class);
    }

    @Override
    public Map<String, Object> addReply(Integer replyType, Integer replyParentId, Integer replyFromUser, Integer replyToUser, String replyContent, Integer replyState) {
        Map<String, Object> resultMap = new HashMap<>();
        Reply reply = new Reply();
        try {
            if (replyType == null) {
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30008, PgConstants.PG_ERROR_CODE_30008_MSG);
            }
            if (replyParentId == null) {
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30037, PgConstants.PG_ERROR_CODE_30037_MSG);
            }
            if (replyFromUser == null) {
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30038, PgConstants.PG_ERROR_CODE_30038_MSG);
            }
            if (replyToUser == null) {
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30039, PgConstants.PG_ERROR_CODE_30039_MSG);
            }
            if (replyContent == null) {
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30010, PgConstants.PG_ERROR_CODE_30010_MSG);
            }
            reply.setReplyType(replyType);
            reply.setReplyParentId(replyParentId);
            reply.setReplyFromUser(replyFromUser);
            reply.setReplyToUser(replyToUser);
            reply.setReplyContent(replyContent);
            reply.setCreateTime(new Date().getTime());
            reply.setReplyState(replyState);
            mapper.insert(reply);
//            resultMap.put(PgConstants.STATE, PgConstants.SUCCESS);
//            resultMap.put(PgConstants.SUCCESS_MSG, PgConstants.MSG_SUCCESS);
//            return resultMap;
            return MapUtils.buildSuccessMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_33000_MSG, null);

        } catch (Exception e) {
            e.printStackTrace();
            return PgConstants.MAP_500;
        }
    }
}
