<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/8/2021
  Time: 10:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Đăng Nhập</title>
    <link rel="stylesheet" type="text/css" href="abc.css">
<body>
<center>
    <div class="row">
        <div class="col-md-6 mx-auto p-0">
            <div class="card">
                <div class="login-box">
                    <div class="login-snip"> <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Login</label> <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>
                        <div class="login-space">
                            <div class="login">
                                <form action="/login">
                                    <div class="group"> <label for="user" class="label">Username</label> <input id="user" type="text" class="input" placeholder="Enter your username" name="username"> </div>
                                    <div class="group"> <label for="pass" class="label">Password</label> <input id="pass" type="password" class="input" data-type="password" placeholder="Enter your password" name="password"> </div>
                                    <div class="group"> <input id="check" type="checkbox" class="check" checked> <label for="check"><span class="icon"></span> Keep me Signed in</label> </div>
                                    <div class="group"> <input type="submit" class="button" value="Sign In"> </div>
                                </form>
                                <div class="hr"></div>
                                <div class="foot"> <a href="#">Forgot Password?</a> </div>
                            </div>
                            <div class="sign-up-form">

                                <form action="/login?action=create" method="post">
                                    <div class="group"> <label for="user" class="label">Username</label> <input id="user" type="text" class="input" placeholder="Create your Username" name="username"> </div>
                                    <div class="group"> <label for="pass" class="label">Password</label> <input id="pass" type="password" class="input" data-type="password" name="password" placeholder="Create your password"> </div>
                                    <div class="group"> <label for="pass" class="label">Repassword</label> <input id="pass" type="password" class="input" data-type="password" name="repassword" placeholder="Enter the repassword"> </div>
                                    <div class="group"> <label for="pass" class="label">Address</label> <input id="pass" type="password" class="input" data-type="password" name="address" placeholder="Enter the address"> </div>
                                    <div class="group"> <label for="pass" class="label">Email Address</label> <input id="pass" type="text" class="input" name="email" placeholder="Enter your email address"> </div>
                                    <font color="blue"> <p>Loại tài khoản : </p>
                                        <label><input name="hobby" value="travel" type="radio" checked/>Nhân viên</label> <br/>
                                        <label><input name="hobby" value="sport" type="radio"/>Khách hàng</label> <br/></font>
                                    <div class="group"> <input type="submit" class="button" value="Sign Up"> </div>
                                </form>


                                <div class="hr"></div>
                                <div class="foot"> <label for="tab-1">Already Member?</label> </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div></center>
</body>
</html>
