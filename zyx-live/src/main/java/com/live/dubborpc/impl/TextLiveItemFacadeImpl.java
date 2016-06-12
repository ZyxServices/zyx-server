package com.live.dubborpc.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.live.dubborpc.TextLiveItemFacade;
import com.zyx.entity.live.LiveInfo;
import com.zyx.service.live.TextLiveItemService;

@Service("textLiveItemFacade")
public class TextLiveItemFacadeImpl implements TextLiveItemFacade {

	@Autowired
	TextLiveItemService textLiveItemService;
	@Override
	public void create() {
	}


}
