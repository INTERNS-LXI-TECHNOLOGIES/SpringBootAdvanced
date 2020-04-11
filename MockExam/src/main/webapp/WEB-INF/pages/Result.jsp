<%@page contentType = "text/html;charset=UTF-8" pageEncoding = "UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page import="com.lxisoft.controllers.*"%>
<%@page import="com.lxisoft.models.*"%>
<!DOCTYPE html>
<html>
<head>
	<title>Result</title>
	<style>
  	div
  	{
  		padding-top: 50px;
  		padding-right: 30px;
  		padding-left: 80px;
  		padding-bottom: 50px;
  	}
  </style>
</head>
<div><font color="black">
<h1 align="center"><u>Result</u></h1>
<body background="aa.jpg">
<h1 align=center>
  
  <% int m=Integer.parseInt(session.getAttribute("mark").toString());
  out.println("Mark:"+m);
  %><br>
  <br>
  <%
  if(m>=5)
  {
	 out.println("PASSED");
  }
  else
  {
	 out.println("FAILED");	
  }%>
</h1>
</font>
<center><a href="index.jsp">Back</a></center>
</div>
</body>
</html>