package com.zyx.rpc.shop;

import com.zyx.entity.shop.Goods;

public interface ShopService {
	
	public void addGoods(Goods goods);
	
	public Goods getGoodsbyKey(Integer id);

}
