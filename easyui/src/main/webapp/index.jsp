<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=basePath %>js/jquery.min.js"></script>
</head>
<body>
	<form action="<%=basePath %>User/login">
		<input type="text" name="name">
		<input type="password" name="pwd">
		<input type="submit" value="登录">
	</form>
	<form action="<%=basePath %>one">
		<input type="text" name="name">
		<input type="password" name="pwd">
		<input type="submit" value="提交1">
	</form>
	<form action="<%=basePath %>two">
		<input type="text" name="name">
		<input type="password" name="pwd">
		<input type="submit" value="提交2">
	</form>
	<form action="<%=basePath %>files/upload" method="post" enctype="multipart/form-data">
		<input type="file" name="fileName"/>
		<input type="text" name="name"/>
		<input type="text" name="pwd"/>
		<input type="submit" value="上传1"/>
	</form>
	<form action="<%=basePath %>files/upload2" method="post" enctype="multipart/form-data">
		<input type="file" name="fileName"/>
		<input type="file" name="fileName"/>
		<input type="file" name="fileName"/>
		<input type="submit" value="上传2"/>
	</form>
</body>
</html>