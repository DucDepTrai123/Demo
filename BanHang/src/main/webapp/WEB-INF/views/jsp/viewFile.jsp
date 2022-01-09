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
	<p>Thong tin File</p>
	<c:forEach  items="${files}" var="file">
	<p>Ten :${file.getOriginalFilename() }</p>
	</c:forEach>
	
</body>
</html>