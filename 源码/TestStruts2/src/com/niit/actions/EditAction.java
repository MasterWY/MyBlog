package com.niit.actions;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class EditAction extends ActionSupport{
	private String username;
	public void setUsername(String username){
		this.username=username;
	}
	public String getUsername(){
		return username;
	}
	public String execute(){
		ServletActionContext.getRequest().setAttribute("username", username);
		return "edituif";
	}
}
