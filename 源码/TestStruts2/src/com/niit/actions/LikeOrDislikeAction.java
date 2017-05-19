package com.niit.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.niit.myblog.interfaces.BlogInterface;
import com.niit.myblog.model.BlogBean;
public class LikeOrDislikeAction extends ActionSupport{
	private String like;
	private String dislike;
	public void setLike(String like){
		this.like=like;
	}
	public String getLike(String like){
		return like;
	}
	public void setDislike(String dislike){
		this.dislike=dislike;
	}
	public String getDislike(){
		return dislike;
	}
	public String execute(){
		String username=ActionContext.getContext().getSession().get("AuthorName").toString();
		String pubDate=ActionContext.getContext().getSession().get("Date").toString();		
		ApplicationContext acc=new ClassPathXmlApplicationContext("applicationContext.xml");
		BlogInterface bb=(BlogInterface)acc.getBean("blogInterface");
		List<BlogBean> br1=bb.findByUser_Name(username);
		BlogBean br=new BlogBean();
		for(int i=0;i<br1.size();i++){
			if(br1.get(i).getPub_Date().toString().equals(pubDate))
				br=br1.get(i);
		}
		if(like.equals("true")&&like!=null) br.setLikes(br.getLikes()+1);
		else {br.setDislikes(br.getDislikes()+1);}
		boolean triggle=true;
		ActionContext actionContext=ActionContext.getContext();
		actionContext.getSession().put("Title",br.getArticle());
		actionContext.getSession().put("Username",username);
		actionContext.getSession().put("Category",br.getCategory());
		actionContext.getSession().put("Content",br.getContent());
		actionContext.getSession().put("Comments",br.getComments());
		actionContext.getSession().put("Like",br.getLikes());
		actionContext.getSession().put("Dislikes",br.getDislikes());
		actionContext.getSession().put("Tags",br.getTag());
		actionContext.getSession().put("Date",br.getPub_Date());
		actionContext.getSession().put("triggle",triggle);
		bb.updateLD(br);
		return "blogread";
	}
}
