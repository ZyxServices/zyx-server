package com.zyx.impl.shop;


import org.springframework.stereotype.Service;

import com.zyx.entity.shop.Goods;
import com.zyx.impl.BaseServiceImpl;
import com.zyx.service.shop.GoodsService;
@Service("goodsService")
public class GoodsServiceImpl extends BaseServiceImpl<Goods> implements GoodsService {

}
