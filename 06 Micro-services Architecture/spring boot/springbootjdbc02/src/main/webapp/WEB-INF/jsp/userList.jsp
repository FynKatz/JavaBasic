<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
</head>
<body>
	<table border="1" align="center" width="50%">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>password</th>
			<th>Age</th>
		</tr>
		<c:forEach items="${list }" var="user">
			<tr>
				<td>${user.id }</td>
				<td>${user.name }</td>
				<td>${user.password }</td>
				<td>${user.age }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>