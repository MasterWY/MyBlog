
package com.niit.myblog.model;


public class UserInfoBean{
    private String User_Name;
    private String User_Icon;
    private String Article;
    private int C_Number;
    private String My_Focus;
    private int Account_Balance;
    private String Message;
    private int Counter;
    public UserInfoBean(){
        
    }
    public UserInfoBean(String User_Name,String User_Icon,String Article,int C_Number,String My_Focus,int Account_Balance,String Message,int Counter){
        this.User_Name=User_Name;
        this.User_Icon=User_Icon;
        this.Article=Article;
        this.C_Number=C_Number;
        this.My_Focus=My_Focus;
        this.Account_Balance=Account_Balance;
        this.Message=Message;
        this.Counter=Counter;
    }
    public String getUser_Name(){
        return  User_Name;
    }
    public void setUser_Name(String User_Name){
        this.User_Name=User_Name;
    }
    public String getUser_Icon(){
        return User_Icon;
    }
    public void setUser_Icon(String User_Icon){
        this.User_Icon=User_Icon;
    }
    public String getArticle(){
        return Article;
    }
    public void setArticle(String Article){
        this.Article=Article;
    }
    public int getC_Number(){
        return C_Number;
    }
    public void setC_Number(int C_Number){
        this.C_Number=C_Number;
    }
    public String getMy_Focus(){
        return My_Focus;
    }
    public void setMy_Focus(String My_Focus){
        this.My_Focus=My_Focus;
    }
    public int getAccount_Balance(){
        return Account_Balance;
    }
    public void setAccount_Balance(int Account_Balance){
        this.Account_Balance=Account_Balance;
    }
    public String getMessage(){
        return Message;
    }
    public void setMessage(String Message){
        this.Message=Message;
    }
    public int getCounter(){
        return Counter;
    }
    public void setCounter(int Counter){
        this.Counter=Counter;
    }
}