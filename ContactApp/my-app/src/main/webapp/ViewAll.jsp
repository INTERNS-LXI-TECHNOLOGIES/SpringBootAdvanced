<%@page import="com.lxisoft.Domain.*"%>
<%@page import="com.lxisoft.Model.*"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<title>CONTACTS </title>
<head>


</head>
<h1><center>CONTACT LIST</center></h1>
<body>
	<table align="center" border= "5" width="30%" border color= "red" bgcolor="yellow">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>NUMBER</th>
		</tr>


<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>

<a href="Add.jsp"><h1><center>ADD<center></h1></a>
	<form action = "Search" method = "post">
	  Name   : <input type="text" name="name"><br>
		  <input type="submit" value="SEARCH"></form>
	


 <c:forEach items="${contacts}" var="contact">
 
        <tr>
         <td>${contact.getId()}</td>
          <td>${contact.getName()}</td>
          <td>${contact.getNumber()}</td>
        </tr>
       </c:forEach> 
</table>
</body>
</html>
