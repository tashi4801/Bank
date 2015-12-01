<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>お客様アンケート登録</title>
<script src="../../../js/a_sample.js"></script>
</head>
<body>
<h3>お客様フォーム</h3>
<form:form id="inputResitId" name="inputResit" 
 modelAttribute="customerForm" >
<table border="1">
<tr>
<td>名前</td>
<td><c:out value="${customerResistorPage.name}"/> </td>
</tr>
<tr>
<tr>
<td>
住所<br>
都道府県</td>
<td>
<c:forEach var="prefectures" items="${customerResistorPage.prefectures}" varStatus="status">
<c:out value="${customerResistorPage.prefectureMap[prefectures]}"/>
</c:forEach>
		</td>
</tr>
<tr>
<td>年齢</td>
<td><c:out value="${customerResistorPage.age}"/>歳</td>
</tr>
<tr>
<td>性別</td>
<td>
<c:if test="${customerResistorPage.sex==1}">男</c:if>
<c:if test="${customerResistorPage.sex==2}">女</c:if>
</td>
</tr>
<tr>
<td>メールアドレス：</td>
<td><c:out value="${customerResistorPage.first_e_mail}"/></td>
</tr>
<tr>
<td>趣味</td>
<td>
<c:forEach var="hobby1"  items="${customerResistorPage.hobby}" varStatus="status">
<c:out value="${customerResistorPage.hobbyMap[hobby1]}"/>
<c:if test="${!status.last}">/</c:if>
</c:forEach>
</td>
</tr>
</table>
<br>
上記で登録しても宜しいでしょうか？
<form:hidden path="name" value="${customerResistorPage.name}"/>
<form:hidden path="prefectures" value="${customerResistorPage.prefectures}"/>
<form:hidden path="age" value="${customerResistorPage.age}"/>
<form:hidden path="sex" value="${customerResistorPage.sex}"/>
<form:hidden path="first_e_mail" value="${customerResistorPage.first_e_mail}"/>
<%-- <form:hidden path="last_e_mail" value="${customerResistorPage.last_e_mail}"/> --%>
<form:hidden path="hobby" id="hobbyBackId" value="${customerResistorPage.hobby}"/>
<form:hidden path="first_e_mail" value="${customerResistorPage.first_e_mail}"/>
<input type="button" value="送信" onclick="inputCheck();">
<input type="button" value="戻る" onclick="questBack();">
</form:form>
</body>
</html>