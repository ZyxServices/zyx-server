package com.zyx.service.live.impl;

import java.util.List;

import com.zyx.constants.live.LiveConstants;
import com.zyx.entity.live.dto.LiveInfoDto;
import com.zyx.param.live.LiveInfoParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.zyx.entity.live.LiveInfo;
import com.zyx.mapper.live.LiveInfoMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.live.LiveInfoService;
import com.zyx.vo.live.LiveInfoVo;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service("liveInfoService")
public class LiveInfoServiceImpl extends BaseServiceImpl<LiveInfo> implements LiveInfoService {

    @Autowired
    LiveInfoMapper liveInfoMapper;

    @Autowired
    private RedisTemplate<String, Integer> watchNumberRedis;

    public LiveInfoServiceImpl() {
        super(LiveInfo.class);
    }

    @Override
    public void saveLiveInfo(LiveInfo liveInfo) {
        liveInfoMapper.saveLiveInfo(liveInfo);
    }

    @Override
    public Long countLive(LiveInfoParam param) {
        return liveInfoMapper.countLives(param);
    }

    @Override
    public List<LiveInfoVo> selectLives(LiveInfoParam param) {
        if (param.getPager() != null && param.getPager().getPageSize() != null && param.getPager().getOffset() != null) {
            param.getPager().setCount(liveInfoMapper.countLives(param));
        }
        return liveInfoMapper.selectLives(param);
    }

    @Override
    public void logicDelete(Integer id) {
        LiveInfo liveInfo = new LiveInfo();
        liveInfo.setId(id);
        liveInfo.setDel(-1);
        updateNotNull(liveInfo);
    }


    ////////////////观看人数处理/////////////////////////////////

    /**
     * 获取直播人数
     *
     * @param liveId
     * @return
     */
    public Integer getLiveWatcherNumber(Integer liveId) {
        Integer integer = watchNumberRedis.opsForValue().get(LiveConstants.MARK_LIVE_WATCH_NUMBER + liveId);
        return integer == null ? 0 : integer;
    }

    public void inLiveWatcherNumber(Integer liveId) {
        Integer num = watchNumberRedis.opsForValue().get(LiveConstants.MARK_LIVE_WATCH_NUMBER + liveId);
        watchNumberRedis.opsForValue().set(LiveConstants.MARK_LIVE_WATCH_NUMBER + liveId, num == null ? 0 : (num + 1));
    }

    public void outLiveWatcherNumber(Integer liveId) {
        Integer num = watchNumberRedis.opsForValue().get(LiveConstants.MARK_LIVE_WATCH_NUMBER + liveId);
        watchNumberRedis.opsForValue().set(LiveConstants.MARK_LIVE_WATCH_NUMBER + liveId, (num == null || num < 1) ? 0 : num - 1);
    }

    public void endLiveWatcherNumber(Integer liveId) {
        Integer num = watchNumberRedis.opsForValue().get(LiveConstants.MARK_LIVE_WATCH_NUMBER + liveId);
        watchNumberRedis.delete(LiveConstants.MARK_LIVE_WATCH_NUMBER + liveId);
    }

}
