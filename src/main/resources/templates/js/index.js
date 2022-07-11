var password = [];

window.onload = function () {
	init();

	$(".numberPad button").not("#submitButton").click(function(){
		passwordToArray($(this).val());
	});

	$("#submitButton").click(function(){
		sendPassword();
		getPassword();
	});
};

function passwordToArray(e) {
	if(e == "cancel"){
		password.pop();
	}else{
		password.push(e);
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

	var param = {
		password : $(password)
	}

	$.ajax({
		type:"GET",
		url:"/login",
		data: {password : "param"},

		success:function(){
			alert("전송 성공")
		},
		error:function(){
			alert("전송 실패")
		}
	});
}

