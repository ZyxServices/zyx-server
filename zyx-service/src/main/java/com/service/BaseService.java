package com.service;

import java.util.List;

public interface BaseService<T> {
	public void save(T t);
	public void save(List<T>list);

}
