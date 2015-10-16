/*テーブル行削除*/
$(document).ready(function() {
	  var addRow;
	  addRow = function () {
		  	var lastRow = $('#nameTable tbody > tr:last').after('<tr><td><input type="text" size="1"></td><td><input type="text" size="1"></td><td><input type="text" size="1"></td></tr>')
	  }

	  $('#removeRow').on('click', function() {
		 
			  $('table tr:last').remove();
			
	  });
	});

/*テーブル行追加*/
$(document).ready(function() {
	  var addRow;
	  addRow = function () {
		  	var lastRow = $('#nameTable tbody > tr:last').after('<tr><td><input type="text" size="2"></td><td><input type="text" size="6"></td><td><input type="text" size="7"></td></tr>')
	  }
	  $('#addRow').on('click', function() {
	    addRow();
	  });
	});


//データの読み込み
var getUserList = function() {
	alert("home.js読み込み");
$.ajax({
  method: 'get',
  url: 'insert',
  dataType: 'json'
}).done(function(data) {
  var i;
  $tbody.empty();
  for (i = 0; i < data.length; i++) {
    $tbody.append(JST['tr'](data[i]));
  }
}).fail(function(jqXHR, textStatus, errorThrown) {
    console.log(textStatus);
  });
};

//データの登録

$('#insert').on('click', function() {
	alert("home.js読み込みOK");
  var sendData = {
		  name: $('#name').val(),
		  email: $('#email').val(),
		  password: $('#password').val()
  };

  $.ajax({
    method: 'post',
    contentType: 'application/json;charset=utf-8',
    data: JSON.stringify(sendData),
    url: 'insert',
    dataType: 'json'
  }).done(function(data) {
    $('#name').val('');
    $('#email').val('');
    $('#password').val('');
    getUserList();
  }).fail(function(jqXHR, textStatus, errorThrown) {
    console.log(textStatus);
  });
});