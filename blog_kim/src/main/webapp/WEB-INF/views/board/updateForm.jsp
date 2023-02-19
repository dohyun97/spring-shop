<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp" %>

<div class="container">
   <form >
   <input type="hidden" id="id" value="${board.id}"/> 
  <div class="form-group">
    <label for="title">Title:</label>
    <input type="text" value="${board.title }" class="form-control" placeholder="Enter username" id="title">
  </div>
  
  <div class="form-group">
  <label for="content ">Content:</label>
  <textarea class="form-control summernote" rows="5" id="content">${board.content}</textarea> 
  
</div>
  
</form> 
<button id="btn-update" class="btn btn-primary">Update</button>  
</div>
<script>
      $('.summernote').summernote({
        placeholder: 'Hello Bootstrap 4',
        tabsize: 2,
        height: 300
      });
 </script>
<script src="/js/board.js "></script> 

<%@include file="../layout/footer.jsp" %>
