<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン画面</title>
</head>
<body>
<h1>ログイン</h1>

<form action="/userLogin" method="post">
<%-- <c:if test="${param.error}">名前またはパスワードが違います。</c:if> --%>
名前：<input type="text" name="name" placeholder="Username"
			required="required" autofocus="autofocus" >
パスワード：<input type="password" name="password" placeholder="Password"
			required="required">
<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
<input type="submit" value="ログイン">
</form>
<c:out value="${message}"/>
<a href="/userResistor">ユーザー登録</a>
<c:out value="${user.id}"/>
<c:out value="${user.name}"/>
</body>
</html>