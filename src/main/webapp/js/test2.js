$(function() {
	/*alert("test2.js 読み込みOK");*/
	
	//ロード時に初期化
	$(document).ready(
			function() {
			createHtml();
			});
	
	//オブジェクトで渡せるかテスト
	$("#ajax_btn22").click(function() {
		createjson();
	});
	
	//全件検索処理
	$("#ajax_btn2").click(function() {
		createHtml();
	});
	
	//絞り込み検索処理(test)
	$("#search_ajax_btn2").click(function() {
		searchCreateHtml();
	});
	
	// 登録 ボタンクリック
	$("#ajax_regist").click(function() {
		registCreateHtml();
	});
	
	// 絞り込み検索処理
	$("#ajax_search").click(function() {
		searchCreateHtml();
	});
	
	//タブ自動移動
	


	
	
});
	

	//html生成用
	function createHtml(){
		$("#output_data2").text("");
		$("#output_data1").text("");

		$.ajax({
			type : "GET",
			url : "ajaxHtml",
			dataType : "html",
			success : function(data) {

				successHtml(data);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				error(XMLHttpRequest, textStatus, errorThrown);
			}
		});
	}
	

	
	//html生成用登録処理
	function registCreateHtml(){
		var email = $('#email_').val();
		var name = $('#name').val();
		var password = $('#password').val();
		var address = $('#t1').val();

		 var json = {
			        "email" : email,
			        "name" : name,
			        "password" : password,
			        "address" : address,
			        };
		
		$.ajax({
			type : "POST",
			url : "registJson",
			dataType : "json",
			contentType: 'application/json', 
			data: JSON.stringify(json),
			success : function(data) {

				parseHtml();
				/*for (var cnt = 0; cnt < data.length; cnt++) {
					var tr = $('<tr/>');
					$('<td/>').text(data[cnt].email).appendTo(tr);
					$('<td/>').text(data[cnt].name).appendTo(tr);
					$('<td/>').text(data[cnt].password).appendTo(tr);
					$('#ajaxTable').append(tr);

				}*/
				/*Html();*/
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				error(XMLHttpRequest, textStatus, errorThrown);
			}
		});
	}
	
	
	
	
	//html生成用登録処理
	function searchCreateHtml(){
		var email = $('#email_2').val();
		

		 var json = {
			        "email" : email,
			        };
		
		$.ajax({
			type : "POST",
			url : "searchJson",
			dataType : "json",
			contentType: 'application/json', 
			data: JSON.stringify(json),
			success : function(data) {

				parseHtml2();
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				error(XMLHttpRequest, textStatus, errorThrown);
			}
		});
	}
	
	
	//HTML化
	function parseHtml(){
	    $.ajax({
	        type : "GET",
	        url : "ajaxHtml",
	        dataType : "html",
	        success : function(data) {
	            // 一覧生成
	        	$('#output_data3').html(data);
	        },
	        error : function(XMLHttpRequest, textStatus, errorThrown) {
	            error(XMLHttpRequest, textStatus, errorThrown);
	        }
	    });
	}
	
	
	
	
	
	
	
	//HTML化
	function parseHtml2(){
		var email = $('#email_2').val();
		

		 var json = {
			        "email" : email,
			        };

		$.ajax({
			type : "POST",
			url : "searchParseHtml",
			dataType : "html",
			contentType: 'application/json', 
			data: JSON.stringify(json),
			success : function(data) {
	            // 一覧生成
	        	$('#output_data3').html(data);
	        },
	        error : function(XMLHttpRequest, textStatus, errorThrown) {
	            error(XMLHttpRequest, textStatus, errorThrown);
	        }
	    });
	}

	
	//json生成用
	function createjson(){
		$("#output_data2").text("");
		$("#output_data1").text("");

		$.ajax({
			type : "GET",
			url : "ajaxTest",
			dataType : "json",
			success : function(data) {

				successJson(data);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				error(XMLHttpRequest, textStatus, errorThrown);
			}
		});
	}

// Ajax通信(HTML生成用)成功時処理
function successHtml(data) {
	/*alert("success:" + data);*/
	 $("#output_data1").text("");
	$("#output_data3").html(data);
/*	$("#output_data1").append(data.length + "件");*/
}

//Ajax通信(HTML生成用)成功時処理
function successSearchHtml(data) {
	/*alert("success:" + data);*/
	 $("#output_data1").text("");
	$("#output_data3").html(data);
/*	$("#output_data1").append(data.length + "件");*/
}


//Ajax通信(JSON生成用)成功時処理
function successJson(data) {
	/*alert("success:" + data);*/

	$("#output_data22").text("");

	/* while( table.rows[ 1 ] ) table.deleteRow( 1 ); */
	for (var cnt = 0; cnt < data.length; cnt++) {
		$("#output_data22").append("「メール:" + data[cnt].email + ",名前:" + data[cnt].name  + ",パスワード:" + data[cnt].password +"」\n" );
	}
	for (var cnt = 0; cnt < data.length; cnt++) {
		var tr = $('<tr/>');
		$('<td/>').text(data[cnt].email).appendTo(tr);
		$('<td/>').text(data[cnt].name).appendTo(tr);
		$('<td/>').text(data[cnt].password).appendTo(tr);
		$('#ajaxTable').append(tr);

	}
	$("#output_data1").append(cnt + "件");
}


function Html(){
    $.ajax({
        type : "GET",
        url : "ajaxHtmlSearch",
        dataType : "html",
        success : function(data) {
            // 一覧生成
            $('#output_data3').html(data);
        },
        error : function(XMLHttpRequest, textStatus, errorThrown) {
            error(XMLHttpRequest, textStatus, errorThrown);
        }
    });
}


// Ajax通信失敗時処理
function error(XMLHttpRequest, textStatus, errorThrown) {
	alert("error:" + XMLHttpRequest);
	alert("status:" + textStatus);
	alert("errorThrown:" + errorThrown);
}
