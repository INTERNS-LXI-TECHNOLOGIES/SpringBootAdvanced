<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en" dir="ltr">
<head>
	<meta charset="utf-8">
	<title>nav</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="https://kit.fontawesome.com/a076d05399.js"></script>
	<link type="text/css"  href="${pageContext.request.contextPath}/resources/css/instructions.css" rel="stylesheet">
</head>
<body background="${pageContext.request.contextPath}/resources/images/78.png">
<div class="wrapper fadeInDown">
<section class="container">
<nav>
	<label for="check" class="checkbtn"></label>
	<label class="logo">MockExam</label>
	<ul>
		<li><a href="javascript:document.getElementById('logout').submit()">LOGOUT</a></li>
		<li><a href="/jpa" class="active">HOME</a></li>
	</ul>
</nav>
  <br>
  <div class="center">
  <div class="login-header1">
  <h2>Read The Instructions Carefully !!!</h2>
  </div>
  <br>
  <br>
  <ol>
 <h2><font color="midnightblue"><li>mobile phones are not allowed</li></font> </h2>
 <h2><font color="MidnightBlue"><li>any malpractice wil lead to debar</li></font></h2>
 <h2><font color="MidnightBlue"><li>helps will be provided by invigilatores</li></font></h2>
 <h2><font color="MidnightBlue"><li>total time allowed is 20 minutes</li></font></h2>
 <h2><font color="MidnightBlue"><li>keep calm and be quiet</li></font></h2>
</ol>
<br>
<br>
  <form>
  <input type="hidden" name = "qcount" value = "0" >
  <input type="submit" formaction="exam" class="button button1" name="next" value="NEXT" >
</form>
<c:url value="/logout" var="logoutUrl" />
<form id="logout" action="${logoutUrl}" method="POST" >
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<c:if test="${pageContext.request.userPrincipal.name != null}">
</c:if>
</div>
</section>
</div>
</body>
</html>