<%@ page import="java.util.ArrayList" %>
<%@ page import="customer.Customer" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28/7/2021
  Time: 3:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Danh sách khách hàng </title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  </head>
  <body>
  <div class="container">
    <h1>Customer List </h1>
    <table class="table">
      <thead>
      <tr>
        <th>Họ và tên</th>
        <th>Ngày Sinh</th>
        <th>Nơi ở</th>
        <th>Ảnh</th>
      </tr>
      </thead>
      <tbody>
      <% ArrayList<Customer> list =(ArrayList<Customer>) request.getAttribute("ListCustomer");
      String str ="";
      for(Customer x:list){
      str+="<tr><td> "+x.getName()+"</td><td>"+x.getAge()+"</td> <td> "+x.getAddress()+"</td><td> <img src='"+ x.getImg()+"' width='50' height='50' ></td></tr>";
      }
       out.println(str);
        %>
        /tbody>
    </table>
  </div>
  <a href="/CreateCustomer.jsp" class="btn btn-success"> Create Customer</a>
  </body>
</html>
