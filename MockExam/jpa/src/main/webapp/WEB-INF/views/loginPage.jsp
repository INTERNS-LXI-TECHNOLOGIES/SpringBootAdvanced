<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css"  href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">
</head>
<body>
	<div class="wrapper fadeInDown">
	<div class="login-header">
    <h1>MockExam</h1>
  </div>
   <div id="formContent">
    <!-- Tabs Titles -->
    <h2 class="active"> Sign In </h2>
    <h2 class="inactive underlineHover">Sign Up </h2>

    <!-- Icon -->
    <div class="fadeIn first">
    </div>
	
	<c:if test="${not empty error}"><div>${error}</div></c:if>
	<c:if test="${not empty message}"><div>${message}</div></c:if>

	<form name='login' action="<c:url value='/loginPage' />" method='post' modelAttribute="customer">
		 <input type="text" id="login" class="fadeIn second" name="username" placeholder="login" value=''>
      <input type="text" id="password" class="fadeIn third" name="password" placeholder="password">
      <input type="submit" name="submit" class="fadeIn fourth" value="Log In">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
	 <div id="formFooter">
      <a class="underlineHover" href="#">Forgot Password?</a>
    </div>
</div>
</div>
</body>
</html>