<!DOCTYPE html>
<html>
<head>
	<title>add new </title>
</head>
<body>
	<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<%@ page import="com.lxisoft.domain.*" %>
	<%@ page import="com.lxisoft.Models.*" %>
	<%@ page import="java.util.*" %>
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="messages" />
 
<html lang="${lang}">
	<% String name=(String) request.getAttribute("newcontacts"); 
		if(name!=null)
		{
	
		%>
		<script type="text/javascript">
			msg()
			function msg()
			{
				alert("<fmt:message key='label.Cexist' />");
			
			}			
		</script>			
		<% }
	%>
	<script type="text/javascript">
		function validateform()
		{
			var fname=document.form.firstname.value;  
			var lname=document.form.lastname.value;  
			var no=document.form.number.value;  

			if (fname=="" || fname==null) 
			{
				alert("First Name can't be blank");  
  				return false;  
			}
			if (lname=="" || lname==null) 
			{
				alert("Last Name can't be blank");  
  				return false;  
			}
			if(no.length<4)
			{
				alert("Number must be at least 4 characters long.");  
  				return false;  
			}

			
		}
	</script>


		<center>	<img src="<c:url value="/resources/smiley.gif" />" alt="Smiley face" width="42" height="42" ></center>
			<form name="form" action="createNewContact" onsubmit="return validateform()" method="get"><br><center>
			<input type="text" name="firstname" placeholder="<fmt:message key='label.fName' />"><font color="red">*</font><br><br>
			<input type="text" name="lastname" placeholder="<fmt:message key='label.lName' />"><font color="red">*</font><br><br>
			<input type="text" name="number" placeholder="<fmt:message key='label.phno' />"><font color="red">*</font><br><br>
			<button  type="submit" name="CREATE"><fmt:message key='label.submit' /></button></form>
			<button type="button" onClick="window.location.href='viewall';"><fmt:message key='label.back' /></button></center>
	
		
		
</body>
</html>