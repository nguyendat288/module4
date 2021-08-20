<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/8/2021
  Time: 10:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Caculator</title>
</head>
<body>
<h1>Caculator</h1>
<form action="/caculator" method="post">
<input type="number" name="a"> <input type="number" name="b">
<br>
<button type="submit" name="cal" value="add">  Add(+)  </button>
<button type="submit" name="cal" value="sub">  Sub(-)  </button>
<button type="submit" name="cal" value="mul">  Mul(*)  </button>
<button type="submit" name="cal" value="div">  Div(/)  </button>
    <br>
</form>
<h1>Result : ${result}</h1>
</body>
</html>
