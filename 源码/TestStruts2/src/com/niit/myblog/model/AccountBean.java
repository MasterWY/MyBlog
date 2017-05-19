
package com.niit.myblog.model;


public class AccountBean {
    private String User_Name;
    private String Password;
    private String UserType;
    private boolean flag;
    public AccountBean(){}
    public AccountBean(String User_Name, String Password, String UserType) {
        this.User_Name = User_Name;
        this.Password = Password;
        this.UserType = UserType;
    }
    public String getUser_Name()
    {
        return User_Name;
    }
    public void setUser_Name(String User_Name){
        this.User_Name=User_Name;
    }
    public String getPassword(){
        return Password;
    }
    public void setPassword(String Password){
        this.Password=Password;
    }
    public String getUserType(){
        return UserType;
    }
    public void setUserType(String UserType){
        this.UserType=UserType;
    }
    public boolean getFlag(){
    	return flag;
    }
    public void setFlag(boolean flag){
    	this.flag=flag;
    }
}