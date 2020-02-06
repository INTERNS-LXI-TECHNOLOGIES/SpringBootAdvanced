<%@page import="com.lxisoft.domain.*,com.lxisoft.config.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<style>
	table,th,td{
		border: 1px solid black;
		border-collapse: collapse;
	}
	th,td{
		padding: 15px;
	}
	table{
		width: 25%%;
		background-color: #f1f1c1;
	}
	input[type="submit"]
	{
		background-color: #4CAF50;
	 	border :none;
	    color: white;
	}
</style>
<body>
	<%
	  Localizer lo=new Localizer();
	  String lang=(String)session.getAttribute("langu");
	%>
	<title><%=(lo.getWord("addcontact",lang,"IN"))%></title>
	<table align="center" border="5" width="25%" height="25%">
		<caption><h1><center><%=(lo.getWord("newcontact",lang,"IN"))%></center></h1></caption>
	
		<form action= "add" method="post">
			<tr>
				<td><%=(lo.getWord("firstname",lang,"IN"))%><input type="text" name="first name"/></td>
			</tr>
			<tr>
				<td><%=(lo.getWord("lastname",lang,"IN"))%><input type="text" name="last name"/></td>
			</tr>
			<tr>
				<td><%=(lo.getWord("number",lang,"IN"))%><input type="text" name="number"/></td>
			</tr>			
			<tr>
				<td><a href="add"><input type="submit" value="<%=(lo.getWord("save",lang,"IN"))%>"/></a>
		</form>
				<a href="home"><input type="submit" value="<%=(lo.getWord("cancel",lang,"IN"))%>"/></a></td>
			</tr>

</body>
</head>
</html>