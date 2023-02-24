<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp" %>

<div class="container">
   <form >
   <input type="hidden" id="id" value="${item.id}"/>
   <h1>Register Item</h1>
   <br/>
  <div class="form-group">
    <label for="name">Item Name:</label>
    <input type="text" value="${item.name}" class="form-control" placeholder="Enter item name" id="name">
  </div>
  <div  class="form-group"> 
    <select id="status" class="custom-select">
      <option value="AVAILABLE">Available</option>
      <option value="UNAVAILABLE">Unavailable</option>
    </select>
  </div>
  <div class="form-group">
    <label for="price">Item Price:</label>
    <input type="number" value="${item.price}"min="0" class="form-control" placeholder="Enter item price. Please write the number without $ sign" id="price">
  </div>
  <div class="form-group">
    <label for="amount">Item Quantity:</label>
    <input type="number" min="0" value="${item.amount }"class="form-control" placeholder="Enter item quantity" id="amount">
  </div>
  <div class="form-group">
  <label for="detail">Details:</label>
  <textarea class="form-control summernote" rows="5" id="detail">${item.detail }</textarea> 
  
</div>
  
</form> 
<button id="btn-update" class="btn btn-primary">Submit</button>  
</div>
<script>
      $('.summernote').summernote({
        placeholder: 'Write details of item',
        tabsize: 2,
        height: 300
      });
 </script>
<script src="/js/item.js "></script> 

<%@include file="../layout/footer.jsp" %>
