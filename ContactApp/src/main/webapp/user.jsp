<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>user</title>
</head>
<body bgcolor="#EBCFDA">
<%@ page import ="com.lxisoft.contacts.domain.*" %>
<%@ page import="com.lxisoft.contacts.model.*" %>
<%@ page import="java.util.*" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="messages" />
 
<html lang="${lang}">

<% Contact contact=(Contact) session.getAttribute("users"); %>
 
<script>
	function denied()
	{
		alert("access denied");
		
	}
</script>
<table class="table" border="2" align="CENTER" width="20%">
	<tr><th>ID</th><th>NAME</th><th>NUMBER</th></tr>
	<tr><td><%=contact.getId() %></td>
		<td><%=contact.getFullName() %> </td>
		<td><%=contact.getNo() %> </td>
		<% if(request.isUserInRole("admin")){ %>
		<td><a href="edit.jsp"><fmt:message key="label.edit" /></td>
		<td><a href="delete"><fmt:message key="label.del" /></td>
		<% } else { %>	
		<td><button onclick="denied()"><fmt:message key="label.edit" /></button></td>
		<td><button onclick="denied()"><fmt:message key="label.del" /></button></td>
		<% } %>
		<td><a href="viewall"><fmt:message key="label.back" /></td>
	</tr>


	</table>
</body>
</html>