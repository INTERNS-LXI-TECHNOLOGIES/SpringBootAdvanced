<%@page import="com.lxisoft.controllers.*"%>
<%@page import="com.lxisoft.models.*"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
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
  <%int m=(int) session.getAttribute("mark");
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