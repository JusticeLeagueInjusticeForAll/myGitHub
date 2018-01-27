package cn.jbit.service;

import java.util.List;


import cn.jbit.pojo.BugDetail;
import cn.jbit.pojo.BugProject;

public interface Service {

	/**
	 * ��ѯ����bug/������Ŀ��ѯbug
	 * @return
	 */
	public List<BugDetail> selBugDetail(long id);
	
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
