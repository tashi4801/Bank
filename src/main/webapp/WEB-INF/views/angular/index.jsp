<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<html ng-app>
<head>
<link rel="stylesheet" type="text/css" href="../css/dropzone.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.13/angular.min.js"></script>
<script src="http://code.angularjs.org/1.2.3/angular-animate.min.js"></script>
<script type="text/javascript" src="../js/todo.js"></script>
<link rel="stylesheet" type="text/css" href="../todo.css" />
<title>home</title>
</head>
<body>
	<div
		ng-init="friends = [
      {name:'one'},
      {name:'two'},
      {name:'three'},
      {name:'four'},
      {name:'five'},
      {name:'six'},
      {name:'seven'},
      {name:'eight'},
      {name:'nine'},
      {name:'ten'}
    ]">
		検索: <input type="search" ng-model="q" placeholder="検索" />
		<ul class="example-animate-container">
			<li class="animate-repeat" ng-repeat="friend in friends | filter:q">
				{{friend.name}}</li>
		</ul>
	</div>


	<h2>Todo</h2>
	<div ng-controller="TodoCtrl">
		<span>残り:<!-- {{remaining()}}/ -->{{todos.length}}個
		</span> [ <a href="" ng-click="deleted()">完了</a> ]
		<form ng-submit="addTodo()">
			<input type="text" ng-model="todoText" size="30"
				placeholder="新しいTODOを追加"> <input class="btn-primary"
				type="submit" value="追加">
		</form>

		<ul class="unstyled">
			<li ng-repeat="todo in todos"><input type="checkbox"
				ng-model="todo.done"> <span>{{todo.text}}</span></li>
		</ul>



		<div>完了リスト</div>
		<div>
			<!--       	<div ng-repeat="todo in todos"> -->
			<!-- <div ng-repeat="deleteTodos in deleteTodos"> -->
			<!-- <input type="text" ng-model="todo.done"> -->
			<span>{{deleteTodos.text}}</span> <span>{{todo.text}}</span>


			<!-- <li ng-repeat="todo in todos"> -->

			<!--  <input type="checkbox" ng-model="todo.done"> -->
			<!-- <span class="done-{{todo.done}}">{{todo.text}}</span> -->
			<!-- </li> -->
		</div>
		<div>
			<!-- <div ng-repeat="todo in deleteTodos"> -->
			<span>{{deleteTodos.text}}</span>
		</div>
	</div>



</body>
</html>