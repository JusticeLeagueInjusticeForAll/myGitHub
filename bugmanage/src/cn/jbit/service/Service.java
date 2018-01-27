package cn.jbit.service;

import java.util.List;


import cn.jbit.pojo.BugDetail;
import cn.jbit.pojo.BugProject;

public interface Service {

	/**
	 * 查询所有bug/根据项目查询bug
	 * @return
	 */
	public List<BugDetail> selBugDetail(long id);
	
	/**
	 * 查询所有项目信息
	 * @return
	 */
	public List<BugProject> selBugProject();

	
	/**
	 * 添加bug详情
	 * @return
	 */
	public int addBugDetail(BugDetail bugDetail);
	
}
