<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
<fmt:setLocale value="${locallang}" />
<fmt:setBundle basename="Messages" />
 
<!DOCTYPE html>
<html lang="${param.lang}">

<head>
	<style>
.button{
			  background-color: #FF0000;
			  color: white;
			  text-align: center;
			  text-decoration: none;
			  display: inline-block;
			  cursor: pointer;

       }
	table th,td 
	{	width: 5px;
		border:2px solid black;

	}
</style> 
	<title>
		SEARCH
	</title>
</head>
<body button style ="background: lightblue">

<%@page import = "com.lxisoft.servet.*"%>
<%@page import = "com.lxisoft.repository.*"%>
<%@page import = "com.lxisoft.sqlrepository.*"%>
<%@page import = "com.lxisoft.model.*,java.util.*"%><br><br>

 <%String lang=(String)session.getAttribute("locallang");
 ArrayList<Contact> contactList=(ArrayList<Contact>) request.getAttribute("searchList");
if(contactList.size()==0)
    { %>
     <center>
     <p><b>NO CONTACTS TO DISPLAY</p></b><br>
     <a href="Display"> press here to Go back</a>    	
     </center>
   <% } 
  else 
{ %>
	<table align="center" style="border-collapse: collapse;">
	        <tr>
				<th style="font-family: fantasy;font size: 5px"><fmt:message key="label.id" /></th>
				<th style="font-family: fantasy;font size: 5px"><fmt:message key="label.firstname" /></th>
				<th style="font-family: fantasy;font size: 5px"><fmt:message key="label.lastname" /></th>
				<th style="font-family: fantasy;font size: 5px"><fmt:message key="label.number" /></th>
				<% if (request.isUserInRole("admin")) 
				{ %>				
				<th style="font-family: fantasy;font size: 5px"><fmt:message key="label.options" /></th>
				<% } %>
			</tr>
<%}
	for(Contact i: contactList)
		{ %>
			<b>

			<tr style=" font-style:oblique;">
			<td><%out.println(i.getId());%></td>
			<td><%out.println(i.getFirstname());%></td>
			<td><%out.println(i.getLastname());%></td>
			<td><%out.println(i.getNumber());%></td>
			<center>
				<% if (request.isUserInRole("admin")) { %>
			   <td><button class="button" onclick=" window.location.href='Update.jsp?id=<%=i.getId()%>'"><fmt:message key="label.edit" />&nbsp;
	          <button class="button" onclick="window.location.href= 'Delete.jsp?id=<%=i.getId()%>'"><fmt:message key="label.delete" />&nbsp;
	          </td>
             <% } %>
			</center>
				
			</tr>
			</b>
			<%
		} %>

</table>
<center>
	
	</center>	
</body>
</html>