let index={
	cartItemDelete: function(cartId,itemId){
		
       
        
		$.ajax({
			type:"DELETE",
			url:`/api/cart/${cartId}/item/${itemId}`,  
			 dataType:"json"
		}).done(resp => {
			alert("Item has been successfully deleted!");
			//console.log(resp);  
			location.href ="/cart"; 
		}).fail(error => { 
			alert(JSON.stringify(error));
		});
	}
}