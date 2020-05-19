<%-- <%@page contentType = "text/html;charset=UTF-8" pageEncoding = "UTF-8"%> --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.12/css/all.css" integrity="sha384-G0fIWCsCzJIMAVNQPfjH08cyYaUtMwjJwqiRKxxE/rx96Uroj1BtIQ6MLJuheaO9" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/Sample.css">
</head>
<body>
<div class="wrapper">
  <div class="login-text">
    <button class="cta"><i class="fas fa-chevron-down fa-1x"></i>^</button>
    <div class="text">
    <c:if test="${not empty error}"><div>${error}</div></c:if>
	<c:if test="${not empty message}"><div>${message}</div></c:if>
      <a href="">Login</a>
      <hr>
      <br>
      <form method="POST" name='login' action="<c:url value='/login' />">
      <input  type="text" placeholder="User Name " name="username">
      <br>
      <input type="password" placeholder="Password" name="password">
      <br>
      <button class="login-btn" type="submit">Login</button>
      <button formaction="Register.jsp" class="signup-btn">SignUp</button>
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
    </div>
  </div>
  <div class="call-text">
    <h1>Welcome to <span>MOCK</span> Exam</h1>
    </div>
</div>
<script type="text/javascript" src="Sample.js"></script>
</body>
</html>