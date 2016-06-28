package com.zyx.service.pg.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.pg.PgConstants;
import com.zyx.entity.pg.Reply;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.pg.ReplyService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.service.pg.impl
 * Create by XiaoWei on 2016/6/27
 */
@Service
public class ReplyServiceImpl extends BaseServiceImpl<Reply> implements ReplyService {
    @Override
    public Map<String, Object> addReply(Integer reply_type, Integer reply_id, Integer account_id, String content) {
        Map<String, Object> resultMap = new HashMap<>();
        Reply reply = new Reply();
        try {
            if (reply_type == null) {
                resultMap.put(Constants.ERROR_CODE, PgConstants.PG_ERROR_CODE_30008);
                resultMap.put(Constants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30008_MSG);
                return resultMap;
            }
            if (reply_id == null) {
                resultMap.put(Constants.ERROR_CODE, PgConstants.PG_ERROR_CODE_30009);
                resultMap.put(Constants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30009_MSG);
                return resultMap;
            }
            if (account_id == null) {
                resultMap.put(Constants.ERROR_CODE, PgConstants.PG_ERROR_CODE_30009);
                resultMap.put(Constants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30009_MSG);
                return resultMap;
            }
            if (content == null) {
                resultMap.put(Constants.ERROR_CODE, PgConstants.PG_ERROR_CODE_30010);
                resultMap.put(Constants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30010_MSG);
                return resultMap;
            }
            reply.setReply_type(reply_type);
            reply.setReply_id(reply_id);
            reply.setReply_account_id(account_id);
            reply.setContent(content);
            reply.setCreateTime(new Date().getTime());
            reply.setReply_state(0);
            save(reply);
            resultMap.put(Constants.STATE, Constants.SUCCESS);
            return resultMap;
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put(Constants.STATE, Constants.ERROR_500);
            return resultMap;
        }
    }
}
