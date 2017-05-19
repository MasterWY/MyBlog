<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'editUIF.jsp' starting page</title>
  </head>
  
  <body>
    <div style="width:auto;height:50%;text-align:center;">
   	<form style="width:50%;border:1px black solid;text-align:center;" action="fileupload" enctype="multipart/form-data" method="post">
   	用户名：${username}<br>
   	<s:file name="uploadFile" label="更换头像"/><br>
   	<input type="submit" value="保存"/>
   	</form>
    </div>
  </body>
</html>
