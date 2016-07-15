package com.zyx.rpc.live.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.zyx.constants.live.LiveConstants;
import com.zyx.entity.Devaluation;
import com.zyx.entity.live.LiveInfo;
import com.zyx.rpc.live.LiveInfoFacade;
import com.zyx.service.admin.DevaluationService;
import com.zyx.service.live.LiveInfoService;
import com.zyx.vo.live.LiveInfoVo;
import com.zyx.vo.live.LiveSearchVo;

@Service("liveInfoFacade")
public class LiveInfoFacadeImpl implements LiveInfoFacade {

	@Autowired
	LiveInfoService liveInfoService;
	@Autowired
	private RedisTemplate<String, ArrayList<LiveInfo>> redisTemplate;
	@Autowired
	DevaluationService devaluationService;

	@Override
	public void add(LiveInfo liveInfo) {
		// 修正开始时间
		long now = System.currentTimeMillis();
		liveInfo.setStart(liveInfo.getStart() == null || liveInfo.getStart() < now ? now : liveInfo.getStart());
		liveInfoService.save(liveInfo);
	}

	@Override
	public void updateNotNull(LiveInfo liveInfo) {
		liveInfoService.updateNotNull(liveInfo);
	}

	@Override
	public LiveInfo getById(Integer id) {
		return liveInfoService.selectByKey(id);
	}

	@Override
	public List<LiveInfo> getList(LiveInfoVo liveInfoVo) {
		if (liveInfoVo.getPageNo() != null && (liveInfoVo.getPageSize() == null || liveInfoVo.getPageSize() < 1)) {
			liveInfoVo.setPageSize(6);
		}
		int count = liveInfoService.countLive(liveInfoVo);
		if (count == 0)
			return null;
		else {
			liveInfoVo.setCount(count);
			return liveInfoService.selectLives(liveInfoVo);
		}
	}

	@Override
	public void delete(Integer id) {
		liveInfoService.delete(id);
	}

	@Override
	public List<LiveInfo> searchList(LiveSearchVo liveSearchVo) {
		return null;
	}

	@Override
	public String getLiveUrl(Integer liveId) {
		LiveInfo liveInfo = liveInfoService.selectByKey(liveId);
		return liveInfo == null ? null : liveInfo.getVedioUrl();
	}

	@Override
	public List<LiveInfo> getDevaLives() {
		@SuppressWarnings("unchecked")
		List<LiveInfo> list = (List<LiveInfo>) redisTemplate.opsForHash().get(LiveConstants.MARK_LIVE_DEVA,
				LiveConstants.MARK_HASH_LIVE_DEVA);
		if (list != null) {
			return list;
		}
		List<Integer> devaIds = devaluationService.queryDevaIds(LiveConstants.MARK_LIVE_DEVA_MODEL);
		list = liveInfoService.selectLiveDevas(devaIds);
		redisTemplate.opsForHash().put(LiveConstants.MARK_LIVE_DEVA, LiveConstants.MARK_HASH_LIVE_DEVA, list);
		return list;
	}

	@Override
	public void refreshDevaLives() {
		List<Integer> devaIds = devaluationService.queryDevaIds(LiveConstants.MARK_LIVE_DEVA_MODEL);
		List<LiveInfo> list = liveInfoService.selectLiveDevas(devaIds);
		redisTemplate.opsForHash().put(LiveConstants.MARK_LIVE_DEVA, LiveConstants.MARK_HASH_LIVE_DEVA, list);
	}

	@Override
	public void addDevaLive(Integer lvieId) {
		Devaluation entity = new Devaluation();
		entity.setTypes(LiveConstants.MARK_LIVE_DEVA_MODEL);
		entity.setDevaluationId(lvieId);
		entity.setCreateTime(System.currentTimeMillis());
		devaluationService.save(entity);
	}

	@Override
	public int countDevaLive() {
		Devaluation record =  new Devaluation();
		record.setTypes(LiveConstants.MARK_LIVE_DEVA_MODEL);
		return devaluationService.selectCount(record );
	}

	@Override
	public Map<Integer, Integer> getLiveWatchNum(List<Integer> liveIds) {
		Random rand =new Random(System.currentTimeMillis());
		Map<Integer,Integer> numMap  =new HashMap<Integer, Integer>();
		// TODO 获取到直播的当前观看人数
		for(Integer liveId :liveIds){
			numMap.put(liveId, rand.nextInt(1000));
		}
		return numMap;
	}

	@Override
	public Map<Integer, Integer> getLiveDevaWatchNum() {
		List<Integer> devaIds = devaluationService.queryDevaIds(LiveConstants.MARK_LIVE_DEVA_MODEL);
		return getLiveWatchNum(devaIds);
	}
}
