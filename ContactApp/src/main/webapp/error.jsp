<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>something went wrong</title>
<link rel="stylesheet" type="css" href="jsp/styles.css">
</head>
		<body style="background-color:#d9e6f2"> 
		<fmt:setLocale value="${currentlocale}" />
		<fmt:setBundle basename="messages"/>
		<h5 align="center">Access Denied! Entered username or password incorrect Login Again!</h5>
				<br>
				<center><a href="Login.jsp">Login</a></center>
</body>
</html>