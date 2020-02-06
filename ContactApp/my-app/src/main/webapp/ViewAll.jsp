<%@page import="com.lxisoft.Domain.*"%>
<%@page import="com.lxisoft.Model.*"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
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
	

<%
ArrayList<Contact> c=(ArrayList<Contact>)request.getAttribute("contact");
for(int i=0;i<c.size();i++)
{
%>
	<tr>
		 <td><%=(c.get(i).getId())%> </td>
		 <td><%=(c.get(i).getName())%> </td>
		  <td><%=(c.get(i).getNumber())%> </td>
		  <%
		  	Contact co=new Contact();
		  	co=c.get(i);
		  	session.setAttribute("contact",co);
		    String urldel = "Delete?id=" + c.get(i).getId();
		  %>
		  <td><form action="Edit.jsp">
		  	<input type="hidden" name="id" value="<%=(c.get(i).getId())%>">
		  	<input type="submit" name="EDIT" value="EDIT"></form>
		  <td><a href="<%=urldel%>"><h4>DELETE</h4></a>
	</tr>
<%
}
%>
</table>
</body>
</html>
