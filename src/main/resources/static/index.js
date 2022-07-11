var password = new Array();
var pwLen = 0;
window.onload = function () {
	init();

	$(".numberPad button").not("#submitButton").click(function(){
	    passwordToArray($(this).val());
	});

	$("#submitButton").click(function(){
	  sendPassword();
	});
};

function passwordToArray(e) {
    if(pwLen <= 4){
        if(e == "cancel"){
            $(".dotPad span:last-child").remove();
            password.pop();
            if(pwLen > 0)
                pwLen--;
        }else{
            if(pwLen < 4){
                password.push(e);
                $(".dotPad").append("<span>***</span>");
                pwLen++;
            }
        }
    }
}

function getPassword(){
	for(var i in password){
		document.write(password[i] + " ");
	}
}

function init(){
	$(".numberPad button").attr("type", "button");
}

function sendPassword() {

    var passwordString = password.join("");
   	$.ajax({
		type:"post",
		url:"/check-member",
		contentType:"application/json",
		data : {"param" : passwordString},
		success:function(){
               location.href = "/join/login";
		},
		error:function(){
			$(".resultString").text("틀렸습니다.");
		}
	});
}

