package com.niit.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.niit.myblog.interfaces.BlogInterface;
import com.niit.myblog.model.BlogBean;
public class ReadBlogAction extends ActionSupport{
	private String authorname;
	private String Pub_Date;
	public void setAuthorname(String authorname){
		this.authorname=authorname;
	}
	public String getAuthorname(){
		return authorname;
	}
	public void setPub_Date(String Pub_Date){
		this.Pub_Date=Pub_Date;
	}
	public String getPub_Date(){
		return Pub_Date;
	}
	public String execute(){
		ApplicationContext acc=new ClassPathXmlApplicationContext("applicationContext.xml");
		BlogInterface bb=(BlogInterface)acc.getBean("blogInterface");
		List<BlogBean> br1=bb.findByUser_Name(authorname);
		BlogBean br=new BlogBean();
		for(int i=0;i<br1.size();i++){
			if(br1.get(i).getPub_Date().toString().equals(Pub_Date))
				br=br1.get(i);
		}
		boolean triggle=false;
		boolean rewardT=false;
		
		ActionContext actionContext=ActionContext.getContext();
		actionContext.getSession().put("Title",br.getArticle());
		actionContext.getSession().put("AuthorName",authorname);
		actionContext.getSession().put("Category",br.getCategory());
		actionContext.getSession().put("Content",br.getContent());
		actionContext.getSession().put("Comments",br.getComments());
		actionContext.getSession().put("Like",br.getLikes());
		actionContext.getSession().put("Dislikes",br.getDislikes());
		actionContext.getSession().put("Tags",br.getTag());
		actionContext.getSession().put("Date",br.getPub_Date());
		actionContext.getSession().put("triggle",triggle);
		actionContext.getSession().put("rewardTs",rewardT);
		return SUCCESS;
	}
}
