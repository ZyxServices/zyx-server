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
	public TextLiveItem getById(Integer id) {
		return textLiveItemService.selectByKey(id);
	}

	@Override
	public List<TextLiveItem> getList(TextLiveItemVo textLiveItemVo) {
		Example example = new Example(TextLiveItem.class);
		Criteria criteria = example.createCriteria();
		if(textLiveItemVo.getLiveId()!=null){
			criteria.andEqualTo("liveId", textLiveItemVo.getLiveId());
		}
		if(textLiveItemVo.getCreateTimeLower()!=null&&textLiveItemVo.getCreateTimeUpper()!=null){
			criteria.andBetween("createTime", textLiveItemVo.getCreateTimeLower(),textLiveItemVo.getCreateTimeUpper() );
		}else if(textLiveItemVo.getCreateTimeLower()!=null){
			criteria.andBetween("createTime", textLiveItemVo.getCreateTimeLower(),System.currentTimeMillis() );
		}else if(textLiveItemVo.getCreateTimeUpper()!=null){
			criteria.andBetween("createTime", 0,textLiveItemVo.getCreateTimeUpper() );
		}
		return textLiveItemService.selectByExample(example);
	}

	@Override
	public void deleteById(Integer id) {
		textLiveItemService.delete(id);
		
	}
}
