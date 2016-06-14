package com.zyx.rpc.live.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyx.rpc.live.TextLiveItemFacade;
import com.zyx.service.live.TextLiveItemService;

@Service("textLiveItemFacade")
public class TextLiveItemFacadeImpl implements TextLiveItemFacade {

	@Autowired
	TextLiveItemService textLiveItemService;
	@Override
	public void create() {
	}


}
