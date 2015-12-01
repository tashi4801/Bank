<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>メール送信機能</title>
</head>
<body>
	<!-- 	メール送信 　　　　-->
	<form:form action="/send" modelAttribute="mailForm" method="post">
		<form:label path="subject"> タイトル：</form:label>
		<form:input path="subject" size="30"/>
		<br /> 
		<form:label path="to"> 送信先アドレス：</form:label>
		<form:input path="to" size="30" />
		<br /> 
		<form:label path="message">メッセージ：</form:label>
		  <form:input path="message" size="100" />
		<br />
		<input type="submit" value="メール送信">
	</form:form>
	
		<form:form action="/sendMiyahara" modelAttribute="mailForm" method="post">
		<input type="submit" value="メール送信">
	</form:form>
</body>
</html>