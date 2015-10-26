<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>入力画面</title>
</head>
<body>
	<br>
	<c:out value="${user.id}" />
	：
	<c:out value="${user.name}" />
	さん
	<br>
	<form:form action="/banController/bankInput" modelAttribute="bankForm"
		method="post">
			<form:label path="date">日付：</form:label>
			<form:input type="date" path="date"/>
			<form:errors path="date" />
		<br>
		<form:select path="revenueSpending">
<%-- 			<form:option value="" selected>--</form:option> --%>
			<form:option value="1">収入</form:option>
			<form:option value="2">支出</form:option>
			<form:errors path="revenueSpending" />
		</form:select>
		<br> 
		<form:label path="money">金額：</form:label>
		<form:input path="money"
			/>円<br>
			<form:errors path="money" />
		
		<form:label path="memo">備考：</form:label>
		<form:input path="memo"/>
			<form:input type="hidden" path="userid"
			value="<c:out value ="${user.id}"/>" />
			<form:errors path="memo" />
		<input type="submit" value="入力">
	</form:form>
</body>
</html>