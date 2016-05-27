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

package com.zyx.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyx.mapper.dao.CountryMapper;
import com.zyx.mapper.dao.UserInfoMapper;
import com.zyx.mapper.model.Country;
import com.zyx.mapper.model.UserInfo;

import tk.mybatis.mapper.entity.Example;

/**
 * 
 * @title PageMapperTest.java
 * @package com.zyx.mapper
 * @description TODO
 * @author ZhangHuaRong   
 * @update 2016年5月26日 下午2:57:45
 * @version V1.0  
 * Copyright (c)2012 chantsoft-版权所有
 */
public class PageMapperTest extends BasicTest {

//    @Autowired
//    private CountryMapper countryMapper;

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void test(){
        CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);
        Example example = new Example(Country.class);
        example.createCriteria().andGreaterThan("id",100);
        PageHelper.startPage(2,10);
        List<Country> countries = countryMapper.selectByExample(example);
        PageInfo<Country> pageInfo = new PageInfo<Country>(countries);
        System.out.println(pageInfo.getTotal());

        countries = countryMapper.selectByExample(example);
        pageInfo = new PageInfo<Country>(countries);
        System.out.println("==============================="+pageInfo.getTotal());
        UserInfoMapper usermapper = sqlSession.getMapper(UserInfoMapper.class);
    	List<UserInfo>  us =usermapper.selectAll();
    	System.out.println("----------------------us"+us.size());
    }
    @Test
    public void test1(){
    	UserInfoMapper usermapper = sqlSession.getMapper(UserInfoMapper.class);
    	List<UserInfo>  us =usermapper.selectAll();
    	System.out.println("----------------------us"+us.size());
    	 
    }
}
