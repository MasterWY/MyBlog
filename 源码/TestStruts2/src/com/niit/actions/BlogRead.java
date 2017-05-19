package com.niit.actions;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.niit.myblog.interfaces.BlogInterface;
import com.niit.myblog.model.BlogBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BlogRead extends ActionSupport{
	private int Blog_num;
	private int Cur_page;
	private int Total_page;
	private List<BlogBean> blogFactory;
	public void setBlog_num(int Blog_num){
		this.Blog_num=Blog_num;
	}
	public int getBlog_num(){
		return Blog_num;
	}
	public void setCur_page(int Cur_page){
		this.Cur_page=Cur_page;
	}
	public void setTotal_page(int Total_page){
		this.Total_page=Total_page;
	}
	public void setBlogFactory(List<BlogBean> blogFactory){
		this.blogFactory=blogFactory;
	}
	public List<BlogBean> getBlogFactory(){
		return blogFactory;
	}
	public String execute(){
ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
BlogInterface blgF=(BlogInterface)app.getBean("blogInterface");
blogFactory=blgF.findAll();
Total_page=(blogFactory.size()+9)/10;
List<String> gTopic=new ArrayList<String>();
for(int i=0;i<blogFactory.size();i++){
	String pp=blogFactory.get(i).getArticle();
	gTopic.add(pp);
}
	ActionContext ac=ActionContext.getContext();
	ac.getSession().put("TotalPage", Total_page);
	ac.getSession().put("CurPage", Cur_page);
	ac.getSession().put("TotalPage", Total_page);
	ac.getSession().put("gtopic", gTopic);
	ac.getSession().put("Blog",blogFactory);
	return SUCCESS;
	}
}
