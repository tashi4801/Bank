function TodoCtrl($scope) {
	alert("todo.js読み込み完了");
  $scope.todos = [];
  $scope.deleteTodos = [];
  
  $scope.addTodo = function() {
    $scope.todos.push({text:$scope.todoText, done:false});
    $scope.todoText = '';
  };
 
  //とりあえず今は使わない
/*  $scope.remaining = function() {
    var count = 0;
    angular.forEach($scope.todos, function(todo) {
      count += todo.done 
      ? 0 : 1;
    });
    return count;
  };*/
  
  $scope.deleted = function() {
    var oldTodos = $scope.todos;
    var deleteTodos = $scope.todos;
    
    $scope.todos = [];
    $scope.deleteTodos = [];
    //選択していないデータのみ表示
    angular.forEach(oldTodos, function(todo) {
      if (!todo.done) $scope.todos.push(todo);

    });
    angular.forEach(deleteTodos, function(todo) {
        if (todo.done) $scope.deleteTodos.push(deleteTodos);

      });
    
  };
}