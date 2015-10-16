<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<form action="/banController/bankInput" method="post">
				日付：<input type="date" name="date">
		<br> <select name="revenueSpending">
			<option value="1" selected>収入</option>
			<option value="2" selected>支出</option>
		</select><br> 金額：<input type="text" name="money">円<br> 備考：<input
			type="text" name="memo"><br>
			 <input type="hidden"
			name="userid" value="<c:out value ="${user.id}"/>"> <input
			type="submit" value="入力">
	</form>
</body>
</html>