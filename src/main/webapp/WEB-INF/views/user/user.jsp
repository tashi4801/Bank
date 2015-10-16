<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="UTF-8">
<title>登録画面</title>
</head>
<body>
	<form:form action="/userResistorController" method="post" modelAttribute="userForm">
		<form:label path="name">名前：</form:label>
		<form:input path="name" />
		<form:errors path="name" />
		<br>
		<form:label path="password">パスワード：</form:label>
		<form:input type="password" path="password" />
		<form:errors path="password" />
		<br>
		<input type="submit" value="登録" />
	</form:form>
</body>
</html>