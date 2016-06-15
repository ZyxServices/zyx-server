package com.zyx.rpc.live.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyx.entity.live.LiveInfo;
import com.zyx.rpc.live.LiveInfoFacade;
import com.zyx.service.live.LiveInfoService;
import com.zyx.vo.live.LiveInfoVo;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service("liveInfoFacade")
public class LiveInfoFacadeImpl implements LiveInfoFacade {

	@Autowired
	LiveInfoService liveInfoService;

	@Override
	public void add(LiveInfo liveInfo) {

		liveInfoService.save(liveInfo);
	}

	@Override
	public void updateNotNull(LiveInfo liveInfo) {
		liveInfoService.updateNotNull(liveInfo);
	}

	@Override
	public LiveInfo getById(Long id) {
		return liveInfoService.selectByKey(id);
	}

	@Override
	public List<LiveInfo> getList( LiveInfoVo liveInfoVo) {
		Example example = new Example(LiveInfo.class);
		Criteria criteria = example.createCriteria();
		
		if(liveInfoVo.getIds()!=null&&!liveInfoVo.getIds().isEmpty()){
			criteria.andIn("id", liveInfoVo.getIds());
		}else{
			if(null!=liveInfoVo.getType()){
				criteria.andEqualTo("type", liveInfoVo.getType());
			}
			if(null!= liveInfoVo.getUserId()){
				criteria.andEqualTo("userId", liveInfoVo.getUserId());
			}
			if(liveInfoVo.getLabs()!=null&&!liveInfoVo.getLabs().isEmpty()){
				criteria.andIn("lab", liveInfoVo.getLabs());
			}
			if(liveInfoVo.getCreateTime()!=null){
				criteria.andBetween("createTime", liveInfoVo.getCreateTime().getStart(),liveInfoVo.getCreateTime().getStart() );
			}
			if(liveInfoVo.getStart()!=null){
				criteria.andBetween("start", liveInfoVo.getStart().getStart(),liveInfoVo.getStart().getStart() );
			}
			if(liveInfoVo.getEnd()!=null){
				criteria.andBetween("createTime", liveInfoVo.getEnd().getStart(),liveInfoVo.getEnd().getStart() );
			}
		}
		
		List<LiveInfo> list = liveInfoService.selectByExample(example);
		return list;
	}

	@Override
	public void delete(Long id) {
		liveInfoService.delete(id);
	}

}
