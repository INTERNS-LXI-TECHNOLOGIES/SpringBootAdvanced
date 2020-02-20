



<html>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
		<%@ page isELIgnored="false"%>

		<fmt:setLocale value="${lang}"/>
		<fmt:setBundle basename="messages" />
		 
<title> <fmt:message key="label.contacts" /></title>
<head>

	<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles.css" />"><CENTER><font color="red" size="32"><b>  <fmt:message key="label.contacts" /></b></font></CENTER></head>
<body>
<%@ page import="com.lxisoft.contacts.domain.*" %>
<%@ page import="com.lxisoft.contacts.model.*" %>


<%@ page import="java.util.*" %>


<html lang="${lang}">




<% String userName=null;
if(request.getUserPrincipal()!=null){
userName= request.getUserPrincipal().getName();

}%>
<% if (userName!=null){ %>
<center><fmt:message key="label.welcome" /> <%=userName %></center>
<% }
else if (request.getUserPrincipal()==null){ %>
<center><fmt:message key="label.welcome" /> Guest</center>
<% } %>



<center><% if(request.isUserInRole("admin")){ %>
<a href="addnew" style="color: green; text-align: center;"><button >+</button></a>
<% }
else{ %>
<button onclick="denied()" >+</button></a>
<% } %> </center>
 
<script>
	
	function play()
	{
		var beep=new Audio();
		beep.src="song.mp3";
		beep.play();
	}
</script>
<script>
	function denied()
	{
		alert(<fmt:message key="label.AccessDenied" />);
		// <audio controls autoplay>  
  // <source src="song.mp3" type="audio/mpeg"></audio>  
	}
</script>
 <center>
<form action="search" method="GET"  align="center">
	<input  type="text"  align="center" name="user" placeholder="<fmt:message key='label.Entername' />">
	<button name="search" type="submit"><fmt:message key="label.search" /></button></form>

</center>
<% if(request.isUserInRole("admin")){  %>
<center><button  onclick="window.location.href='deleteAll';" ><fmt:message key="label.delete" /></button> <br></center>
<% }
else { %>
<center><button  onclick="denied()" ><fmt:message key="label.delete" /></button> <br></center>
	<% } %>
<center>
<form action="sort">
	<select name="sort">
		<option value="first"><fmt:message key="label.fName" /></option>
		<option value="last"><fmt:message key="label.lName" /></option>
		<option value="id">id</option>
		
	</select>
	<input type="submit" value="sort">
</form></center>
<br>

<br>
<center>
	<button onclick="window.location.href='viewall';"><fmt:message key="label.refresh" /></button>
	<button onclick="window.location.href='logout';"><fmt:message key="label.logout" /></button>
</center>
<center>
<a href="lang?lang=en">ENGLISH</a>
<a href="lang?lang=ml">മലയാളം</a>
	
</center>
<%ArrayList<String> s=new ArrayList<String>(); 
ArrayList<ViewListModel> contacts=new ArrayList <ViewListModel>();
contacts=(ArrayList <ViewListModel>)request.getAttribute("contacts"); %>

<% 	if(contacts.size()==0  ){ %>
<%	 out.println("<b><h1><CENTER>"+"no contact to show"+"</CENTER></h1></b>"); %> 

<% } else{%>

<br>
	<!-- <img src="dead.jpg" width="50" height="50"> -->
<div style="overflow-x: auto;">
<table align="center">
	<p><tr><th></th><th><h3>ID</h3></th>
		<th><h3>NAME</h3></th></p></tr>

	 <%  for (ViewListModel a: contacts){%>

	<tr>
		<td><img src="<c:url value="/resources/contact.png" />" width="50" height="50"  ></td>
		<td><font color=" grey" size="65"><%out.println(a.getId());%></font></td>
		<td><a href="search?user=<%=a.getFullName()%>"><font color=" green" size="65"><%out.println(a.getFirstName());%></font></td></a>
		<%  if(request.isUserInRole("admin")){ %>
		<td><a href="select?type=edit&name=<%=a.getFullName()%>"><fmt:message key="label.edit" /></a></td>
		<td><a href="select?name=<%=a.getFullName()%>&type=delete"><fmt:message key="label.del" /></a></td>
		<% }
		else { %>
		<td><button onclick="denied()"><fmt:message key="label.edit" /></button></td>
		<td><button onclick="denied()"><fmt:message key="label.del" /></button></td>
		<% } %>
		
	</tr>

	<%}%>
</table></div>

	<%}%>


</body>
</html>
