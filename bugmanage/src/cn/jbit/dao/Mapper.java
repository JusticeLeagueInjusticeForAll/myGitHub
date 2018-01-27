package cn.jbit.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jbit.pojo.BugDetail;
import cn.jbit.pojo.BugProject;


public interface Mapper {

	/**
	 * 查询所有bug/根据项目查询bug
	 * @return
	 */
	public List<BugDetail> selBugDetail(@Param("id")long id);
	
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
