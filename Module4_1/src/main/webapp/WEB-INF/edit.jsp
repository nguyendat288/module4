<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/8/2021
  Time: 9:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <td><input type="text" name="id" value="${customer.id}" readonly ></td>
            <td><input type="text" name="name" value="${customer.name}"></td>
            <td><input type="text" name="email" value="${customer.email}"></td>
        </tr>
        <tr>
            <td>
                <button type="submit">Edit Nhan viên</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
