var signin = function() {
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	
	axios({
	  method: 'POST',
	  url: '/signin',
	  responseType: 'application/json',
	  data:{
		  "username":username,
		  "password":password
	  }
	}).then(function (response) {
		debugger;
		if(response.status == 200 && 'OK' == response.data.code)
			window.location.href = '/';
	});
}