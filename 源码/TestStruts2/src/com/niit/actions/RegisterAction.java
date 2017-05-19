package com.niit.actions;
import com.niit.myblog.interfaces.AccountInterface;
import com.niit.myblog.interfaces.UserInfoInterface;
import com.niit.myblog.model.AccountBean;
import com.niit.myblog.model.UserInfoBean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

import org.springframework.context.ApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport{
private String username;
private String password;
private String cfmPsw;
public void setUsername(String username){
	this.username=username;
}
public String getUsername(){
	return username;
}
public void setPassword(String password){
	this.password=password;
}
public String getPassword(){
	return password;
}
public void setCfmPsw(String cfmPsw){
	this.cfmPsw=cfmPsw;
}
public String execute(){
	String path="C:/Users/niit26/Workspaces/MyEclipse 2016 CI/TestStruts2/WebRoot/Bloggers/"+username+"/images";
	File f1=new File(path);
	f1.mkdirs();
	ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
	AccountInterface account=(AccountInterface)app.getBean("accountInterface");
	UserInfoInterface userInfo=(UserInfoInterface)app.getBean("userInfoInterface");
	AccountBean acc=new AccountBean(username,password,"user");
	UserInfoBean abb=new UserInfoBean(username,username+"/images",username+"/Articles",0,"",100,username+"/Messages",0);
	ActionContext acc1=ActionContext.getContext();
	acc1.getSession().put("username", username);
	acc1.getSession().put("userType",acc.getUserType());
	account.insert(acc);
	userInfo.insert(abb);
	return SUCCESS;
}
}
