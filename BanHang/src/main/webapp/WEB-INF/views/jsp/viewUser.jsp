<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value ='/resouce/css/style.css'></c:url>">
<script type="text/javascript"
	src="<c:url  value = '/resouce/js/main.js'></c:url>">
	
</script>
</head>
<body>
	<p>Thong tin nguoi dung</p>
	<p>Ten :${u.name}</p>
	<p>PassWord :${u.password}</p>
	<p>Id nguoi dung :${u.id}</p>
	<p>Gioi Tinh :${u.gender}</p>
	<p>Gioi Thieu :${u.about}</p>
	<p>Agreement :${u.acceptAgreement}</p>
	<p>So thich :</p>
	<c:forEach items="${u.favourites}" var="o">
		<p>${o}</p>
	</c:forEach>
	<p>Agreement :${u.avatar.getOriginalFilename()}</p>
</body>
</html>