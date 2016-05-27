package com.service.live.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.live.TextLiveItemDao;
import com.entity.live.TextLiveItem;
import com.service.impl.BaseServiceImpl;
import com.service.live.TextLiveItemService;

@Service("textLiveItemService")
public class TextLiveItemServiceImpl extends BaseServiceImpl<TextLiveItem> implements TextLiveItemService{
	TextLiveItemDao textLiveItemDao;
	@Autowired
	public TextLiveItemServiceImpl(TextLiveItemDao textLiveItemDao) {
		super(textLiveItemDao);
		this.textLiveItemDao = textLiveItemDao;
	}
}
