<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
<fmt:setLocale value="${locallang}" />
<fmt:setBundle basename="Messages" />

<!DOCTYPE html>
<html lang="${param.lang}">
<head>
	<title>
		
	</title>
</head>
<body style="background: lightyellow">
   
<%@page import = "com.lxisoft.servlet.*"%>
<%@page import = "com.lxisoft.repository.*"%>
<%@page import = "com.lxisoft.sqlrepository.*"%>
<%@page import = "com.lxisoft.model.*,java.util.*"%>
<%String lang=(String)session.getAttribute("locallang");%>
<form action="Add" method="get">
	<center>
	<fmt:message key="label.enterfirstname" /> : <input type="text" name="firstname"><br><br>
	<fmt:message key="label.enterlastname" /> : <input type="text" name="lastname"><br><br>
	<fmt:message key="label.enternumber" /> : <input type="text" name="number"><br><br>
	<input type="submit" value="submit">
	</center>
</form>
</body>
</html>