<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	<p>Form nguoi dung</p>
	<c:url value="/ducphi2" var="o"></c:url>
	<form:form modelAttribute="user" method="post" action="${o}" enctype="multipart/form-data"> 
		<p>Ten :</p>
		<form:input path="name" />
		<p style="color: red;">
			<form:errors path="name" />
		</p>
		<p>Password :</p>
		<form:password path="password" />
		<p style="color: red;">
			<form:errors path="password" />
		</p>
		<form:hidden path="id" />
		<p>So thich :</p>
		<form:checkbox path="favourites" value="Xem phim" label="Xem phim" />
		<form:checkbox path="favourites" value="Da bong" label="Da bong" />
		<form:checkbox path="favourites" value="Choi Game" label="Choi Game" />
		<p>Gioi Tinh :</p>
		<form:select path="gender">
			<form:option value="Nam">Nam</form:option>
			<form:option value="Nu">Nu</form:option>
		</form:select>
		<p>Gioi Thieu :</p>
		<form:textarea path="about" />
		<br>
		<form:radiobutton path="acceptAgreement" value="true"
			label="Dong Y Dieu Khoan Su Dung" />
		<br>
		<form:input path="avatar" type="file"/>
		<br>
		<button type="submit">Submit</button>
	</form:form>
</body>
</html>