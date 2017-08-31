function myFunction(){
		
		var x = $("#passWord").val();
		var y = $("#verificationPassword").val();
		
		if(x != y){
			
			$("#errorPass").html("password dont match");
			$("#errorPassvery").html("password dont match");
		}else{
			$("#errorPass").html("password match");
			$("#errorPassvery").html("password match");
		}
		
}

document.ready(function() {
	
	$("#verificationPassword").keyup(myFunction);
});
		
	
	
	

