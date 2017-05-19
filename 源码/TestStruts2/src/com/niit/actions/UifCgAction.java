package com.niit.actions;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.niit.myblog.interfaces.UserInfoInterface;
import com.niit.myblog.model.UserInfoBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UifCgAction extends ActionSupport{
	private File uploadFile;
	private String uploadFileContentType;
	private String uploadFileFileName;
	public void setUploadFile(File uploadFile){
		this.uploadFile=uploadFile;
	}
	public File getUploadFile(){
		return uploadFile;
	}
	public void setUploadFileContentType(String uploadFileContentType){
		this.uploadFileContentType=uploadFileContentType;
	}
	public String getUploadFileContentType(){
		return uploadFileContentType;
	}
	public void setUploadFileFileName(String uploadFileName){
		this.uploadFileFileName=uploadFileName;
	}
	public String getUploadFileFileName(){
		return uploadFileFileName;
	}
	public String execute() throws Exception{
		ActionContext app=ActionContext.getContext();
		String username=app.getSession().get("username").toString();
		InputStream is=new FileInputStream(uploadFile);
		File dele=new File("C:/Users/niit26/Workspaces/MyEclipse 2016 CI/TestStruts2/WebRoot/Bloggers/"+username+"/images");
		if(dele.exists()) {
			File[] file=dele.listFiles();
			for(int i=0;i<file.length;i++)
				file[i].delete();
		}	
		File toFile=new File("C:\\Users\\niit26\\Workspaces\\MyEclipse 2016 CI\\TestStruts2\\WebRoot\\Bloggers\\"+username+"\\images", this.getUploadFileFileName());
		OutputStream os=new FileOutputStream(toFile);
		byte[] buffer=new byte[1024];
		int length=0;
		while((length=is.read(buffer))>0){
			os.write(buffer,0,length);
		}
		is.close();
		os.close();
		ApplicationContext app1=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserInfoInterface uif=(UserInfoInterface)app1.getBean("userInfoInterface");
		UserInfoBean user=uif.findByUser_Name(username);
		user.setUser_Icon("Bloggers/"+username+"/images/"+this.getUploadFileFileName());
		uif.update(user);
		return SUCCESS;
	}
}
