package com.zyx.rpc.live.impl;

import com.zyx.core.exception.RedisNullException;
import com.zyx.core.thread.WorkorHelper;
import com.zyx.core.thread.workors.BatchSaveBarrageWorkor;
import com.zyx.entity.live.Barrage;
import com.zyx.rpc.live.BarrageFacade;
import com.zyx.service.live.BarrageService;
import com.zyx.vo.live.BarrageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("barrageFacade")
public class BarrageFacadeImpl implements BarrageFacade{

	@Autowired
	BarrageService barrageService;
	@Autowired
	private RedisTemplate<String, Barrage> barrageRedis;
	@Autowired
	private RedisTemplate<String, Long> sizeRedis;
	@Autowired
	private WorkorHelper workorHelper;
	@Override
	public synchronized void add( Barrage barrage) {

//		Long size = barrageRedis.opsForList().size(LiveConstants.MARK_REDIS_BARRAGE_QUEUE);
//		if(size>=LiveConstants.DEFAULT_BARRAGE_QUEUE_SIZE){
//			barrageRedis.opsForList().rightPop(LiveConstants.MARK_REDIS_BARRAGE_QUEUE);
//		}
//		barrageRedis.opsForList().leftPush(LiveConstants.MARK_REDIS_BARRAGE_QUEUE,barrage);
		/**
		 * 缓存+线程池处理
		 */
		try {
			workorHelper.submitWorkor(new BatchSaveBarrageWorkor());
		} catch (RedisNullException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Barrage> getLast(BarrageVo barrageVo) {
		barrageVo.setStart(0);
		barrageVo.setEnd(10);
		return barrageService.getTop(barrageVo);
	}
	
}
