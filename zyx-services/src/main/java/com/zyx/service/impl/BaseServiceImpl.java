package com.zyx.service.impl;

import java.util.List;

import com.zyx.dao.BaseDao;
import com.zyx.entity.BaseEntity;
import com.zyx.service.BaseService;

public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T>{
	
	private BaseDao<T> baseDao;
	public BaseServiceImpl(BaseDao<T>baseDao){
		this.baseDao = baseDao;
		System.out.println(baseDao);
	}
	@Override
	public void save(T t) {
		baseDao.insert(t);
	}
	@Override
	public void save(List<T> list) {
		baseDao.insert(list);
	}
	@Override
	public T get(int id) {
		return baseDao.getById(id);
	}
	

}
