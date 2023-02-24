<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal"/>
</sec:authorize> 

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Kim's Shop</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
 <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  
  <script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <a class="navbar-brand" href="/">Home </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
   <sec:authorize access="isAnonymous()"> 
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="/auth/loginForm">Login </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/auth/signupForm">Sign up</a>
      </li>  
    </ul>
    </sec:authorize>
    <sec:authorize access="hasRole('USER')">
    <ul class="navbar-nav">
    
      <li class="nav-item">
        <a class="nav-link" href="/user/updateForm">User Information</a>
      </li>  
       
        </ul>
        <ul class="navbar-nav ml-auto">
      
      <li class="nav-item">
        <a class="nav-link"  href="/cart">Cart</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/logout">Sign out</a>
        </li> 
    </ul>
    </sec:authorize>
   <sec:authorize access="hasRole('ADMIN')">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="/item/uploadForm">Upload</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/orderStatus">Order Status</a>
      </li> 
      </ul>
      <ul class="navbar-nav ml-auto">
      <li class="nav-item">
        <a class="nav-link" href="/user/updateForm">Admin Information</a>
      </li> 
       <li class="nav-item">
        <a class="nav-link" href="/logout">Sign out</a>
      </li> 
    </ul>
    </sec:authorize> 
   
  </div>  
</nav>
<br />