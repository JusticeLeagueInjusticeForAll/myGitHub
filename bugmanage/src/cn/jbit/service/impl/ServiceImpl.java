package cn.jbit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import cn.jbit.dao.Mapper;
import cn.jbit.pojo.BugDetail;
import cn.jbit.pojo.BugProject;
import cn.jbit.service.Service;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

	@Resource
	private Mapper mapper;
	@Override
	public List<BugDetail> selBugDetail(long id) {
		// TODO Auto-generated method stub
		return mapper.selBugDetail(id);
	}

	@Override
	public List<BugProject> selBugProject() {
		// TODO Auto-generated method stub
		return mapper.selBugProject();
	}

	@Override
	public int addBugDetail(BugDetail bugDetail) {
		// TODO Auto-generated method stub
		return mapper.addBugDetail(bugDetail);
	}

}
