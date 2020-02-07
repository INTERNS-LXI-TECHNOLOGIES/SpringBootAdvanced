<%@page import="com.lxisoft.domain.*"%>
<%@page import="com.lxisoft.model.*"%>
<%@page import="javax.servlet.http.*"%>
<%@page import="javax.servlet.*"%>
<%@page import="com.lxisoft.domain.*,com.lxisoft.config.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%
	  Localizer lo=new Localizer();
	  String lang=(String)session.getAttribute("langu");
	%>
	<title><%=(lo.getWord("editcontact",lang,"IN"))%></title>
</head>
<body style="background-color: grey">
<table align="center" border="5" width="25%" height="25%"  bgcolor="#3CBC8D">
		<caption><h1><center><%=(lo.getWord("editcontact",lang,"IN"))%></center></h1></caption>
		<%
		Contact c=(Contact)session.getAttribute("cont");
		%>
		<form action= "editContact" method="post">
			<input type="hidden" name="id" value="<%=(c.getContactId())%>"><br>
			<tr>
				<td><input type="text" name="first name" value="<%=(c.getContactFirstName())%>" /><br>
				<br><input type="text" name="last name"value="<%=(c.getContactLastName())%>"/><br>
				<br><input type="text" name="number" value="<%=(c.getContactNumber())%>" /><br>
				<br><input type="submit" value="<%=(lo.getWord("save",lang,"IN"))%>"/><br>
		</form>
		<button onclick="window.history.back()"><%=(lo.getWord("cancel",lang,"IN"))%></button>
			</tr>
</body>
</html>