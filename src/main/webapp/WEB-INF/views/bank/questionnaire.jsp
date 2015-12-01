<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>お客様アンケートフォーム</title>
<script src="../../../js/a_sample.js">
</script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
</head>
<body>
<h3>お客様フォーム</h3>
<font color="red">※すべての項目は必須項目です。</font>
<form:form name="input" action="/banController/questionnaireResistor"
 modelAttribute="customerForm" >
<table border="1">
<tr>
<td>名前</td>
<td><form:input  path="name" value="${customerResistorPage.name}"/>
<div id="namecheck"></div></td>
</tr>
<tr>
<tr>
<td>
住所<br>
都道府県</td>
<td><form:select path="prefectures" value="${customerResistorPage.prefectures}" 
>
			<form:options items="${customerResistorPage.prefectureMap}" />
		</form:select><div id="precheck"></div>
		</td>
</tr>
<tr>
<td>年齢</td>
<td><form:input type="text" path="age" value="${customerResistorPage.age}"/>歳<div id="agecheck"></div><br><div id="ageintcheck"></div></td>
</tr>
<tr>
<td>性別</td>
<td><form:radiobuttons  path="sex" items="${customerResistorPage.sexList}" itemLabel="sex" itemValue="sex_id"  delimiter="<br>" value="${customerResistorPage.sex}"/>
<div id="sexcheck"></div>
</td>
</tr>
<tr>
<td>メールアドレス：</td>
<td><form:input path="first_e_mail" value="${customerResistorPage.first_e_mail}"/>
<div id="first_e_mail_empty_check"></div>
<br>
<div id="first_e_mail_check"></div>
</td>
</tr>
<tr>
<td>趣味<br>※３つまで選択可能</td>
<td>
<form:checkboxes  path="hobby" id="hobbyId" items="${customerResistorPage.hobbyMap}"  delimiter="<br>" 
value="${customerResistorPage.hobby}"/>
<div id="hobbycheck"></div>
<br>
<div id="hobbylistcheck"></div>
</td>
</tr>
</table>
<input type="button" value="送信" onclick="inputCheck();"/>
</form:form>

</body>
</html>