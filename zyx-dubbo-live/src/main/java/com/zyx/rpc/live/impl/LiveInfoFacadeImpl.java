package com.zyx.rpc.live.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyx.entity.live.LiveInfo;
import com.zyx.rpc.live.LiveInfoFacade;
import com.zyx.service.live.LiveInfoService;
import com.zyx.vo.live.LiveInfoVo;
import com.zyx.vo.live.LiveSearchVo;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service("liveInfoFacade")
public class LiveInfoFacadeImpl implements LiveInfoFacade {

	@Autowired
	LiveInfoService liveInfoService;

	@Override
	public void add(String token,LiveInfo liveInfo) {

		liveInfoService.save(liveInfo);
	}

	@Override
	public void updateNotNull(String token,LiveInfo liveInfo) {
		liveInfoService.updateNotNull(liveInfo);
	}

	@Override
	public LiveInfo getById(Long id) {
		System.out.println("***********************************");
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
			if(liveInfoVo.getCreateTimeLower()!=null&&liveInfoVo.getCreateTimeUpper()!=null){
				criteria.andBetween("createTime", liveInfoVo.getCreateTimeLower(),liveInfoVo.getCreateTimeUpper() );
			}else if(liveInfoVo.getCreateTimeLower()!=null){
				criteria.andBetween("createTime", liveInfoVo.getCreateTimeLower(),System.currentTimeMillis() );
			}else if(liveInfoVo.getCreateTimeUpper()!=null){
				criteria.andBetween("createTime", 0,liveInfoVo.getCreateTimeUpper() );
			}
			if(liveInfoVo.getStartLower()!=null&&liveInfoVo.getStartUpper()!=null){
				criteria.andBetween("start", liveInfoVo.getStartLower(),liveInfoVo.getStartUpper() );
			}else if(liveInfoVo.getStartLower()!=null){
				criteria.andBetween("start", liveInfoVo.getStartLower(),System.currentTimeMillis() );
			}else if(liveInfoVo.getStartUpper()!=null){
				criteria.andBetween("start", 0,liveInfoVo.getStartUpper() );
			}
			if(liveInfoVo.getEndLower()!=null&&liveInfoVo.getEndUpper()!=null){
				criteria.andBetween("createTime", liveInfoVo.getEndLower(),liveInfoVo.getEndUpper() );
			}else if(liveInfoVo.getEndLower()!=null){
				criteria.andBetween("createTime", liveInfoVo.getEndLower(),System.currentTimeMillis() );
			}else if(liveInfoVo.getEndUpper()!=null){
				criteria.andBetween("createTime", 0,liveInfoVo.getEndUpper() );
			}
		}
		
		List<LiveInfo> list = liveInfoService.selectByExample(example);
		return list;
	}

	@Override
	public void delete(String token,Long id) {
		liveInfoService.delete(id);
	}

	@Override
	public List<LiveInfo> searchList(LiveSearchVo liveSearchVo) {
		// TODO Auto-generated method stub
		return null;
	}

}
