<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/8/2021
  Time: 9:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/create" method="post">
    <table>
        <tr>
            <td><input type="text" name="id" placeholder="nhập id"></td>
            <td><input type="text" name="name" placeholder="nhập name"></td>
            <td><input type="text" name="email" placeholder="nhập email"></td>
        </tr>

        <tr>
            <td>
                <button type="submit">Create Nhan viên</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
