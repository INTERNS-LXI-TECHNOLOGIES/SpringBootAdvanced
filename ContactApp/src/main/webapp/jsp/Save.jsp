<%@page import="com.lxisoft.controller.*"%>
<%@page import="com.lxisoft.domain.*"%>
<%@page import="com.lxisoft.config.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.lxisoft.model.*"%>
<%@page import="com.lxisoft.repository.*"%>
<%@page import="java.util.*"%>
  <%
	String lang=(String)session.getAttribute("lang");
	International inter=new International();
  %>
<html>
<title><%=inter.getLocale("save",lang,"IN")%></title>
<center style="color: blue"><h1><b><%=inter.getLocale("save",lang,"IN")%></b><h1></center>
<body style="background-color:#E6EC73;">
	<style>
		form{
			 text-align: center;
    font-size: xx-large;
    margin: 79px
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
				#b3{
			background-color: red;
			font-size: larger;
		 float: right;	
		  margin: -50px 75px;
		}
		input{
			padding-right: 50px;
			padding-top: 10px;
		}
	</style>

	<div>
		<button id="b3" onclick="window.location.href='index.jsp'"><%out.println(inter.getLocale("close",lang,"IN"));%>(X)</button>
	</div>

	<div >
		<form action="<%=request.getContextPath()%>/addContact" method="post">
			<%=inter.getLocale("firstname",lang,"IN")%>:<input type="type" name="firstName" placeholder="enter first name to save"><br><br>
			<%=inter.getLocale("lastname",lang,"IN")%>:<input type="type" name="lastName" placeholder="enter last name to save"><br><br>
			<%=inter.getLocale("number",lang,"IN")%>:<input type="type" name="number" placeholder="enter name to save"><br><br>
			<button id="b1" type="submit" ><%=inter.getLocale("save",lang,"IN")%></button><br><br>		
		</form>
		<center>
			<button id="b2"   onclick="onclick=goBack()"><%out.println(inter.getLocale("back",lang,"IN"));%></button>
		</center>
	</div>
		<script type="text/javascript">
	function goBack() {
  	window.history.back();
	}
</script>

</body>
</html>