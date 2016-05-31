

package com.zyx.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyx.entity.shop.Goods;
import com.zyx.mapper.dao.CountryMapper;
import com.zyx.mapper.dao.UserInfoMapper;
import com.zyx.mapper.model.Country;
import com.zyx.mapper.model.UserInfo;
import com.zyx.mapper.service.CountryService;
import com.zyx.mapper.service.GoodsService;

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
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private CountryService countryService;

   // @Test
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
  //  @Test
    public void test1(){
    	Country CC = countryService.selectByKey(1);
    	System.out.println(CC);
    	 
    }
    
 // @Test
    public void test2(){
    	Goods gg = new Goods();
    	gg.setCreateTime(new Date());
    //	gg.setVersion(1);
    	gg.setTitle("1111");
    	gg.setDesc("joihklhkjhkjhahahah1111");
    	gg.setType(1);
    	gg.setPrice(55f);
    	gg.setScope(55);
    	goodsService.save(gg);
    	
    }
   
 @Test
   public void test3(){
	   Goods gg= goodsService.selectByKey(10);
	   System.out.println(gg);
   	
   }
}
