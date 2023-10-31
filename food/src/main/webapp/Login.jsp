<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>登录</title>
  <style>
    body {
        background: linear-gradient(#c6ffbd, #ffffff);
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        padding: 0;
    }
    
    .login-container {
      background-color: #fff;
      width: 33%;
      max-width: 400px;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);
      margin: auto;
      margin-top: 20vh;
    }
    
    .login-container h2 {
      text-align: center;
    }
    
    .login-container input[type="text"],
    .login-container input[type="password"] {
      width: 100%;
      padding: 10px;
      margin-bottom: 10px;
      border: 1px solid #ccc;
      border-radius: 5px;
    }
    
    .login-container button {
      width: 100%;
      padding: 10px;
      background-color: #4CAF50;
      color: #fff;
      border: none;
      border-radius: 3px;
      cursor: pointer;
    }
    
    .login-container button:hover {
      background-color: #45a049;
    }
    
    .login-container .register-link {
      text-align: center;
      margin-top: 10px;
    }
    
    .login-container .register-link a {
      color: #4CAF50;
      text-decoration: none;
    }
  </style>
</head>
<body>
  <div class="login-container">
    <form action="Userinfo/Login" method="get">
      <h2>登录</h2>
      <input name="usercode" id="usercode" type="text" placeholder="用户名" required>
      <input name="userpwd" id="userpwd" type="password" placeholder="密码" required>
      <button type="submit">登录</button>
    </form>
  </div>

</body>


</html>
