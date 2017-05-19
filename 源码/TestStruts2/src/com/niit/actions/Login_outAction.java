package com.niit.actions;

import org.apache.struts2.ServletActionContext;

public class Login_outAction {
public String login_out(){
	ServletActionContext.getContext().getSession().remove("username");
	return "login_out";
}
}
