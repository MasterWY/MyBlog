<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>${Title}</title>    
	<link rel="stylesheet" type="text/css" href="CSS/button.css">
	<script>
  function Like(){
  var true1="true";
  if(${triggle}) alert("你已经发表过你的态度了");
  else window.location.href='like?like='+true1+'&dislike=null';
  }
  function Dislike(){
  var false1="false";
  if(${triggle}) alert("你已经发表过你的态度了");
  else window.location.href='like?dislike='+false1+'&like=null';
  }
  function Reward(){
  if (${sessionScope.username==null})
  {
  alert("请先登录！");
  }
else if (${sessionScope.username!=null&&!sessionScope.rewardTs})
  {
 window.location.href='reward?username=${username}&authorname=${AuthorName}';
  }
else
  {
  alert("余额不足");
  }
document.getElementById("demo").innerHTML=x;
}
/*   if(${sessionScope.username==null}) alert("请先登录！");
  else
  window.location.href='reward?username=${username}&authorname=${AuthorName}'; */
 /*  if(${sessionScope.username==null}) alert("请先登录！");
  else if(${sessionScope.username!=null&&!sessionScope.rewardTs})*/
/*   else if(sessionScope.rewardTs) alert("余额不足"); */
  </script>
  </head>
  <body>
  <div style="width:100%;height:30px;color:#ff0000;">
<c:choose>
<c:when test="${sessionScope.username==null}">
<a href="Login.jsp">登陆</a>
<a href="Register.jsp">注册</a>
</c:when>
<c:when test="${sessionScope.username!=null&&sessionScope.userType.equals('user')}">
${username}<a href="Blogzone!login?username=${username}">个人空间</a>${sessionScope.triggle}${username}${rewardTs}
<input type="button" value="退出登陆" onclick="javascript:window.location.href='login_out!login_out'"/>
</c:when>
<c:when test="${sessionScope.username!=null&&sessionScope.userType!='user'}">
${sessionScope.username}<a href="Adminzone">管理网站</a>
<input type="button" value="退出登陆" onclick="javascript:window.location.href='login_out!login_out'"/>
</c:when>
</c:choose>
</div>
    <div style="width:100%;height:100px;text-align:center;border:solid 1px black;"><h1>${AuthorName}</h1></div>
    <div style="widht:100%;height:auto;border:solid 1px black;">
<div id="r1" style="width:20%;height:100%;float:left;"></div>
<div id="b1" style="width:59.5%;height:auto;float:left;border:solid 1px black;">
<div style="width:100%;height:70px;float:left;">
<h2>${Title}</h2>
</div>
<div style="width:100%;height:50px;float:left;text-align:right">发表于${Date}</div>
<div style="width:100%;height:auto;float:left;">${Content}</div>
<div style="float:left;width:20%;height:30px;text-align:right">${Like}</div>
<button class="button button-3d button-action button-circle button-jumbo" style="float:left" onclick="Like()"><i class="fa fa-thumbs-up">顶</i></button>
<div style="float:left;width:20%;height:30px;"></div>
  <button class="button button-caution button-box button-raised button-giant button-longshadow" onclick="Reward()"><i class="fa fa-google-plus">打赏</i></button>
<div style="float:right;width:20%;height:30px;">${Dislikes}</div>
<button class="button button-3d button-action button-circle button-jumbo" style="float:right" onclick="Dislike()"><i class="fa fa-thumbs-up">踩</i></button>
</div>    
<div id="r2" style="width:20%;height:100%;float:right;"></div>  
    </div>
  </body>
</html>
