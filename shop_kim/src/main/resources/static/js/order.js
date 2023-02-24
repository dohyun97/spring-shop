let index = { 
	init: function(){
		$("#btn-order").on("click",()=>{
			this.save();
		})
		
	},
	save: function(){
		let data = {
			address:$("#address").val(),
			payment:$("#payment").val()
		};
		let cartId = $("#cart").val()
		console.log(cartId);
		$.ajax({
			type:"POST",
			url:`/api/cart/${cartId}/checkout`,
			data:JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType:"json"
		}).done(resp => {
			if(resp.status === 500){
				alert("Please type all")
			}else{
			alert("Thank you for order!");
			//console.log(resp);  
			location.href = "/";
			}
		}).fail(error => { 
			alert(JSON.stringify(error));
		});
	}
	
	
}
index.init();