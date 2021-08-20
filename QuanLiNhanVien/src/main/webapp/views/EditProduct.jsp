<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/8/2021
  Time: 3:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Table Edit Product</h2>
    <form method="post">
        <table class="table">
            <tbody>
            <tr>
                <td><input placeholder="Enter the idsp" name="idsp" value="${product.idsp}" readonly></td>
                <td><input placeholder="Enter the nameproduct" name="nameproduct" value="${product.nameproduct}"></td>
                <td><input placeholder="Enter the price" name="price" value="${product.price}"></td>
                <td><input placeholder="Enter the soluong" name="soluong" value="${product.soluong}"></td>
                <td><input placeholder="Enter the color" name="color" value="${product.color}"></td>
                <td><input placeholder="Enter the loaisp" name="loaisp" value="${product.loaisp}"></td>
            </tr>

            </tbody>
        </table>
        <button type="submit" class="btn btn-success">Edit Product</button>

    </form>
</div>
</body>
</html>
