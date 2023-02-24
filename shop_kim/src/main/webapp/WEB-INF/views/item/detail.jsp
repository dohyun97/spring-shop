<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp" %>

<div class="container">
   <button class="btn btn-secondary" onclick="history.back()">Go Back</button>
    
   <c:if test="${item.user.id == principal.user.id }">
   <a href="/item/${item.id}/updateForm"  class="btn btn-warning">Edit</a>
   <button id="btn-delete"class="btn btn-danger">Delete</button>
   </c:if>
   
   
   
   
   <br/><br/>
   <div>
        <h3>${item.name}</h3>
       <span ><i>${item.status}</i></span>,
      Price: <i>${item.price}</i>
   </div>
   <br/>
   <c:if test="${item.user.id != principal.user.id }">
   <label for="cartItem-amount">Quantity:</label>
   <input type="number" value=1 min="1"  id="cartItem-amount">
  <button type="button" id="btn-cart-save" class="btn btn-primary">Add Cart</button>
  </c:if>
  <hr/>
  <div class="form-group">
   <div>${item.detail}</div>
   <hr/>
   <div class="card">
   <form>
   <input type="hidden" id="itemId" value="${item.id}"/> 
   <!-- <input type="hidden" id="userId" value="${principal.user.id}"/> -->
    <div class="card-body"><textarea id="review-content" class="form-control" rows="1"></textarea></div>
    <div class="card-footer"><button type="button" id="btn-review-save" class="btn btn-primary">Register</button></div>
    </form>
   </div>
   <br/>
   <div class="card">
     <div class="card-header">Review List</div>
     <ul id="reply-box"class="list-group">
       <c:forEach var="review" items="${item.reviews}">
        <li id="reply-${review.id}" class="list-group-item d-flex justify-content-between">
          <div>${review.content }</div>
            <div class="d-flex">
               <div class="font-italic">Writer: ${review.user.username}&nbsp;</div>
               <c:choose>
               <c:when test="${review.user.username == principal.user.username }">
               <button onClick="index.reviewDelete(${item.id},${review.id})"class="badge">Delete</button>
               </c:when>
               </c:choose>
           </div>
        </li>
        </c:forEach>
     </ul>
   </div>
</div>
  
 
</div>
<script src="/js/item.js "></script> 

<%@include file="../layout/footer.jsp" %>
