<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title><%=session.getAttribute("username") %>的空间</title>
    <link rel="stylesheet" type="text/css" href="CSS/Blogzone.css">
  </head>
  <body>
   <div class="header"><input type="button" onclick="javascript:windows."><%=session.getAttribute("username") %>的空间</div>
   <div class="contanier">
   <div class="sider_bar">
   <div class="head_icon">
   <img style="width:99%;height:290px;" src="${userIcon}">
   </div>
   <div class="userBalance">
   <p>账户余额<br>
   ${userBalance}
   </p>
   </div>
   <div class="userFocus">
   <p><a href="">我的关注</a>
   </p>
   </div>
   <div class="userFans">
   <p>我的粉丝<br>
   ${userFans}
   </p>
   </div>
   </div>
   <div class="body">
   <div class="navigation">
   <input type="button" value="编辑个人信息" onclick="javascript:window.location.href='edit?'">&nbsp;
   <input type="button" value="写博文" onclick="javascript:window.location.href='writeblog?'">&nbsp;
   <input type="button" value="我的私信">&nbsp;
   <input type="button" value="留言们">
   </div>
   <div class="blogshow">
   <s:iterator value="#request.Blog">
<div>
<li><a href="BlogRead?username=${User_Name}&Pub_Date=${Pub_Date}">${Article}</a><a href="EditSkipBlog?username=${username}&PubDate=${Pub_Date}">&nbsp;&nbsp;编辑</a><a href="delete?username=${username}&Article=${Article}&PubDate=${Pub_Date}">&nbsp;&nbsp;删除</a></li>
<span>${Pub_Date}</span>
</div>
</s:iterator>
   </div>
   </div>
   </div>
  </body>
</html>
