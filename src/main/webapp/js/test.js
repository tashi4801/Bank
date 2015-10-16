var childWindow;

function winOpen1() {
childWindow = window.open('/address/index', 'winB', 'width=700, height=300, menubar=no, toolbar=no, scrollbars=yes');;
}

function winOpen2() {
var ret = window.showModalDialog("/home/home");
document.getElementById("t1").value = ret;
}

function winCloseB() {
childWindow.close();
}

function nextFrame(i, n, m) {
	if (i.value.length >= m) {
		i.form.elements[n].focus();
	}
}

$(function(){
alert("test.js読み込み完了");
    // 何かの値をPostしたいなら
    var hogeParam = "hoge";

    // おまじない
    Dropzone.autoDiscover = false;

    Dropzone.options.myAwesomeDropzone = {
        paramName : "file",         // input fileの名前
        parallelUploads:1,            // 1度に何ファイルずつアップロードするか
        acceptedFiles:'image/*',   // 画像だけアップロードしたい場合
        maxFiles:10,                      // 1度にアップロード出来るファイルの数
        maxFilesize:0.5,                // 1つのファイルの最大サイズ(1=1M)
        dictFileTooBig: "ファイルが大きすぎます。 ({{filesize}}MiB). 最大サイズ: {{maxFilesize}}MiB.",
        dictInvalidFileType: "画像ファイル以外です。",
        dictMaxFilesExceeded: "一度にアップロード出来るのは10ファイルまでです。",
    };
    // urlは実際に画像をアップロードさせるURLパスを入れる
    var myDropzone = new Dropzone("div#my-awesome-dropzone",{url:"my_api_upload_img.php"});
    // 何か値をpostしたい場合
    myDropzone.on("sending", function(file,xhr,formData) {
        formData.append("hoge", hogeParam);
    });
});
