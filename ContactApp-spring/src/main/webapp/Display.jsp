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
	{	width: 2px;
		border:2px solid black;

	}
</style> 
	<h1 align="center"> <fmt:message key="label.contacts" /></h1>
	<title>
	Display 	
	</title>

</head>
<body button style ="background: lightgreen">

<%@page import = "com.lxisoft.servet.*"%>
<%@page import = "com.lxisoft.repository.*"%>
<%@page import = "com.lxisoft.sqlrepository.*"%>
<%@page import = "com.lxisoft.model.*,java.util.*"%>

 <%String lang=(String)session.getAttribute("locallang");%>

<form action="Search" method="get">
		<center>
		 <input type="text" name="searchname">
		<input type="submit" value="search"><br><br>
		</center>
	</form>	

<table align="center" style="border-collapse: collapse;">
	        <tr>
				<th style="font-family: fantasy;font size: 10px"> <fmt:message key="label.name" /></th>
				
			</tr>
<% ArrayList<Contact> contactList=(ArrayList<Contact>) request.getAttribute("contactList");
	
	for(Contact i : contactList)
		{ %>
			<b>
				

			<tr style=" font-style:oblique;  ">
			<td>
				<a href="Select.jsp?temp=<%=i.getId()%>
					&temp1=<%=i.getFirstname()%>
					&temp2=<%=i.getLastname()%>
					&temp3=<%=i.getNumber()%>">
					
					<input type="button" name="submit" value="<%=i.getFirstname()%> &nbsp;<%=i.getLastname()%>">
				</a><br>

	<% if (request.isUserInRole("admin")) 
	{ %>
   			<button class="button" onclick=" window.location.href='Update.jsp?id=<%=i.getId()%>'"><fmt:message key="label.edit" />&nbsp; 

	       <button class="button" onclick="window.location.href= 'Delete.jsp?id=<%=i.getId()%>'"> <fmt:message key="label.delete" />&nbsp;	
    <%
     } %>

					
			</td>
			
			</tr>
			</b>
			<%
		} %>

</table>
<center><br>
<a style="font-family:fantasy; font size: 70px;"  href="Add.jsp" >  <fmt:message key="label.addcontacts" /></a>	
</center>
</body>
<footer>
	<a href="Logout.jsp"> LOGOUT </a>
</footer>
</html>