package com.zyx.rpc.system.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.account.AccountConstants;
import com.zyx.entity.account.UserMsgInfo;
import com.zyx.param.account.UserMsgParam;
import com.zyx.rpc.system.MsgFacade;
import com.zyx.service.account.AccountRedisService;
import com.zyx.service.account.UserMsgService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.account.AccountInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by wms on 2016/9/27.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/9/27
 */
@Service("msgFacade")
public class MsgFacadeImpl implements MsgFacade {

    @Autowired
    protected RedisTemplate<String, String> stringRedisTemplate;

    @Autowired
    private AccountRedisService accountRedisService;

    @Resource
    private UserMsgService userMsgService;

    @Override
    public Map<String, Object> insertMsg(UserMsgParam userMsgParam) {
        try {
            // 判断token是否失效
            Map<String, Object> map = validateToken(userMsgParam.getToken(), userMsgParam.getToUserId());
            if (map != null) {
                return map;
            }
            int result = userMsgService.save(buildUserMsgInfo(userMsgParam));
            if (result == 1) {
                return MapUtils.buildSuccessMap(result);
            } else {
                return MapUtils.buildErrorMap(Constants.ERROR, Constants.ERROR_MSG);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Constants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> queryMsgCount(UserMsgParam userMsgParam) {
        try {
            // 判断token是否失效
            Map<String, Object> map = validateToken(userMsgParam.getToken(), userMsgParam.getToUserId());
            if (map != null) {
                return map;
            }
            return MapUtils.buildSuccessMap(userMsgService.queryMsgCount(userMsgParam));
        } catch (Exception e) {
            e.printStackTrace();
            return Constants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> queryMsgList(UserMsgParam userMsgParam) {
        try {
            // 判断token是否失效
            Map<String, Object> map = validateToken(userMsgParam.getToken(), userMsgParam.getToUserId());
            if (map != null) {
                return map;
            }
            return MapUtils.buildSuccessMap(userMsgService.queryMsgList(userMsgParam));
        } catch (Exception e) {
            e.printStackTrace();
            return Constants.MAP_500;
        }
    }

    private UserMsgInfo buildUserMsgInfo(UserMsgParam userMsgParam) {
        UserMsgInfo userMsgInfo = new UserMsgInfo();
        userMsgInfo.setFromUserId(userMsgParam.getFromUserId());
        userMsgInfo.setToUserId(userMsgParam.getToUserId());
        userMsgInfo.setBodyId(userMsgParam.getBodyId());
        userMsgInfo.setBodyType(userMsgParam.getBodyType());
        userMsgInfo.setFromContent(userMsgParam.getFromContent());
        userMsgInfo.setToContent(userMsgParam.getToContent());
        userMsgInfo.setCreateTime(System.currentTimeMillis());
        return userMsgInfo;
    }

    private Map<String, Object> validateToken(String token, Integer userId) {

        if (StringUtils.isEmpty(token)) {
            return Constants.MAP_PARAM_MISS;
        }

        if (StringUtils.isEmpty(userId)) {
            return Constants.MAP_PARAM_MISS;
        }

        String phone = stringRedisTemplate.opsForValue().get(AccountConstants.REDIS_KEY_TYJ_TOKEN + token);
        if (StringUtils.isEmpty(phone)) {
            return Constants.MAP_TOKEN_FAILURE;
        }

        AccountInfoVo vo = accountRedisService.get(phone);

        if (vo == null || !vo.getId().equals(userId)) {
            return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50301, AccountConstants.ACCOUNT_ERROR_CODE_50301_MSG);
        }

        return null;
    }
}
