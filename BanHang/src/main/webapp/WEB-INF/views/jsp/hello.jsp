<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value ='/resouce/css/style.css'></c:url>">
<script type="text/javascript" src="<c:url  value = '/resouce/js/main.js'></c:url>">
</script>
</head>
<body>
<p>Hello ${msg }</p>
<p>id = ${id }</p>
<img  src="<c:url value ='/resouce/image/demo.png'/>" />
</body>
</html>