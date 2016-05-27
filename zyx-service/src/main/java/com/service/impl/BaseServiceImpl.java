package com.service.impl;

import java.util.List;

import com.dao.BaseDao;
import com.entity.BaseEntity;
import com.service.BaseService;

public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T>{
	private BaseDao<T> baseDao;
	public BaseServiceImpl(BaseDao<T>baseDao){
		this.baseDao = baseDao;
	}
	@Override
	public void save(T t) {
		baseDao.insert(t);
	}
	@Override
	public void save(List<T> list) {
		baseDao.insert(list);
	}

}
