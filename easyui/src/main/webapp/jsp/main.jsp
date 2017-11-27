<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<base href="<%=basePath %>">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.json-2.4.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jackjson.js" charset="utf-8"></script>
</head>
<body>
	<button id="one">单个新增或修改</button>
    <button id="two">批量新增或修改</button>
    <button id="three">单个删除</button>
    <button id="four">批量删除</button>
    <button id="five">单条件查询多用户</button>
    <button id="six">单条件查询Map</button>
</body>
</html>