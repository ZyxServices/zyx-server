package com.zyx.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 
 * @title MyMapper.java
 * @package com.zyx.mapper
 * @description 继承自己的MyMapper
 * @author ZhangHuaRong   
 * @update 2016年5月26日 下午3:01:59
 * @version V1.0  
 * Copyright (c)2012 chantsoft-版权所有
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
