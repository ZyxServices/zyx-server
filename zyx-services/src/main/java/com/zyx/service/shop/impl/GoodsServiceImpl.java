package com.zyx.service.shop.impl;


import org.springframework.stereotype.Service;

import com.zyx.entity.shop.Goods;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.shop.GoodsService;
@Service("goodsService")
public class GoodsServiceImpl extends BaseServiceImpl<Goods> implements GoodsService {

    public GoodsServiceImpl() {
        super(Goods.class);
    }
}
