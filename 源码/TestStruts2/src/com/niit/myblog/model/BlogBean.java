
package com.niit.myblog.model;

public class BlogBean {
    private String Article;
    private String User_Name;
    private String Category;
    private String Content;
    private String Comments;
    private int Likes;
    private int Dislikes;
    private String Pub_Date;
    private String Tag;
    
    public BlogBean(){}
    public BlogBean(String Article,String User_Name,String Category,String Content,String Comments,int Likes,int Dislikes,String Pub_Date,String Tag){
        this.Article=Article;
        this.User_Name=User_Name;
        this.Category=Category;
        this.Content=Content;
        this.Comments=Comments;
        this.Likes=Likes;
        this.Dislikes=Dislikes;
        this.Pub_Date=Pub_Date;
        this.Tag=Tag;
    }
    public String getArticle(){
        return Article;
    }
    public void setArticle(String Article){
        this.Article=Article;
    }
    public String getUser_Name(){
        return User_Name;
    }
    public void setUser_Name(String User_Name){
        this.User_Name=User_Name;
    }
    public String getCategory(){
        return Category;
    }
    public void setCategory(String Category){
        this.Category=Category;
    }
    public String getContent(){
        return Content;
    }
    public void setContent(String Content){
        this.Content=Content;
    }
    public String getComments(){
        return Comments;
    }
    public void setComments(String Comments){
        this.Comments=Comments;
    }
    public int getLikes(){
        return Likes;
    }
    public void setLikes(int Likes){
        this.Likes=Likes;
    }
    public int getDislikes(){
        return Dislikes;
    }
    public void setDislikes(int Dislikes){
        this.Dislikes=Dislikes;
    }
    public String getPub_Date(){
        return Pub_Date;
    }
    public void setPub_Date(String Pub_Date){
        this.Pub_Date=Pub_Date;
    }
    public String getTag(){
    	return Tag;
    }
    public void setTag(String Tag){
    	this.Tag=Tag;
    }
}
