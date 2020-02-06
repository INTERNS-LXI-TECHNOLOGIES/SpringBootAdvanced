<%@page import="com.lxisoft.domain.*,com.lxisoft.config.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

img.avatar {
  width: 10%;
  border-radius: 50%;
}

.container {
  padding: 90px;
}
/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  .cancelbtn {
     width: 100%;
  }
}
</style>
</head>
<body>
<%
  Localizer lo=new Localizer();
  String lang=(String)session.getAttribute("langu");
%>
<h2><%=(lo.getWord("LoginForm",lang,"IN"))%></h2>

<form action="j_security_check" method="post">
  <div class="imgcontainer">
    <img src="login.jpg" alt="Avatar" class="avatar">
  </div>

  <div class="container">
    <label for="uname"><b><%=(lo.getWord("username",lang,"IN"))%></b></label>
    <input type="text" name="j_username" required>

    <label for="psw"><b><%=(lo.getWord("password",lang,"IN"))%></b></label>
    <input type="password" name="j_password" required>
        
    <button type="submit"><%=(lo.getWord("Login",lang,"IN"))%></button>
  </div>

  <div class="container" style="background-color:#f1f1f1">
    <button onclick="window.history.back()"class="cancelbtn"><%=(lo.getWord("cancel",lang,"IN"))%></button>
  </div>
</form>

</body>
</html>