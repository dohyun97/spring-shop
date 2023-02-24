<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="layout/header.jsp" %>

<div class="container">
 <c:forEach var="item" items="${items.content}">
  <div class="card m-2 justify-content-center mx-auto" style="width:500px">
  
  
  <div class="card-body text-center bg-light">
    <h4 class="card-title">${item.name}</h4>
    <p class="card-text">Price: ${item.price}</p>
    <p class="card-text">${item.status}</p>
    <a href="/item/${item.id}" class="btn btn-primary"> Details </a>
 
  </div>
  
   
  </div>
</c:forEach>
 <ul class="pagination justify-content-center">
 <c:choose>
  <c:when test="${items.first}">
  <li class="page-item disabled"><a class="page-link" href="?page=${items.number-1}">Previous</a></li>
  </c:when>
  <c:otherwise>
  <li class="page-item"><a class="page-link" href="?page=${items.number-1}">Previous</a></li>
  </c:otherwise> 
 </c:choose>
 <c:choose>
  <c:when test="${items.last}">
  <li class="page-item disabled"><a class="page-link" href="?page=${items.number+1}">Next</a></li>
  </c:when>
  <c:otherwise>
  <li class="page-item"><a class="page-link"href="?page=${items.number+1}">Next</a></li>
  </c:otherwise> 
 </c:choose>
</ul> 
 </div>
 
<%@include file="layout/footer.jsp" %>


