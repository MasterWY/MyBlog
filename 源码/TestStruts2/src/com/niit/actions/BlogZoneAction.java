package com.niit.actions;
import com.opensymphony.xwork2.ActionSupport;
import com.niit.myblog.interfaces.UserInfoInterface;
import com.niit.myblog.model.BlogBean;
import com.niit.myblog.model.UserInfoBean;
import com.niit.myblog.interfaces.BlogInterface;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
public class BlogZoneAction extends ActionSupport{
	private String username;
	public void setUsername(String username){
		this.username=username;
	}
	public String getUsername(){
		return username;
	}
	public String login(){
		if(username==null){return "failed";}
		else{
		ApplicationContext acc=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserInfoInterface account=(UserInfoInterface)acc.getBean("userInfoInterface");
		BlogInterface blog=(BlogInterface)acc.getBean("blogInterface");
		List<BlogBean> BB=blog.findByUser_Name(username);
		UserInfoBean UIF=account.findByUser_Name(username);
		ServletActionContext.getRequest().setAttribute("Blog", BB);
		ServletActionContext.getRequest().setAttribute("username", username);
		ServletActionContext.getRequest().setAttribute("userIcon", UIF.getUser_Icon());
		ServletActionContext.getRequest().setAttribute("userBalance", UIF.getAccount_Balance());
		ServletActionContext.getRequest().setAttribute("userFans", UIF.getC_Number());
		ServletActionContext.getRequest().setAttribute("userFocus", UIF.getMy_Focus());
		ServletActionContext.getRequest().setAttribute("userCounter", UIF.getCounter());
		return "BlogZone";}
	}
	}

