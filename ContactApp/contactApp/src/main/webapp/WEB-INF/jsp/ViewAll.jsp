<%@page import="com.lxisoft.domain.*"%>
<%@page import="com.lxisoft.model.*"%>
<%@page import="com.lxisoft.config.*"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%@page import="com.lxisoft.domain.*,com.lxisoft.config.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact App</title>
</head>
<body>
    <div align="center">
        <h1>Contact List</h1>
        <h3>
           <a href="addcon"><input type="submit" name="submit" value="add" /></a>
        </h3>
        <table border="1">
 
            <th>First Name</th>
            <th>Last Name</th>
            <th>Action</th>
          
	 <c:forEach var="c" items="${listContact}">
	  <tr>
 
        <td>${c.contactFirstName}</td>
        <td>${c.contactLastName}</td>
        <td>
        <a href="deleteContact?contactId=${c.contactId}">Delete</a>
        <a href="editContact?contactId=${c.contactId}">edit</a></td>
      </tr>
            </c:forEach>
<form action="Logout" method="post">
    <input type="submit" value="Logout">
</form>
</table>
</body>
</html>