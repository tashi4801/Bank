function set() {
	alert("test");
window.opener.document.getElementById("t1").value = document.getElementById("t1").value;
window.opener.winCloseB();


}


$(function() {
	alert("searchAddress.js 読み込みOK");
	
	//ロード時
	$(document).ready(
			function() {
			
			});
	
	//
	$("#zipaddr").click(function() {
		searchAddressNumber();
	});
});



//html生成用
function searchAddressNumber(){

	var zipcode =$('#zipcode').val();
	
	var json = {
	        "zipcode" : zipcode,
	          };
	
	
	$.ajax({
		type : "POST",
		url : "http://api.zipaddress.net/?zipcode="+zipcode,
		dataType : "jsonp",
		contentType: 'application/json', 
		data: JSON.stringify(json),
		success : function(data) {
			alert("zipcode" + zipcode);
			
			alert(data.pref);
			/*alert(data.address);*/
			alert(data.fullAddress);
			
			$(':text[name="a"]').val(data.fullAddress);
			
			/*successHtml(data);*/
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			error(XMLHttpRequest, textStatus, errorThrown);
		}
	});
}




//Ajax通信失敗時処理
function error(XMLHttpRequest, textStatus, errorThrown) {
	alert("error:" + XMLHttpRequest);
	alert("status:" + textStatus);
	alert("errorThrown:" + errorThrown);
}


