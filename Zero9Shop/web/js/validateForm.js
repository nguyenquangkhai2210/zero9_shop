function validateForm() {

	var check = document.getElementById('gridCheck');
	var input = document.getElementsByClassName('form-control');
	var email = input[2].value;
	var password = input[1].value;
	var username = input[0].value;
	var fullname = input[3].value;
	var phone = input[4].value;
	var address =input[5].value;

	var patternEmail = /^\w+@\w+([.]\w{1,10}){1,2}$/;
	var patternPass = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])/; 
	var patternPhone = /^\d{9,12}$/;	


	if( !patternEmail.test(email) ){
		swal({
			title: "Error",
			text: "Your email is wrong format",
			icon: "error",
			button: "Try again!",

		});
		return false;
	}
	if(!patternPass.test(password) || password.length < 8){
		swal({
			title: "Error",
			text: "Password must include lower character, number and upper character and the length is greater than 8",
			icon: "error",
			button: "Try again!",
		});
		return false;
	}
	if(!patternPhone.test(phone)){
		swal({
			title: "Error",
			text: "Phone number is 9 to 12 digits",
			icon: "error",
			button: "Try again!",

		});
		return false;
	}
	if(fullname == ""){
		swal({
			title: "Error",
			text: "Name cannot be empty",
			icon: "error",
			button: "Try again!",

		});
		return false;
	}
	if(address == ""){
		swal({
			title: "Error",
			text: "Address cannot be empty",
			icon: "error",
			button: "Try again!",

		});
		return false;
	}
	if(check.checked == false){
		swal({
			title: "Error",
			text: "You must check 'Approve with us'",
			icon: "error",
			button: "Try again!",

		});
		return false;
	}
	
	return true;

}