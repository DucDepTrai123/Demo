<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Danh sach khach hang</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Ten</th>
			<th>SDT</th>
			<th>Chon</th>
		</tr>
		<c:forEach items="${users }" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.phone}</td>
				<td><a href="<c:url value ='/chi-tiet-nguoi-dung/${user.id}'/> ">Chi tiet nguoi dung</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>