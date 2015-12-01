<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>入力確認画面</title>
</head>
<body>
	<c:out value="${user.id}" />
	：
	<c:out value="${user.name}" />
	さん,
	<br>
	<table border="1">
		<tr>
			<td>日付:</td>
			<td><c:out value="${bankResistPage.date}" /></td>
		</tr>
		<tr>
			<td>入力金額:</td>
			<td><c:out value="${bankResistPage.money}" />円</td>
		</tr>
		<tr>

			<td>収支：</td>
			<td><c:if test="${bankResistPage.revenueSpending==1}">収入</c:if>
				<c:if test="${bankResistPage.revenueSpending==2}">支出</c:if></td>
		</tr>
		<tr>
			<td>備考：</td>
			<td><c:out value="${bankResistPage.memo}" /></td>
		</tr>
		<tr>
		</tr>
	</table>
	 上記で登録しても宜しいでしょうか？
	<br>
	<form:form action="/banController/resist" modelAttribute="bankForm"
		method="post">
		<form:hidden path="date" value="${bankResistPage.date}" />
		<form:hidden path="revenueSpending"
			value="${bankResistPage.revenueSpending}" />
		<form:hidden path="money" value="${bankResistPage.money}" />
		<form:hidden path="memo" value="${bankResistPage.memo}" />
		<input type="submit" value="登録" />
	</form:form>
	<form:form action="/banController/bankInputController" modelAttribute="bankForm"
		method="post">
		<form:hidden path="date" value="${bankResistPage.date}" />
		<form:hidden path="revenueSpending"
			value="${bankResistPage.revenueSpending}" />
		<form:hidden path="money" value="${bankResistPage.money}" />
		<form:hidden path="memo" value="${bankResistPage.memo}" />
		<input type="submit" value="戻る" />
	</form:form>
</body>
</html>