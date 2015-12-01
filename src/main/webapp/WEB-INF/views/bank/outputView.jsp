<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
	<!-- 	<form action="/banController/edit" method="post"> -->
	<table border="1">
		<tr>
			<th>日付</th>
			<th>収入</th>
			<th>支出</th>
			<th>残高</th>
			<th>備考</th>
		</tr>
		<c:forEach var="bank" items="${bankList}">
			<tr>
				<td><c:out value="${bank.date}" /></td>
				<td><c:out value="${bank.revenue}" />円</td>
				<td><c:out value="${bank.spending}" />円</td>
				<td><c:out value="${bank.stock}" /> 円</td>
				<td><c:out value="${bank.memo}" /></td>
			</tr>
		</c:forEach>
	</table>
	<!-- 	</form> -->
	<form action="/banController/csvExport" method="post">
		<input type=hidden name="userid" value="<c:out value="${user.id}" />" />
		<input type="submit" value="CSV出力">
	</form>
	<!-- 	ファイルアップロード 　　　　-->
	<form action="uploadRecv" method="post" enctype="multipart/form-data">
		<input type=hidden name="userid" value="<c:out value="${user.id}" />" />
		<input type="file" name="file"><br> <input type="submit"
			value="送信">
	</form>



<%-- 	<form method="POST" action="Bank/SendMail"> --%>
		<!-- 		<input type="hidden" name="_from" value="tashi480@gmail.com" />  -->
		<!-- 		<input	type="hidden" name="_fromArias" value="園田威" /> -->
		<!-- 		 	<input type="hidden" name="_location" value="outputView.jsp" /> -->
		<!-- 	<input type="hidden" name="_subject" value="メッセージ送信" /> -->
		<!-- 		 送信先名：<input type="text"	name="name" size="30" /><br />  -->
		<!-- 		 送信先アドレス：<input type="text"	name="_to" size="30" /><br />  -->
		<!-- 		 メッセージ：<input type="text" name="message" size="100" /><br />  -->
<!-- 		<input type="submit" value="メール送信" /> -->
<%-- 	</form> --%>
	<a href="/myPage">マイページ</a>
</body>
</html>