<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/7/2021
  Time: 9:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa tài khoản</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Table Edit Account</h2>
    <form method="post">
        <table class="table">
            <tbody>
            <tr>
                <td><input placeholder="Enter the id" name="id" value="${acc.id}" readonly></td>
                <td><input placeholder="Enter the username" name="username" value="${acc.username}"></td>
                <td><input placeholder="Enter the password" name="password" value="${acc.password}"></td>
                <td><input placeholder="Enter the email" name="email" value="${acc.email}"></td>
            </tr>

            </tbody>
        </table>
        <button type="submit" class="btn btn-success">Edit Account</button>

    </form>
</div>
</body>
</html>
