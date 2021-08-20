<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28/7/2021
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm khách hàng </title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<form action="/customer" method="post">
    <div class="container">
        <h2>Product Table</h2>
        <table class="table">
            <thead>
            <tr>
                <th>Họ và tên</th>
                <th>Ngày sinh</th>
                <th>Nơi sống</th>
                <th>Ảnh</th>
            </tr>
            </thead>

            <tr>
                <td><input placeholder="Nhập học và tên" name="name"></td>
                <td><input placeholder="Nhập ngày sinh" name="age"></td>
                <td><input placeholder="Nhập Nơi sống" name="address"></td>
                <td><input placeholder="Nhập ảnh" name="img"></td>
            </tr>
        </table>
    </div>
    <button type="submit" class="btn btn-success">Create</button>
</form>
</body>
</html>
