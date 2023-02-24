<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp" %>

<div class="container">
  <form>
  <input type="hidden" id="id" value="${principal.user.id }"/> 
  <div class="form-group">
    <label for="username">Username:</label>
    <input type="text" value="${principal.user.username}" class="form-control" placeholder="Enter username" id="username" readOnly>
  </div>
  <div class="form-group">
    <label for="password">Password:</label>
    <input type="password"  class="form-control" placeholder="Enter password" id="password">
  </div>
  <div class="form-group">
    <label for="email">Email:</label>
    <input type="email" value="${principal.user.email}" class="form-control" placeholder="Enter email" id="email">
  </div>
  <div class="form-group">
    <label for="address">Address:</label>
    <input type="text" value="${principal.user.address}" class="form-control" placeholder="Enter address" id="address">
  </div>
  
</form>
 <button id="btn-update" class="btn btn-primary">Edit User Information</button>
</div> 
<script src="/js/user.js "></script>
<%@include file="../layout/footer.jsp" %>