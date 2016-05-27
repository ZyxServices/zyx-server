package com.zyx.dao.live.impl;

import org.springframework.stereotype.Repository;

import com.zyx.dao.BaseDaoImpl;
import com.zyx.dao.live.TextLiveItemDao;
import com.zyx.entity.live.TextLiveItem;

@Repository("textLiveItemDao")
public class TextLiveItemDaoImpl extends BaseDaoImpl<TextLiveItem>  implements TextLiveItemDao{

}
