<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>メニュー</title>
</head>
<body>
<c:out value="${user.id}"/>：
<c:out value="${user.name}"/>さん
<br>
<a href="/banController/bankOutputController?userid=<c:out value ="${user.id}"/>
">帳簿一覧</a>
<br>
<a href="/banController/bankInputController">入力画面</a>
<br>
<a href="/logout">ログアウト</a>
</body>
</html>