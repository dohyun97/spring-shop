<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="../layout/header.jsp" %>

<div class="container">
<c:set var="totalPrice" value="${0}"/> 
 <c:forEach var="cartItem" items="${cart.cartItems}">
  <div class="card m-2">
  <div class="card-body">
    <h4 class="card-title">${cartItem.item.name}</h4>
    <p class="card-text">Price: ${cartItem.item.price}</p>
    <p class="card-text">Quantity: ${cartItem.amount}</p>
    <%-- <p class="card-text">cartId: ${cart.id}</p> --%>
  
    <button onclick="index.cartItemDelete(${cart.id},${cartItem.id })" class="btn btn-primary"> Delete </button>
    <c:set var="total" value="${cartItem.item.price * cartItem.amount }"/>
  <c:if test="${deletePrice != null}">
   <c:set var="totalPrice" value="${totalPrice+total-deletePrice}"/> 
  </c:if>
    <c:set var="totalPrice" value="${totalPrice+total}"/> 
  </div>
  </div>
 </c:forEach>
 <br/>
 <hr/>
 <div class="card-body d-flex justify-content-between">
 <input type="hidden" value="${totalPrice}" id="totalPrice"/>
 <div><h4>Total: $ ${totalPrice}</h4> </div>
 <c:choose>
 <c:when test= "${totalPrice >0 }">
 <div><a href="/cart/${cart.id}/checkout/${totalPrice}" class="btn btn-primary"> Check Out </a></div>
 </c:when>
 <c:otherwise>
 <div><a style="display:none" href="/cart/${cart.id}/checkout" class="btn btn-primary" > Check Out </a></div>
 </c:otherwise>
 </c:choose>
 </div>
 
 </div>
 <script src="/js/cart.js "></script> 
<%@include file="../layout/footer.jsp" %>


