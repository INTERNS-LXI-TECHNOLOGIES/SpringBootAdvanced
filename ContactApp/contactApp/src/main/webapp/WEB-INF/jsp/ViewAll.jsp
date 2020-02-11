<%@page import="com.lxisoft.domain.*"%>
<%@page import="com.lxisoft.model.*"%>
<%@page import="com.lxisoft.config.*"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%@page import="com.lxisoft.domain.*,com.lxisoft.config.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<html>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<style>
	#b1
	{
		background-color: green;
	    color: white;
	    margin: 8px 0;
	    border: none;
	    box-sizing: border-box;
	    width: 100;
	}
	#b2
	{
		background-color: #3CBC8D;
	    color: white;
	    margin-left: 1000px;
	    border-radius: 50%;
	    height: 5%; 
	    width: 3%;
	}
	#b3
	{
		background-color: black;
	 	border :none;
	    color: white;
	    height: 10%; 
	    width: 50%;
	}
</style>
<%
  Localizer lo=new Localizer();
  String lang=(String)session.getAttribute("langu");
%>
<title><%=(lo.getWord("contacts",lang,"IN"))%></title>
</head>

<h1><center><%=(lo.getWord("contactlist",lang,"IN"))%></center></h1>
<body style="background-color: white">
   
	<a href="addcon"><input type="submit" id="b2"name="submit" value="add" /></a>
	
	<form action= "sort" method="get">
	<select name="sort">
    <option value="1"><%=(lo.getWord("byname",lang,"IN"))%></option>
    <option value="2"><%=(lo.getWord("bynumber",lang,"IN"))%></option>
    <option value="3"><%=(lo.getWord("byid",lang,"IN"))%></option>
    <input type="submit" name="submit" value="<%=(lo.getWord("sort",lang,"IN"))%>"/>
  </select>
</form>
	 <c:forEach var="c" items="${listContact}">
	  <tr>
 
        <td>${c.contactFirstName}</td>
        <td>${c.contactLastName}</td>
      </tr>
            </c:forEach>
<form action="Logout" method="post">
    <input type="submit" value="Logout">
</form>
</table>
</body>
</html>