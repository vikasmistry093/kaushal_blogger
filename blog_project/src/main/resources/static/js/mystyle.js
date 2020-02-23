function callSignUp() {
	window.location = "/signup";
}

function validatePassword() {
	if(document.getElementById('currentPwd').value != document.getElementById('newPwd').value){
		console.log("Inside true block");
		return true;
	}else{
		alert("Current and New password are same!");
		console.log("Inside false block");
		return false;
	}
}