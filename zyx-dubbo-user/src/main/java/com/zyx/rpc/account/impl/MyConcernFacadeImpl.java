package com.zyx.rpc.account.impl;

import com.zyx.constants.Constants;
import com.zyx.param.account.UserConcernParam;
import com.zyx.rpc.account.MyConcernFacade;
import com.zyx.rpc.common.TokenFacade;
import com.zyx.service.pg.ConcernService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.pg.MyFollowVo;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wms on 2016/8/12.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 */
@Service("myConcernFacade")
public class MyConcernFacadeImpl implements MyConcernFacade {

    @Autowired
    private ConcernService concernService;

    @Autowired
    private TokenFacade tokenFacade;

    @Override
    public Map<String, Object> myList(UserConcernParam userConcernParam) {
        try {
            // 判断token是否失效
            Map<String, Object> map = tokenFacade.validateTokenIncludeOther(userConcernParam.getToken(), userConcernParam.getUserId());
            if (map != null) {
                return map;
            }
            List<MyFollowVo> _list = concernService.queryMyConcernList(userConcernParam);
            return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.MSG_SUCCESS, _list);
        } catch (Exception e) {
            e.printStackTrace();
            return Constants.MAP_500;
        }
    }
}
