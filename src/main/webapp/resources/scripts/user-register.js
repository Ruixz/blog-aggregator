$(document).ready(
		function() {
			$(".registrationForm").validate(
					{
						rules : {
							name : {
								required : true,
								minlength : 3
							},
							email : {
								required : true,
								email : true
							},
							password : {
								required : true,
								minlength : 3
							},
							password_again : {
								required : true,
								minlength : 3,
								equalTo : "#password"
							}
						},
						highlight : function(element) {
							$(element).closest('.form-group').removeClass(
									'has-success').addClass('has-error');
						},
						unhighlight : function(element) {
							$(element).closest('.form-group').removeClass(
									'has-error').addClass('has-success');
						}
					});
		});

//Ajax part
function loadXMLDoc() {
	var xmlhttp;
	var userName = document.getElementById("ajaxUserName").value;
	// alert(userName);
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			document.getElementById("ajaxResponse").innerHTML = xmlhttp.responseText;
		}
	};
	xmlhttp.open("GET", "ajaxSearchUser.htm?userName=" + userName, true);
	xmlhttp.send();
}
