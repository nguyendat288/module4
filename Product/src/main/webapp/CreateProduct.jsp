<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28/7/2021
  Time: 11:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<form action="/product" method="post">
    <div class="container">
        <h2>Product Table</h2>
        <table class="table">
            <thead>
            <tr>
                <th>id</th>
                <th>Name</th>
                <th>Price</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><input placeholder="nhập id" name="id"></td>
                <td><input placeholder="nhập name" name="name"></td>
                <td><input placeholder="nhập price" name="price"></td>
            </tr>
            </tbody>
        </table>
    </div>
    <button type="submit" class="btn btn-success">Create</button>
</form>
</body>
</html>
