function inputCheck() {
	$("#ageintcheck").empty();
	$("#namecheck").empty();
	$("#precheck").empty();
	$("#agecheck").empty();
	$("#sexcheck").empty();
	$("#sexcheck").empty();
	$("#sexcheck").empty();
	$("#hobbylistcheck").empty();
	$("#first_e_mail_check").empty();
	$("#hobbycheck").empty();
	$("#first_e_mail_empty_check").empty();
	var checkFlg = 0;
	if (document.input.name.value == "") {
		checkFlg++;
		console.log('名前必須チェック');
		$(function() {

			$("#namecheck").append('<span>名前を入力してください。</span>');
		});
	}
	if (document.input.prefectures.value == 0) {
		checkFlg++;
		console.log("住所を選択されておりません。");
		$(function() {

			$("#precheck").append('<span>住所を選択してください。</span>');
		});
	}
	if (document.input.age.value == "") {
		checkFlg++;
		console.log("年齢が入力されておりません。");
		$(function() {
			$("#agecheck").append('<span>年齢が入力されておりません</span>');
		});

	}
	var ageTest = /^[-]?[0-9]+(¥.[0-9]+)?$/;
	console.log(!ageTest.test(document.input.age.value));

	if (!ageTest.test(document.input.age.value)) {
		checkFlg++;
		console.log("年齢は半角の整数で入力してください。");
		$(function() {
			$("#ageintcheck").append('<span>年齢は半角の整数で入力してください。</span>');
		});
	}
	if (document.input.sex.value == "") {
		checkFlg++;
		console.log("性別が選択されておりません。");
		$(function() {
			$("#sexcheck").append('<span>性別が選択されておりません。</span>');
		});
	}
	if (document.input.first_e_mail.value == "") {
		checkFlg++;
		console.log("メールアドレスが入力されておりません。");
		$(function() {
			$("#first_e_mail_empty_check").append(
					'<span>メールアドレスが入力されておりません。</span>');
		});
	}
	var regexp = /^[A-Za-z0-9]{1}[A-Za-z0-9_.-]*@{1}[A-Za-z0-9_.-]{1,}\.[A-Za-z0-9]{1,}$/;
	console.log(!regexp.test(document.input.first_e_mail.value));
	console.log(document.input.first_e_mail.value);
	if (!regexp.test(document.input.first_e_mail.value)) {
		checkFlg++;
		console.log("メールアドレスが入力値として不正です。");
		$(function() {
			$("#first_e_mail_check").append('<span>メールアドレスが入力値として不正です。</span>');
		});
	}
	// if(document.input.last_e_mail.value.match(/[¥w¥.-]+¥.¥w{2,}$/)){
	// alert("メールアドレスのドメインが入力値として不正です。");
	// }
	// if(document.input.last_e_mail.value==""){
	// alert("メールアドレスのドメインが入力されておりません。");
	// }
	// 趣味のチェックボックスの選択制限
	var hobbyList = document.getElementsByName("hobby");
	var flgDownLimit = 0;
	var flgUpperLimit = 0;
	for (var int = 0; int < hobbyList.length; int++) {

		if (!hobbyList[int].checked) {
			flgDownLimit++;

			if (flgDownLimit == hobbyList.length) {
				checkFlg++;
				console.log("趣味はひとつ以上選択してください。");
				$(function() {
					$("#hobbycheck").append('<span>趣味はひとつ以上選択してください。</span>');
				});
			}

		}
		if (hobbyList[int].checked) {
			flgUpperLimit++;
			if (flgUpperLimit > 3) {
				checkFlg++;
				console.log("趣味の選択は3つまでです。");
				$(function() {
					$("#hobbylistcheck").append('<span>趣味の選択は3つまでです。</span>');
				});

				break;
			}
		}
	}
	console.log("checkFlg＝" + checkFlg);
	if (checkFlg > 0) {
		return;
	} else {
		document.input.method = "post";
		document.input.submit();
	}
}

// お客様フォームの戻るボタン
function questBack() {
	alert("questBackメソッドを使っている。");
	document.getElementById('inputResitId').method = "post";
	document.getElementById('inputResitId').action = "/banController/questionnaire";
	document.getElementById('inputResitId').submit();
}
//攻撃用スクリプト
function caveat() {


	
});




// 名前を検索表示させる。
function nameView() {
	if (document.getElementById('name').value == null
			|| document.getElementById('name').value == '') {
		return;
	}
	if (document.getElementById('userList1').value == null
			|| document.getElementById('userList1').value == '') {
		return;
	}
	var userList = document.getElementById('userList1').value;

	//名前の配列組みなおし
	var nameList = [];
	var b = '';
	var c = 'name=';
	var d = '';
	for (var int = 0; int < userList.length; int++) {
		// userListから一文字ずつ取り出して、ｂに入れる。
		b = b + userList[int];
		// ｂにｃが出現したらｃ以降の文字をひとつづつｄに詰める。
		if (b.indexOf(c) != -1) {
			// ｄに,がでてきたら、つめる作業を終了し、配列nameListにｄをpush
			if (userList[int] == ',') {
				b = '';
				nameList.push(d);
				d = '';
				continue;
			}
			if (userList[int] === '=') {
				continue;
			}
			d = d + userList[int];
		}
	}
	//名前の配列組みなおし
	var idList = [];
	var b = '';
	var c = 'id=';
	var d = '';
	for (var int = 0; int < userList.length; int++) {
		b = b + userList[int];
		if (b.indexOf(c) != -1) {
			if (userList[int] == ',') {
				b = '';
				idList.push(d);
				d = '';
				continue;
			}
			if (userList[int] === '=') {
				continue;
			}
			d = d + userList[int];
		}
	}
	//パスの配列組みなおし
	var passList = [];
	var b = '';
	var c = 'password=';
	var d = '';
	for (var int = 0; int < userList.length; int++) {
		b = b + userList[int];
		if (b.indexOf(c) != -1) {ｆｆ
			if (userList[int] == ')') {
				b = '';
				passList.push(d);
				d = '';
				continue;
			}
			if (userList[int] === '=') {
				continue;
			}
			d = d + userList[int];
		}
	}
	
	for (var int2 = 0; int2 < idList.length; int2++) {
		console.log(idList[int2] + ' ' + nameList[int2] + ' ' + passList[int2]);
	}
	return;
}
