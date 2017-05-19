package com.niit.actions;

import com.niit.myblog.interfaces.AccountInterface;
import com.niit.myblog.model.AccountBean;

import org.springframework.context.support.ClassPathXmlApplicationContext;


import org.springframework.context.ApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private String username;
	private String password;
	public void setUsername(String username){
		this.username=username;
	}
	public String getUsername(){
		return username;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String login()throws Exception{
	ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	AccountInterface account=(AccountInterface)ac.getBean("accountInterface");
	AccountBean act=account.findByAccountNo(username);
	if(act.getFlag()){
		if(password.equals(act.getPassword())){
			ActionContext context=ActionContext.getContext();
			context.getSession().put("username", username);
			context.getSession().put("userType",act.getUserType());
			return SUCCESS;}
		else return "failed";
	}
	else return "failed";
}
}
