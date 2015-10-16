<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>入力確認画面</title>
</head>
<body><c:out value="${user.id}"/>：
<c:out value="${user.name}"/>さん,
<c:out value ="${money}"/>円の<c:out value ="${message}"/>を承りました。
これで残高は<c:out value ="${bank.stock}"/>円になります。
<a href="/myPage">マイページ</a>
</body>
</html>