<%@page import="com.lxisoft.domain.*"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%@page import="com.lxisoft.domain.*,com.lxisoft.config.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<%
  Localizer lo=new Localizer();
  String lang=(String)session.getAttribute("langu");
%>
<title><%=(lo.getWord("contact",lang,"IN"))%></title>
<body>
<a href="home"><input type="button" id="b2" value="<--"></a>
<%
Contact con=(Contact) request.getAttribute("getContactById");

%>
<font size="15">
<center><img src="user-icon-jpg-12.jpg" width="10%" height="10%"> 
<%=(con.getContactFirstName())%>
<%=(con.getContactLastName())%>
<%=(con.getContactNumber())%>
</font>
</body>
</html>
