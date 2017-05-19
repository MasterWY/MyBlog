package com.niit.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.text.DateFormat;

import javax.enterprise.inject.New;
import javax.mail.Session;
import java.util.Date;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.text.SimpleDateFormat;
import com.niit.myblog.interfaces.BlogInterface;
import com.niit.myblog.model.BlogBean;
public class PublishBlogAction extends ActionSupport{
	private String title;
	private String category;
	private String content;
	public void setTitle(String title){
		this.title=title;
	}
	public String getTitle(){
		return title;
	}
	public void setCategory(String category){
		this.category=category;
	}
	public String getCategory(){
		return category;
	}
	public void setContent(String content){
		this.content=content;
	}
	public String getContent(){
		return content;
	}
	public String execute(){
		ActionContext act=ActionContext.getContext();
		ApplicationContext acc=new ClassPathXmlApplicationContext("applicationContext.xml");
		BlogInterface bl=(BlogInterface)acc.getBean("blogInterface");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		BlogBean bb=new BlogBean(title,act.getSession().get("username").toString(),category,content,"",0,0,df.format(new Date()),"");
		bl.insert(bb);
		return SUCCESS;
	}
}
