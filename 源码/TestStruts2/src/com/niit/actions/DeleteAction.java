package com.niit.actions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.niit.myblog.interfaces.BlogInterface;
import com.niit.myblog.model.BlogBean;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteAction extends ActionSupport{
	private String Article;
	private String PubDate;
	private String username;
	public void setUsername(String username){
		this.username=username;
	}
	public String getUsername(){
		return username;
	}
	public void setArticle(String Article){
		this.Article=Article;
	}
	public String getArticle(){
		return Article;
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
		BlogBean bbb=new BlogBean();
		bbb.setArticle(Article);
		bbb.setUser_Name(username);
		bbb.setPub_Date(PubDate);
		bb.delete(bbb);
		return SUCCESS;
	}
}
