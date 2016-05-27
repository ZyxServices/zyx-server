package com.zyx.dao.live.impl;

import com.zyx.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import com.zyx.dao.live.LiveInfoDao;
import com.zyx.entity.live.LiveInfo;

@Repository("liveInfoDao")
public class LiveInfoDaoImpl extends BaseDaoImpl<LiveInfo> implements LiveInfoDao{

}
