package com.niit.actions;
import java.text.SimpleDateFormat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.niit.myblog.interfaces.BlogInterface;
import com.niit.myblog.model.BlogBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class EditBlogAction extends ActionSupport{
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
	ApplicationContext acc=new ClassPathXmlApplicationContext("applicationContext.xml");
	BlogInterface bb=(BlogInterface)acc.getBean("blogInterface");
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	ActionContext act=ActionContext.getContext();
	BlogBean br=new BlogBean();
	System.out.println(act.getSession().get("Date").toString()+act.getSession().get("username").toString());
	br.setArticle(title);
	br.setCategory(category);
	br.setContent(content);
	br.setUser_Name(act.getSession().get("username").toString());
	br.setPub_Date(act.getSession().get("Date").toString());
	bb.update(br);
	return SUCCESS;
	}

	
}
