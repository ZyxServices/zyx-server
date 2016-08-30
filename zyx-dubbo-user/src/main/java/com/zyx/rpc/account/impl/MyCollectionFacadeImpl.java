package com.zyx.rpc.account.impl;

import com.zyx.constants.Constants;
import com.zyx.rpc.account.MyCollectionFacade;
import com.zyx.rpc.common.TokenFacade;
import com.zyx.service.collection.CollectionService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.collection.CollectionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wms on 2016/8/23.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title MyCollectionFacadeImpl.java
 */
@Service("myCollectionFacade")
public class MyCollectionFacadeImpl implements MyCollectionFacade {

    @Autowired
    private CollectionService collectionService;

    @Autowired
    private TokenFacade tokenFacade;

    @Override
    public Map<String, Object> myList(String token, Integer accountId) {
        try {
            // 判断token是否失效
            Map<String, Object> map = tokenFacade.validateToken(token, accountId);
            if (map != null) {
                return map;
            }
            List<CollectionVo> _list = collectionService.myCollectionList(accountId);
            return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.SUCCESS_MSG, _list);
        } catch (Exception e) {
            e.printStackTrace();
            return Constants.MAP_500;
        }
    }

}
