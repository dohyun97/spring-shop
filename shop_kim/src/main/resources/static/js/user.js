let index = {
	init: function(){
		$("#btn-save").on("click",()=>{
			this.save();
		}),
		$("#btn-update").on("click",()=>{
			this.update();
		})
	},
	save: function(){
		let data = {
			username:$("#username").val(),
			password:$("#password").val(),
			email:$("#email").val(),
			address:$("#address").val()
		};
		let error=$("#error").val();
		console.log(error);
		$.ajax({
			type:"POST",
			url:"/auth/signupProc",
			data:JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType:"json"
		}).done(resp => {
			if(resp.status === 500){
				alert(`${resp.data}`)
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
			email:$("#email").val(),
			address:$("#address").val()
		};
		$.ajax({
			type:"PUT",
			url:"/user",
			data:JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType:"json"
		}).done(resp => {
			if(resp.status === 500){
				alert(`${resp.data}`)
			}else{
			alert("Your account has been successfully eidted!");
			//console.log(resp);
			location.href = "/";
			}
		}).fail(error => { 
			alert(JSON.stringify(error));
		});
	}
}
index.init();