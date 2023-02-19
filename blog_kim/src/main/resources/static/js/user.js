let index = {
	init: function(){
		$("#btn-save").on("click",()=>{
			this.save();
		}),
		/*$("#btn-login").on("click",()=>{
			this.login();
		});*/
		$("#btn-update").on("click",()=>{
			this.update();
		})
	}, 
	
	save: function(){
		let data = {
			username:$("#username").val(),
			password:$("#password").val(),
			email:$("#email").val()
		};
		$.ajax({
			type:"POST",
			url:"/auth/signupProc",
			data:JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType:"json"
		}).done(resp => {
			if(resp.status === 500){
				alert("Username has been alrady used. Please type other username")
			}else{
			alert("Your account has been successfully created!");
			//console.log(resp);
			location.href = "/";
			}
		}).fail(error => { 
			alert(JSON.stringify(error));
		});
	},
	update: function(){
		let data = {
			id:$("#id").val(),
			username:$("#username").val(),
			password:$("#password").val(),
			email:$("#email").val()
		};
		$.ajax({
			type:"PUT",
			url:"/user",
			data:JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType:"json"
		}).done(resp => {
			alert("Your account has been successfully eidted!");
			//console.log(resp);
			location.href = "/";
		}).fail(error => { 
			alert(JSON.stringify(error));
		});
	}
	/*login: function(){
		let data = {
			username:$("#username").val(),
			password:$("#password").val(),
			
		};
		$.ajax({
			type:"POST",
			url:"/api/user/login",
			data:JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType:"json"
		}).done(resp => {
			alert("Welcom "+data.username);
			//console.log(resp);
			location.href = "/";
		}).fail(error => {
			alert(JSON.stringify(error));
		});
	}*/
	
	
}

index.init();