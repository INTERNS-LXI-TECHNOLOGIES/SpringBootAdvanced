<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>edit</title>
</head>
<body>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<%@ page import ="com.lxisoft.contacts.domain.*" %>
<%@ page import="com.lxisoft.contacts.model.*" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
 <% String lang=null; %>
 
<% Contact contact=(Contact) session.getAttribute("users"); %>
<% lang=(String) session.getAttribute("lang"); 

	if(lang=="ml")
	{
		%>
<fmt:setLocale value="ml"/>
<%	}
else
{
	%>
<fmt:setLocale value="en"/>
<%	
}

%>
<fmt:setBundle basename="messages" />


<form action="edit"><center>
	<input type="name" name="newFirstName" value="<%=contact.getFirstName()%>"><br><br>
	<input type="name" name="newLastName" value="<%=contact.getLastName()%>" ><br><br>
	<input type="number" name="newNo" value="<%=contact.getNo()%>"><br><br>
	
	<input type="submit" name="<fmt:message key='label.submit'/>"></center>
</form>
<center><button onclick="window.location.href='viewall';"><fmt:message key="label.back" /></button> </center>




</body>
</html>