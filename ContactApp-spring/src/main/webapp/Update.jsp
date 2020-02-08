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
<body style="background:  lightblue">
  
   
<%@page import = "com.lxisoft.servlet.*"%>
<%@page import = "com.lxisoft.repository.*"%>
<%@page import = "com.lxisoft.sqlrepository.*"%>
<%@page import = "com.lxisoft.model.*,java.util.*"%>
<form action="Update" method="get">
    <%
    String firstname=(String)session.getAttribute("firstname");
    String lastname=(String)session.getAttribute("lastname");
    String number=(String)session.getAttribute("number");
    %>
	<center>
	<%String lang=(String)session.getAttribute("locallang");%>

	<fmt:message key="label.enterfirstname" /> : <input type="text" name="firstname" value="<%out.print(firstname);%>"><br><br>
	<fmt:message key="label.enterlastname" /> : <input type="text" name="lastname" value=" <%out.print(lastname);%>"><br><br>
	<fmt:message key="label.enternumber" />: <input type="text" name="number" value=" <%out.print(number);%>"><br><br>
	<% String id= request.getParameter("id");%>
	 <input type="hidden" name="id" value="<%=id%>">
	<input type="submit" value="submit">
	</center>
</form>
</body>
</html>