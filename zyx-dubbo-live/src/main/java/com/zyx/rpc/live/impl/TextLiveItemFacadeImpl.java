package com.zyx.rpc.live.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyx.entity.live.TextLiveItem;
import com.zyx.rpc.live.TextLiveItemFacade;
import com.zyx.service.live.TextLiveItemService;
import com.zyx.vo.live.TextLiveItemVo;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;
/**
 * 
 * @title TextLiveItemFacadeImpl.java
 * @package com.zyx.rpc.live.impl
 * @author MrDeng   
 * @update 2016年6月15日 上午11:31:37
 * @version V1.0  
 * Copyright (c)2012 chantsoft-版权所有
 */
@Service("textLiveItemFacade")
public class TextLiveItemFacadeImpl implements TextLiveItemFacade {

	@Autowired
	TextLiveItemService textLiveItemService;

	@Override
	public void add(TextLiveItem textLiveItem) {
		textLiveItemService.save(textLiveItem);
	}

	@Override
	public TextLiveItem getById(Long id) {
		return textLiveItemService.selectByKey(id);
	}

	@Override
	public List<TextLiveItem> getList(TextLiveItemVo textLiveItemVo) {
		Example example = new Example(TextLiveItem.class);
		Criteria criteria = example.createCriteria();
		if(textLiveItemVo.getLiveId()!=null){
			criteria.andEqualTo("liveId", textLiveItemVo.getLiveId());
		}
//		if(textLiveItemVo.getStartTime()!=null&&textLiveItemVo.getEndTime()!=null){
//			criteria.andBetween("createTime", textLiveItemVo.getStartTime(), textLiveItemVo.getEndTime());
//		}else if(textLiveItemVo.getStartTime()!=null&&textLiveItemVo.getEndTime()==null){
//			criteria.andGreaterThanOrEqualTo("createTime", textLiveItemVo.getStartTime());
//		}else if(textLiveItemVo.getStartTime()!=null&&textLiveItemVo.getEndTime()!=null){
//			criteria.andLessThanOrEqualTo("createTime", textLiveItemVo.getEndTime());
//		}
		return textLiveItemService.selectByExample(example);
	}

	@Override
	public void deleteById(Long id) {
		textLiveItemService.delete(id);
		
	}
//
//	@Override
//	public void batchDelete(List<Long> id) {
////		textLiveItemService.
//	}


}
