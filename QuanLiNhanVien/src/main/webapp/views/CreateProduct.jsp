<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/8/2021
  Time: 3:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm sản phẩm</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Table Create Product</h2>
    <form action="/product?action=create" method="post">
        <table class="table">
            <tbody>
            <tr>
                <td><input placeholder="Enter the idsp" name="idsp"></td>
                <td><input placeholder="Enter the nameproduct" name="nameproduct"></td>
                <td><input placeholder="Enter the price" name="price"></td>
                <td><input placeholder="Enter the soluong" name="soluong"></td>
                <td><input placeholder="Enter the color" name="color"></td>
                <td><input placeholder="Enter the loaisp" name="loaisp"></td>
            </tr>

            </tbody>
        </table>
        <button type="submit" class="btn btn-success">Create Product</button>

    </form>
</div>
</body>
</html>
