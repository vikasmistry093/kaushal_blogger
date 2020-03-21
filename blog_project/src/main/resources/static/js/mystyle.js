function callSignUp() {
	window.location = "/signup";
}

function callHome(){
	window.location = "/home";
}

function enableFields(){
	document.getElementById('title').disabled = false;
	document.getElementById('category').disabled = false;
	document.getElementById('description').disabled = false;
	document.getElementById('updatebutton').disabled = false;
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