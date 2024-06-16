<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/baocao/login/Login.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="http://localhost:8080/baocao/login/Login.js"></script>
</head>
<body>
<div id="back">
  <div class="backRight"></div>
  <div class="backLeft"></div>
</div>

<div id="slideBox">
  <div class="topLayer">
    <div class="left">
      <div class="content">
        <h2>Sign Up</h2>
        <form action="/baocao/login?action=signup" method="post" >
          <div class="form-group">
            <input type="text" name="username" id=username  placeholder="username" required  />
            <input type="password" name="password" id="password " placeholder="password" required  />
            <input type="text" id="sdt"  name="sdt" placeholder="phone number" pattern="^(0|\+84)(3|5|7|8|9)([0-9]{8})$" title="Vui lòng nhập số điện thoại Việt Nam hợp lệ, bắt đầu bằng 0 hoặc +84 và theo sau là 9 chữ số." required>
            <input type="email" id="gmail" name="gmail" placeholder="gmail" required  />
          </div>
          <div class="form-group"></div>
          <div class="form-group"></div>
          <div class="form-group"></div>
          <button>Sign up</button>
        </form>


        <button id="goLeft" class="off">Login</button>
        
      </div>
    </div>
    <div class="right">
      <div class="content">
        <h2>Login</h2>
        <form method="post" action="login?action=login" >
          <div class="form-group">
            
            <input type="text" name="username" placeholder="user name" />
            
            <input type="text" name="password" placeholder="password"/>
          </div>
          
          <button id="login" type="submit">Login</button>
        </form>
        <button id="goRight" class="off">Sign Up</button>
      </div>
    </div>
  </div>
</div>

<!--Inspiration from: http://ertekinn.com/loginsignup/-->
</body>
</html>