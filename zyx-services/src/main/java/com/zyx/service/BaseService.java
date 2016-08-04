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

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 通用接口
 */
@Service
public interface BaseService<T> {

    /**
     * 通过主键查询
     * @param key
     * @return
     */
    T selectByKey(Object key);

    List<T> selectByIds(List<Integer> keys);

    /**
     * 插入单个实体
     * @param entity
     * @return
     */
    int save(T entity);

    /**
     * 批量插入实体
     * @param entities
     * @return
     */
    int batchSave(List<T> entities);

    /**
     * 通过主键删除
     * @param key
     * @return
     */
    int delete(Object key);

    /**
     * 更新实体
     * @param entity
     * @return
     */
    int updateAll(T entity);

    /**
     * 更新实体非空字段
     * 主键ID作为查询条件
     * @param entity
     * @return
     */
    int updateNotNull(T entity);

    /**
     * 组合条件查询
     * @param example
     * @return
     */
    List<T> selectByExample(Object example);

    /**
     * 实体查询
     * @param record
     * @return
     */
    List<T> select(T record);

    /**
     * 实体条数查询
     */
    int selectCount(T record);
    //TODO 其他...
}
