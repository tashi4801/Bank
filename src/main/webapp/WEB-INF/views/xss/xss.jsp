<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>登録画面</title>
</head>
<body>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>



<h1>XSSの脆弱性が潜む掲示板</h1>
	<c:out value="${user.id}" />：
	<c:out value="${user.name}" />
	さん
	<form:form action="/output" method="post" modelAttribute="xssForm" >
		内容：
		<form:textarea path="xs_text"></form:textarea>
		<br>
		<form:hidden  path="userid" value="${user.id}"/>
		<input type="submit" value="書き込み" />
	</form:form>
	<a href="/myPage">マイページ</a>
	<br>
	<c:forEach var="xss" items="${xssList}">
		ID：${xss.userid}
		<br>
		名前：${xss.name}
		<br>
		内容：${xss.xs_text}
		<br>
		<hr>
		</c:forEach>

</body>
</html>