<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帳簿一覧</title>
</head>
<body>
	<c:out value="${user.id}" />
	：
	<c:out value="${user.name}" />
	さん
	<h1>帳簿一覧</h1>
	<br>
	<form action="/banController/edit" method="post">
		<table border="1">
			<tr>
				<th>日付</th>
				<th>支出</th>
				<th>収入</th>
				<th>残高</th>
				<th>備考</th>
				<th>編集</th>
				<th>削除</th>
			</tr>
			<c:forEach var="bank" items="${bankList}">
				<tr>
					<td><c:out value="${bank.date}" /></td>
					<td><c:out value="${bank.spending}" />円</td>
					<td><c:out value="${bank.revenue}" />円</td>
					<td><c:out value="${bank.stock}" /> 円</td>
					<td><c:out value="${bank.memo}" /></td>
					<td><s:link herf="/banController/edit?useid="<c:out value="${bank.memo}"/>"">削除</s:link></td>
					<td><input type="button" name="delete" value="削除"></td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<a href="/myPage">マイページ</a>
</body>
</html>