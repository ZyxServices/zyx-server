/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.zyx.service;

import java.util.List;

import com.zyx.entity.BaseEntity;
import com.zyx.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.zyx.service.BaseService;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

/**
 * @author ZhangHuaRong
 * @version V1.0
 *          Copyright (c)2012 chantsoft-版权所有
 * @title BaseService.java
 * @package com.zyx.mapper.service.impl
 * @description TODO
 * @update 2016年5月26日 下午3:02:33
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    protected Class<?> propertyClazz;

    public BaseServiceImpl(Class<?> propertyClazz) {
        this.propertyClazz = propertyClazz;
    }

    ;
    @Autowired
    protected BaseMapper<T> mapper;

    public Mapper<T> getMapper() {
        return mapper;
    }

    @Override
    public T selectByKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    @Override
    public List<T> selectByIds(Object key, String... properties) {
        Example example = new Example(propertyClazz);
        Example.Criteria criteria = example.createCriteria();
        example.selectProperties(properties);
        criteria.equals(key);
        return mapper.selectByExample(example);
    }

    @Override
    public List<T> selectByIds(List<Integer> keys) {
        Example example = new Example(propertyClazz);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", keys);
        return mapper.selectByExample(example);
    }

    @Override
    public List<T> selectByIds(List<Integer> keys, String... properties) {
        Example example = new Example(propertyClazz);
        example.selectProperties(properties);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", keys);
        return mapper.selectByExample(example);
    }

    public int save(T entity) {

        return mapper.insert(entity);
    }

    @Override
    public int batchSave(List<T> entities) {
        if (entities == null)
            return 0;
        mapper.insertList(entities);
        return entities.size();
    }

    public int delete(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }

    public int updateAll(T entity) {
        return mapper.updateByPrimaryKey(entity);
    }

    public int updateNotNull(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }

    @Override
    public List<T> select(T record) {
        return mapper.select(record);
    }

    @Override
    public int deleteRecords(T record) {
        return mapper.delete(record);
    }
    @Override
    public int selectCount(T record) {
        return mapper.selectCount(record);
    }

    //TODO 其他...
}
