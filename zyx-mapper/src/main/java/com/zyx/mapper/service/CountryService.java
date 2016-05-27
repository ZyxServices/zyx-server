package com.zyx.mapper.service;


import java.util.List;

import com.zyx.mapper.model.Country;

/**
 * 
 * @title CountryService.java
 * @package com.zyx.mapper.service
 * @description TODO
 * @author ZhangHuaRong   
 * @update 2016年5月26日 下午3:02:24
 * @version V1.0  
 * Copyright (c)2012 chantsoft-版权所有
 */
public interface CountryService extends IService<Country> {

    /**
     * 根据条件分页查询
     *
     * @param country
     * @param page
     * @param rows
     * @return
     */
    List<Country> selectByCountry(Country country, int page, int rows);

}
