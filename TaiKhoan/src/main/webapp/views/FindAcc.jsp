<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/7/2021
  Time: 9:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tìm kiếm theo id</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Table Account</h2>
    <form method="post">
        <table class="table">
            <tbody>
            <tr>
                <td>${acc.id}</td>
                <td>${acc.username}</td>
                <td>${acc.password}</td>
                <td>${acc.email}</td>
                <td><a href="/acc?action=edit&index=${loop.index}" class="btn btn-warning">Edit</a></td>
                <td><a href="/acc?action=delete&index=${loop.index}" class="btn btn-danger">Delete</a></td>
            </tr>
            </tbody>
        </table>
        <a href="/acc" type="submit" class="btn btn-success">Back</a>

    </form>
</div>

</body>
</html>
