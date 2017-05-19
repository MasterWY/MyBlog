package com.niit.actions;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.niit.myblog.interfaces.BlogInterface;
import com.niit.myblog.model.BlogBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditSkipAction extends ActionSupport{
	private String PubDate;
	private String username;
	public void setUsername(String username){
		this.username=username;
	}
	public String getUsername(){
		return username;
	}
	public void setPubDate(String PubDate){
		this.PubDate=PubDate;
	}
	public String getPubDate(){
		return PubDate;
	}
	public String execute(){
	ApplicationContext acc=new ClassPathXmlApplicationContext("applicationContext.xml");
	BlogInterface bb=(BlogInterface)acc.getBean("blogInterface");
	List<BlogBean> br1=bb.findByUser_Name(username);
	BlogBean br=new BlogBean();
	for(int i=0;i<br1.size();i++){
		if(br1.get(i).getPub_Date().toString().equals(PubDate))
			br=br1.get(i);
	}
	ActionContext act=ActionContext.getContext();
	act.getSession().put("Date",PubDate);
	ServletActionContext.getRequest().setAttribute("Title", br.getArticle());
	ServletActionContext.getRequest().setAttribute("Content", br.getContent());
	ServletActionContext.getRequest().setAttribute("Catogery", br.getCategory());
	return "editblog";
	}
}
