  
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="java.io.IOException,java.io.InputStream,java.util.*,com.lxisoft.config.*,javax.servlet.http.*"%>
<html>
<head>
<title>CONTACT APP</title>
<body>
<a href="?lang=en">English</a>
<a href="?lang=ml">Malayalam</a>
<%
String lang=request.getParameter("lang");
if(lang==null)
{
 lang="en";
}
session.setAttribute("langu",lang);
Localizer lo=new Localizer();
%>
<a href="home"><center><%=(lo.getWord("contactapp",lang,"IN"))%></center></a>
</body>
</head>
</html>