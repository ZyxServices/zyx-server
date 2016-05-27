package com.dao.live.impl;

import org.springframework.stereotype.Repository;

import com.dao.BaseDaoImpl;
import com.dao.live.LiveInfoDao;
import com.entity.live.LiveInfo;

@Repository("liveInfo")
public class LiveInfoDaoImpl extends BaseDaoImpl<LiveInfo> implements LiveInfoDao{

}
