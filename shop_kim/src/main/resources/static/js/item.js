let index = { 
	init: function(){
		$("#btn-save").on("click",()=>{
			this.save();
		}),
		$("#btn-update").on("click",()=>{
			this.update();
		}),
		$("#btn-delete").on("click",()=>{
			this.deleteById();
		}),
		$("#btn-review-save").on("click",()=>{
			this.reviewSave ();
		}),
		$("#btn-cart-save").on("click",()=>{
			this.cartSave ();
		})  
	},
	save: function(){
		let data = {
			name:$("#name").val(),
			status:$("#status").val(),
			price:$("#price").val(),
			amount:$("#amount").val(),
			detail:$("#detail").val()
		};
		
		$.ajax({
			type:"POST",
			url:"/api/item",
			data:JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType:"json"
		}).done(resp => {
			if(resp.status === 500){
				alert(`${resp.data}`)
			}else{
			alert("Your item has been successfully registered!");
			//console.log(resp);  
			location.href = "/";
			}
		}).fail(error => { 
			alert(JSON.stringify(error));
		});
	},
	update : function(){
		
		let id=$("#id").val();
		let data = {
			name:$("#name").val(),
			status:$("#status").val(),
			price:$("#price").val(),
			amount:$("#amount").val(),
			detail:$("#detail").val()
			
		}; 
		
		
		$.ajax({
			type:"PUT",
			url:"/api/item/"+id,
			data:JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType:"json"
		}).done(resp => {
			
			alert("Your item has been successfully edited !");
			//console.log(resp);  
			location.href = "/";
			
		}).fail(error => { 
			alert(JSON.stringify(error));
		});
	},
	deleteById : function(){
		let  id = $("#itemId").val();
		$.ajax({
			type:"DELETE",
			url:"/api/item/"+id,
			dataType:"json"
		}).done(resp => {
			alert("Your item has been successfully deleted !");
			location.href = "/";
		}).fail(error => { 
			alert(JSON.stringify(error));
		});
	},
	reviewSave: function(){
		let data = {
			content:$("#review-content").val(), 
			
			
		};
		let itemId=$("#itemId").val();
		

		$.ajax({
			type:"POST",
			url:`/api/item/${itemId}/review`,   
			data:JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType:"json"
		}).done(resp => {
			alert("Your comment  has been successfully added!");
			//console.log(resp);  
			location.href =`/item/${itemId}`; 
		}).fail(error => { 
			alert(JSON.stringify(error));
		});
	},
	reviewDelete: function(itemId,reviewId){
		
		
        
		$.ajax({
			type:"DELETE",
			url:`/api/item/${itemId}/review/${reviewId}`,  
			 dataType:"json"
		}).done(resp => {
			alert("Your comment  has been successfully deleted !");
			//console.log(resp);  
			location.href =`/item/${itemId}`; 
		}).fail(error => { 
			alert(JSON.stringify(error));
		});
	},
	cartSave: function(){
		let data = {
		     amount:$("#cartItem-amount").val(), 
			 
			
		};
		let itemId=$("#itemId").val();
		
		if(data.amount<1){
			alert("Quantity should be at least one");
		}

		$.ajax({
			type:"POST",
			url:`/api/item/${itemId}/addcart`,   
			data:JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType:"json"
		}).done(resp => {
			if(resp.status === 500){
				
			}else{
			alert("Item has been successfully added! Please check your cart");
			//console.log(resp);  
			location.href =`/item/${itemId}`; 
			}
		}).fail(error => { 
			alert(JSON.stringify(error));
		});
	},
	
}
index.init();