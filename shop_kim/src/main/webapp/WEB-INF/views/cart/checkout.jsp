<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp" %>
<div class="container">
<form >
   <h1>CheckOut Item  </h1>
   <br/>
  <input value = "${cartId}" id="cart" type="hidden"/>
   <div class="form-group" id="input-ready">
    <label for="payment">Payment Information:</label>
    <input type="text" class="form-control" placeholder="Type Payment information" id="payment">
  </div>
  
   <div class="form-group" id="input-ready">
    <label for="address">Shipping address:</label>
    <input type="text" class="form-control" value = "${principal.user.address }"  id="address">
     
  </div>
  <hr/>
  <div><h4>Total Price: ${totalPrice}</h4></div>
  
 
  
</form> 

<button id="btn-order" class="btn btn-primary">Order</button>  

</div>
<script src="/js/order.js "></script> 

<%@include file="../layout/footer.jsp" %>
