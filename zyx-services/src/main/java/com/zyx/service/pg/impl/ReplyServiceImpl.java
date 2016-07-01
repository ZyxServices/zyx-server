package com.zyx.service.pg.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.zyx.utils.MapUtils;
import org.springframework.stereotype.Service;

import com.zyx.constants.pg.PgConstants;
import com.zyx.entity.pg.Reply;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.pg.ReplyService;

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
//                resultMap.put(PgConstants.STATE, PgConstants.PG_ERROR_CODE_30008);
//                resultMap.put(PgConstants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30008_MSG);
//                return resultMap;
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30008 ,PgConstants.PG_ERROR_CODE_30008_MSG);

            }
            if (reply_id == null) {
//                resultMap.put(PgConstants.STATE, PgConstants.PG_ERROR_CODE_30009);
//                resultMap.put(PgConstants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30009_MSG);
//                return resultMap;
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30009 ,PgConstants.PG_ERROR_CODE_30009_MSG);

            }
            if (account_id == null) {
//                resultMap.put(PgConstants.STATE, PgConstants.PG_ERROR_CODE_30009);
//                resultMap.put(PgConstants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30009_MSG);
//                return resultMap;
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30014 ,PgConstants.PG_ERROR_CODE_30014_MSG);

            }
            if (content == null) {
//                resultMap.put(PgConstants.STATE, PgConstants.PG_ERROR_CODE_30010);
//                resultMap.put(PgConstants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30010_MSG);
//                return resultMap;
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30010 ,PgConstants.PG_ERROR_CODE_30010_MSG);

            }
            reply.setReply_type(reply_type);
            reply.setReply_id(reply_id);
            reply.setReply_account_id(account_id);
            reply.setContent(content);
            reply.setCreateTime(new Date().getTime());
            reply.setReply_state(0);
            save(reply);
//            resultMap.put(PgConstants.STATE, PgConstants.SUCCESS);
//            resultMap.put(PgConstants.SUCCESS_MSG, PgConstants.MSG_SUCCESS);
//            return resultMap;
            return MapUtils.buildSuccessMap(PgConstants.SUCCESS ,PgConstants.PG_ERROR_CODE_33000_MSG,null);

        } catch (Exception e) {
            e.printStackTrace();
            return PgConstants.MAP_500;
        }
    }
}
