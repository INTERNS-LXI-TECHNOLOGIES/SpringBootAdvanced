<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
<fmt:setLocale value="${locallang}" />
<fmt:setBundle basename="Messages" />
 
<!DOCTYPE html>
<html lang="${param.lang}">

<head>
	<style>
		table th,td 
	{	width: 60px;
		border: 1px solid black;

	}
	</style>
	<title>
		
	</title>
</head>

<body style="background: lightblue">
<%@page import = "com.lxisoft.servet.*"%>
<%@page import = "com.lxisoft.repository.*"%>
<%@page import = "com.lxisoft.sqlrepository.*"%>
<%@page import = "com.lxisoft.model.*,java.util.*"%>

<%String lang=(String)session.getAttribute("locallang");%>
<br><br>
<table align="center" style="border-collapse: collapse;">
	        <tr>
				<th style="font-family: fantasy;font size: 5px"><fmt:message key="label.id" /></th>
				<th style="font-family: fantasy;font size: 5px"><fmt:message key="label.firstname" /></th>
				<th style="font-family: fantasy;font size: 5px"><fmt:message key="label.lastname" /></th>
				<th style="font-family: fantasy;font size: 5px"><fmt:message key="label.number" /></th>
			</tr>

  <%
 	
    String temp =request.getParameter("temp");
    String temp1 =request.getParameter("temp1");
    String temp2 =request.getParameter("temp2");
    String temp3 =request.getParameter("temp3");
    session.setAttribute("firstname",temp1);
    session.setAttribute("lastname",temp2);
    session.setAttribute("number",temp3);
    %>
   

	<tr>
		<td><% out.println(temp);%></td>
		<td><% out.println(temp1);%></td>
		<td><% out.println(temp2);%></td>
		<td><% out.println(temp3);%></td>
	</tr>		
</table>
<center>

	<% if (request.isUserInRole("admin")) 
	{ %>
		   	<br><a href="Update.jsp?id=<%=temp%>"><input type="button" name="" value="EDIT">  </a> <br><br>
			<a href="Delete.jsp?id=<%=temp%>"><input type="button" name="" value=" DELETE">  </a>
    <%
     } %>
	
</center>
</body>
</html>