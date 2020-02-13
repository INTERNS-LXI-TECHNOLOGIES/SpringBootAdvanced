<%@page import="com.lxisoft.controller.*"%>
<%@page import="com.lxisoft.domain.*"%>
<%@page import="com.lxisoft.config.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.lxisoft.model.*"%>
<%@page import="com.lxisoft.repository.*"%>
<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

  <%
	String lang=(String)session.getAttribute("lang");
	International inter=new International();
  %>
<!DOCTYPE html>
<html>
<head>
	<title><%out.println(inter.getLocale("select",lang,"IN"));%>(X)</title>
</head>
<body style="background-color:#E6EC73;">
	<style type="text/css">
		#b1,#b2{		
    background-color: blue;
    color: white;
    font-size: large;
	}
		#b3 {
			  background-color: red;
    color: white;
    font-size: large;
		}
		#b4{
			background-color: red;
			font-size: larger;
		 float: right;	
		 margin: -28px 161px;
		}
	</style>
	<div>
		<button id="b4" onclick="window.location.href='<%=request.getContextPath()%>/index.jsp'"><%out.println(inter.getLocale("close",lang,"IN"));%>(X)</button>
	</div>
	
	<div align="center">
		<h2 style="margin: 47px;">
			<img src="<%=request.getContextPath()%>/person.jpg" width="135" height="135">
		</h2>
	</div>
	<div align="center">
		<h1><%=inter.getLocale("id",lang,"IN")%>: ${contact.getId()}</h1>
		<h1><%=inter.getLocale("firstname",lang,"IN")%>: ${contact.getFName()}</h1>
		<h1><%=inter.getLocale("lastname",lang,"IN")%>: ${contact.getLName()}</h1>
		<h1><%=inter.getLocale("number",lang,"IN")%>: ${contact.getNumber()}</h1> 
	</div>

	<div align="center"> 
	<%-- 	<%
	if (request.isUserInRole("admin"))
	{	 %> --%>
			<form action="<%=request.getContextPath()%>/delete">
			 <input type="submit" id="b1" value="<%=inter.getLocale("delete",lang,"IN")%>" onclick="return confirm('Are you sure you want to delete?')" />
			</form><br>

			<button id="b2" onclick="window.location.href='<%=request.getContextPath()%>/editPage'"><%=inter.getLocale("edit",lang,"IN")%></button><br><br><br><br><br><br><br>	
		<%-- <%
	}
	%> --%>
	<button id="b3" onclick="goBack()"><%=inter.getLocale("back",lang,"IN")%></button>
		</div>
	<script type="text/javascript">
	function goBack() {
  	window.history.back();
	}
	</script>
</body>
</html>
