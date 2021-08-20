<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/7/2021
  Time: 8:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách tài khoản</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">


    <h2>Show Account</h2>
    <a href="/acc?action=create" class="btn btn-success">Create</a>
    <br>
    <form action="/acc" method="get">
        <input type="text" placeholder="Enter the id you want to find" name ="findName">
        <input type="text" hidden name="action" value="findName">
        <button type="submit" class="btn btn-info">Find by name</button>
    </form>
    <br>
    <form action="/acc?action=find" method="post">
        <input type="text" placeholder="Enter the id you want to find" name ="idfind">
        <button class="btn btn-info" type="submit">Search by id</button>
    </form>
    <br>
    <br>
    <table class="table" border="2px">
        <thead>
        <tr>
            <th>id</th>
            <th>UserName</th>
            <th>PassWord</th>
            <th>Email</th>
            <th>Edit</th>
            <th>Delete</
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ListAcc}" var="acc" varStatus="loop">
            <tr>
                <td>${acc.id}</td>
                <td>${acc.username}</td>
                <td>${acc.password}</td>
                <td>${acc.email}</td>
                <td><a href="/acc?action=edit&index=${loop.index}" class="btn btn-warning">Edit</a></td>
                <td><a href="/acc?action=delete&index=${loop.index}" class="btn btn-danger">Delete</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <a href="/acc" type="submit" class="btn btn-success">Home</a>
</div>
</body>
</html>
