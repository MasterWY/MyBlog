package com.niit.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.niit.myblog.interfaces.UserInfoInterface;
import com.niit.myblog.model.UserInfoBean;
public class RewardAction extends ActionSupport{
	private String username;
	private String authorname;
	public void setUsername(String username){
		this.username=username;
	}
	public String getUsername(){
		return username;
	}
	public void setAuthorname(String authorname){
		this.authorname=authorname;
	}
	public String execute(){
		ApplicationContext acc=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserInfoInterface uf=(UserInfoInterface)acc.getBean("userInfoInterface");
		UserInfoBean user=uf.findByUser_Name(username);
		if(user.getAccount_Balance()>9){
		UserInfoBean author=uf.findByUser_Name(authorname);
		user.setAccount_Balance(user.getAccount_Balance()-10);
		author.setAccount_Balance(author.getAccount_Balance()+10);
		uf.update(user);
		uf.update(author);
		return "blogread";}
		else{
			ActionContext actionContext=ActionContext.getContext();
			boolean rewardT=true;
			actionContext.getSession().put("rewardTs",rewardT);
			return "blogread";
			}
	}
}
