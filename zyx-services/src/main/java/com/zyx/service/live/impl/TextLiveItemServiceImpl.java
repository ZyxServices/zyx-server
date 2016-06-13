package com.zyx.service.live.impl;

import com.zyx.service.live.TextLiveItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyx.dao.live.TextLiveItemDao;
import com.zyx.entity.live.TextLiveItem;
import com.zyx.service.impl.BaseServiceImpl;

@Service("textLiveItemService")
public class TextLiveItemServiceImpl extends BaseServiceImpl<TextLiveItem> implements TextLiveItemService {
}
