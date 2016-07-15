package com.zyx.rpc.shop.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyx.entity.shop.Goods;
import com.zyx.rpc.shop.ShopService;
import com.zyx.service.shop.GoodsService;
@Service("shopService")
public class ShopServiceImpl implements ShopService {
	@Autowired
	private GoodsService goodsService;

	@Override
	public void addGoods(Goods goods) {
		goodsService.save(goods);
		
	}

	@Override
	public Goods getGoodsbyKey(Integer id) {
		return goodsService.selectByKey(id);
	}

}
