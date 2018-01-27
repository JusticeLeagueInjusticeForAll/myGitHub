package cn.jbit.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jbit.pojo.BugDetail;
import cn.jbit.pojo.BugProject;


public interface Mapper {

	/**
	 * ��ѯ����bug/������Ŀ��ѯbug
	 * @return
	 */
	public List<BugDetail> selBugDetail(@Param("id")long id);
	
	/**
	 * ��ѯ������Ŀ��Ϣ
	 * @return
	 */
	public List<BugProject> selBugProject();

	
	/**
	 * ���bug����
	 * @return
	 */
	public int addBugDetail(BugDetail bugDetail);
	
}
