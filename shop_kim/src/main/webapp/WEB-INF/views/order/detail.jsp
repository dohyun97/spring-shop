<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp" %>

<body>

<div class="container">
  <h2>Order for all users</h2>
            
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>Order Id</th>
        <th>Item Id</th>
        <th>Item Name</th>
        <th>Item Price</th>
         <th>Item Amount</th>
        <th>Order Date</th>
        <th>User Id</th>
        <th>User Email</th>
        <th>Address</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="order" items="${orders.content }">
       <c:forEach var="orderItem" items="${order.orderItems }">
      <tr>
        <td>${order.id }</td>
        <td>${orderItem.id}</td>
        <td>${orderItem.item.name }</td>
        <td>${orderItem.item.price }</td>
        <td>${orderItem.amount }</td>
        <td>${order.createDate}</td>
        <td>${order.user.id}</td>
        <td>${order.user.email}</td>
        <td>${order.address}</td>
      </tr>
      </c:forEach>
      </c:forEach>
    </tbody>
  </table>
</div>

</body>



<%@include file="../layout/footer.jsp" %>
