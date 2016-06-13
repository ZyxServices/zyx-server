package com.zyx.impl;


import org.springframework.stereotype.Service;

import com.zyx.entity.playground.Concern;
import com.zyx.impl.BaseServiceImpl;
import com.zyx.service.shop.ConcrenService;

/**
 * Created by XiaoWei on 2016/6/7.
 */
@Service("concrenService")
public class ConcrenServicImpl extends BaseServiceImpl<Concern> implements ConcrenService {

    @Override
    public void custom() {

    }
}
