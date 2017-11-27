<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>static/jquery-easyui-1.5.1/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>static/jquery-easyui-1.5.1/themes/icon.css">
<script type="text/javascript"
	src="<%=basePath%>static/jquery-easyui-1.5.1/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>static/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>static/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=basePath%>js/userlist.js"
	charset="utf-8"></script>

</head>
<body class="easyui-layout">

	<div data-options="region:'north',title:'条件查询',split:true"
		style="height: 70px;">

			<table>
				<tr>
					<td>用户名：</td>
					<td><input id="name" class="easyui-validatebox"
						data-options="required:false" /></td>
					<td>密码：</td>
					<td><input id="pwd"
						class="easyui-validatebox" data-options="required:false" /></td>
					<td><a id="query" href="javascript:void(0)"
						class="easyui-linkbutton"
						data-options="iconCls:'icon-search',method:'GET'">搜索</a></td>
				</tr>

				
			</table>
	</div>

	<div data-options="region:'center',title:'用户列表'"
		style="padding: 5px; background: #eee;">

		<table id="tt" class="easyui-datagrid"
			style="width: auto; height: 100%"
			data-options="fitColumns:true,singleSelect:false,pagination:true,toolbar:'#tb'">
			<thead>
				<tr>
					<th data-options="field:'id',width:100,align:'center'">编号</th>
					<th data-options="field:'name',width:100,align:'center'">用户名</th>
					<th data-options="field:'pwd',width:100,align:'center'">密码</th>				
				</tr>
			</thead>
		</table>
	</div>
	<div id="tb">
		<a href="javascript:void(0)" id="add" class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true" a>新增</a> <a
			href="javascript:void(0)" id="update" class="easyui-linkbutton"
			data-options="iconCls:'icon-edit',plain:true" a>修改</a> <a
			href="javascript:void(0)" id="delete" class="easyui-linkbutton"
			data-options="iconCls:'icon-cancel',plain:true" a>删除</a>
	</div>
	<div id="user-save-dialog" class="easyui-dialog" title="新增用户"
		style="width: 400px; height: 200px;"
		data-options="iconCls:'icon-save',resizable:true,modal:true,buttons:'#bb',closed:true">

		<form id="user-add-form" method="post">
			<div>
				<label for="name">Name:</label> <input class="easyui-validatebox"
					type="text" name="name" data-options="required:true" />
			</div>
			<div>
				<label for="password">pwd:</label> <input class="easyui-validatebox"
					type="text" name="pwd" data-options="required:true" />
			</div>

		</form>
	</div>
	<div id="bb">
		<a id="save-user-btn" href="javascript:void(0)"
			class="easyui-linkbutton">保存</a> <a id="cancel-save-btn"
			href="javascript:void(0)" class="easyui-linkbutton">取消</a>
	</div>

</body>
</html>