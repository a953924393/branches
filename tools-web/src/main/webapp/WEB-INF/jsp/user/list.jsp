<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>列表</title>
</head>
<body>
<a href="/user/toadd">添加</a>
<table width="500">
	<tr>
		<th>编号</th>
		<th>用户名</th>
		<th>密码</th>
		<th>描述</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${list}" var="users">
		<tr>
			<td>${users.userId}</td>
			<td>${users.username }</td>
			<td>${users.password }</td>
			<td>${users.comment }</td>
			<td><a href="/user/toedit/${users.userId }">修改</a>&nbsp;<a href="/user/delete/${users.userId }">删除</a></td>
		</tr>
	</c:forEach>
	
</table>
</body>
</html>