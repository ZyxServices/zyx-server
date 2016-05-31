package com.zyx.rpc.shop.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyx.entity.shop.Goods;
import com.zyx.mapper.service.GoodsService;
import com.zyx.rpc.shop.ShopService;
@Service("shopService")
public class ShopServiceImpl implements ShopService {
	@Autowired
	private GoodsService goodsService;

	@Override
	public void addGoods(Goods goods) {
		goodsService.save(goods);
		
	}

	@Override
	public Goods getGoodsbyKey(Long id) {
		return goodsService.selectByKey(id);
	}

}
