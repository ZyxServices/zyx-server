package com.dao.live.impl;

import org.springframework.stereotype.Repository;

import com.dao.BaseDaoImpl;
import com.dao.live.TextLiveItemDao;
import com.entity.live.TextLiveItem;

@Repository("textLiveItemDao")
public class TextLiveItemDaoImpl extends BaseDaoImpl<TextLiveItem>  implements TextLiveItemDao{

}
