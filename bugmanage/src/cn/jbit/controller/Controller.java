package cn.jbit.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.jbit.pojo.BugDetail;
import cn.jbit.pojo.BugProject;
import cn.jbit.service.Service;

@org.springframework.stereotype.Controller
public class Controller {

	@Resource
	private Service service;
	@RequestMapping("selDetail")
	public String selBug(@RequestParam(value="projectId" ,required=false) String projectId,
			HttpSession session){
		long _id=0;
		if(null!=projectId&&""!=projectId){
			_id=Integer.valueOf(projectId);
		}
		
		try{
			//保存详细集合
		List<BugDetail> list=service.selBugDetail(_id);
		/*SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);

		SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		System.out.println(sdf2.format(sdf1.parse())); */
		session.setAttribute("listD", list);
			//保存项目集合
		List<BugProject> lists=service.selBugProject();
		session.setAttribute("listP", lists);
		//保存选中的值
		session.setAttribute("id", _id);
		}catch(Exception e){
			e.printStackTrace();
			session.removeAttribute("listD");
			return "error";
		}
		return "list";
	}
	
	@RequestMapping(value="adds")
	public String selProject(@RequestParam("projectId") String projectId,
			HttpSession session){
		session.setAttribute("id", projectId);
		return "add";
	}
	
	@RequestMapping(value="addBug",method=RequestMethod.POST)
	public String addBug(@ModelAttribute("bugDetail") BugDetail bugDetail) throws ParseException{
		
		String datestr = new Date().toString();
		try{
			Date date = null;
				date = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK)
						.parse(datestr);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String da=sdf.format(date);
			bugDetail.setCreateDate(da);
			service.addBugDetail(bugDetail);
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
		
		return "redirect:/selDetail";
	
	}
}
