package com.test.actions;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private String username;
	private String password;
	public void setUsername(String username){
		this.username=username;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getUsername(){
		return username;
	}
	public String getPassword(){
		return password;
	}
public String login(){
	if(username.equals("admin")&&password.equals("123123")){
		return "success";
	}else return INPUT;
}
public String register(){
	return "sign_up";
}
}
