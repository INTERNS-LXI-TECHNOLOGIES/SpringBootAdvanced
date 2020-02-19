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
<%
  Localizer lo=new Localizer();
  String lang=(String)session.getAttribute("langu");
%>
<title><%=(lo.getWord("contacts",lang,"IN"))%></title>
</head>
<body>

    <div align="center">
        <h1><%=(lo.getWord("contactlist",lang,"IN"))%></h1>
        <h3>
           <a href="addcon"><input type="submit" name="submit" value="+" /></a>
        </h3>
        <form action= "sort" method="get">
			<select name="sort">
		    <option value="1"><%=(lo.getWord("byname",lang,"IN"))%></option>
		    <option value="2"><%=(lo.getWord("bynumber",lang,"IN"))%></option>
		    <option value="3"><%=(lo.getWord("byid",lang,"IN"))%></option>
		    <input type="submit" name="submit" value="<%=(lo.getWord("sort",lang,"IN"))%>"/>
		  </select>
		  </form>
		  <form action= "search" method="get">
			<table align="center" border="1" width="10%" height="5%" >
				<tr>
					<td><input type="text" name="name" placeholder="<%=(lo.getWord("search",lang,"IN"))%>"/>
				
					<a href="search"><input type="submit" value="<%=(lo.getWord("submit",lang,"IN"))%>"></a></td>
				</tr>
			</table>
		</form>
        <table border="1">
 
            <th><%=(lo.getWord("contacts",lang,"IN"))%></th>
          	<th>Action</th>
	 <c:forEach var="c" items="${listContact}">
	  <tr>
 
        <td>${c.contactFirstName} ${c.contactLastName}</td>
        <td>
        <a href="deleteContact?contact=${c}"><input type="submit" value="<%=(lo.getWord("delete",lang,"IN"))%>" /></a>
        <a href="editContact?contactId=${c.contactId}"><input type="submit" value="<%=(lo.getWord("edit",lang,"IN"))%>" /></a></td>
      </tr>
            </c:forEach>
<form action="Logout" method="post">
    <input type="submit" value="Logout">
</form>
</table>
</body>
</html>