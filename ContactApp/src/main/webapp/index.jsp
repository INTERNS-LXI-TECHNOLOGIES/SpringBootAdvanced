<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.lxisoft.controller.*"%>
<%@page import="com.lxisoft.config.*"%>
<%@page import="com.lxisoft.domain.*"%>
<%@page import="com.lxisoft.model.*"%>
<%@page import="com.lxisoft.repository.*"%>
<%@page import="java.util.*"%>

<%International inter=new International();
	String lang=request.getParameter("lang");
		if(lang==null)
		{
			lang="en";
		}
	session.setAttribute("lang",lang);
%>
<html>
<title><%out.println(inter.getLocale("contactApp",lang,"IN"));%></title>
<body>
	<a href="?lang=en">english</a>
	<a href="?lang=ml">malayalam</a>	

	<center>
		<a href="<%=request.getContextPath()%>/showAll" style="color: black"><img src="Apps-Contacts-icon.png" width="100" height="100"><h3><%out.println(inter.getLocale("contactApp",lang,"IN"));%></h3></a>
	</center>
</body>
</html>




