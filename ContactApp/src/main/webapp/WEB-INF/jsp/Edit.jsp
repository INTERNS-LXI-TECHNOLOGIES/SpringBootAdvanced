<%@page import="com.lxisoft.controller.*"%>
<%@page import="com.lxisoft.domain.*"%>
<%@page import="com.lxisoft.config.*"%>
<%@page import="com.lxisoft.model.*"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.lxisoft.repository.*"%>
<%@page import="java.util.*"%>

  <%
	String lang=(String)session.getAttribute("lang");
	International inter=new International();
  %>
<!DOCTYPE html>
<html>
<head>
	<title><%out.println(inter.getLocale("edit",lang,"IN"));%></title>
	<center style="color: blue"><h1><b><%=inter.getLocale("edit",lang,"IN")%></b><h1></center>
</head>
<style type="text/css">
	#b3{
			background-color: red;
			font-size: larger;
		 float: right;	
		  margin: -54px 161px;
		}
	form{
    font-size: xx-large;
    margin: 79px
		}
	input{
			padding-right: 50px;
			padding-top: 10px;

		}
	#b1{
			
    background-color: blue;
    color: white;
    font-size: large;
	}
	#b2 {
			  background-color: red;
    color: white;
    font-size: large;
		}
	</style>
	<div>
		<button id="b3" onclick="window.location.href='<%=request.getContextPath()%>/index.jsp'"><%=inter.getLocale("close",lang,"IN")%>(X)</button>
	</div>

<body style="background-color:#E6EC73;">
	<div align="center">
	<form action="<%=request.getContextPath()%>/edit" method="post">
			<%=inter.getLocale("firstname",lang,"IN")%>:<input type="type" name="firstName" placeholder="enter first name to save"><br><br>
			<%=inter.getLocale("lastname",lang,"IN")%>:<input type="type" name="lastName" placeholder="enter last name to save"><br><br>
			<%=inter.getLocale("number",lang,"IN")%>:<input type="type" name="number" placeholder="enter new name"><br><br>
			<button id="b1" type="submit" ><%=inter.getLocale("confirm",lang,"IN")%></button><br><br><br>
	</form>
	<button id="b2"  onclick="onclick=goBack()"><%=inter.getLocale("back",lang,"IN")%></button>
	</div>

	<script type="text/javascript">
	function goBack() {
  	window.history.back();
	}
	</script>

</body>
</html>

