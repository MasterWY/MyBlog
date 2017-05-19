<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE>
<html>
  <head>

    <link rel="stylesheet" type="text/css" href="CSS/Index.css">
  </head>
  
<body>
<div class="header">
<c:choose>
<c:when test="${sessionScope.username==null}">
<a href="Login.jsp">登陆</a>
<a href="Register.jsp">注册</a>
</c:when>
<c:when test="${sessionScope.username!=null&&sessionScope.userType.equals('user')}">
${username}<a href="Blogzone!login?username=${username}">个人空间</a>
<input type="button" value="退出登陆" onclick="javascript:window.location.href='login_out!login_out'"/>
</c:when>
<c:when test="${sessionScope.username!=null&&sessionScope.userType!='user'}">
${sessionScope.username}<a href="Adminzone">管理网站</a>
<input type="button" value="退出登陆" onclick="javascript:window.location.href='login_out!login_out'"/>
</c:when>
</c:choose>
</div>
<div class="head">

</div>
<div class="navigation">
<a href="index">首页</a>&nbsp;&nbsp;
<a href="news">新闻</a>&nbsp;&nbsp;
<a href="hotblog">最热博文</a>&nbsp;&nbsp;
<a href="hotblogger">最热博主</a>&nbsp;&nbsp;
<div style="float:right">
<input type="text" name="search"><input type="button" value="找找看"></div>
</div>
<div class="side_column">
<ul>
<li><a href="">.NET技术</a></li>
<li><a href="">编程语言</a></li>
<li><a href="">软件设计</a></li>
<li><a href="">Web前端开发</a></li>
<li><a href="">手机开发</a></li>
<li><a href="">软件工程</a></li>
<li><a href="">数据化技术</a></li>
<li><a href="">操作系统</a></li>
<li><a href="">其他分类</a></li>
</ul>
</div>
<div class="blogshow">
<div class="blogtopic">
</div>
<div class="pageshow">
<s:iterator value="#session.Blog">
<div>
<li><a href="BlogRead?authorname=${User_Name}&Pub_Date=${Pub_Date}">${Article}</a></li>
<span>${User_Name}</span>
<span>${Pub_Date}</span>
</div>
</s:iterator>
</div>
</div>
  </body>
</html>
