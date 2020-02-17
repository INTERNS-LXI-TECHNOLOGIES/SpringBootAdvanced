<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<%@ page isELIgnored="false" %>
	<%@ page import="com.lxisoft.domain.*"%>
<!DOCTYPE html>
<html>
		<head>
			<fmt:setLocale value="${currentlocale}" />
			<fmt:setBundle basename="messages"/>
			<title> <fmt:message key="label.details"/> </title>
			  <link rel="stylesheet" type="text/css" href="styles.css">
		</head>
		<body > 

			<% Contact contact= (Contact)session.getAttribute("currentcontact"); %>
			<br><br> <a href="logout" style="float:right;"><fmt:message key="label.logout"/></a>
			<!-- <h1><%=contact.getFullName()%></h1> -->
			<table align="center" border="10px" width="20%">
				<script>
						function Access_denied(){
						alert("<fmt:message key="label.AccessDenied"/>!!!");
						// window.location="ContactAdd.jsp"
						}
			</script>
			
				<tr><th><strong><fmt:message key='label.fName'/></strong></th><th><strong><fmt:message key='label.lName'/></strong></th><th><strong><fmt:message key='label.phno'/></strong></th><th colspan="10"></th></tr>
				<tr>    <td> <% out.println(contact.getFirstName()); %> </td>
						<td> <% out.println(contact.getLastName()); %> </td>
						<td> <% out.println(contact.getNo());  %></td>

						<% if (request.isUserInRole("manager-gui"))  { %>	
							<td><button class="button" type="button" 
							onClick="window.location.href ='ContactEdit.jsp';"> <fmt:message key="label.edit"/></button></td>
						<% }
						else { %>
							<td>
							<button class="button" type="button" onclick="Access_denied()"><fmt:message key="label.edit"/></button></td>
						<% } %>


						<% if (request.isUserInRole("manager-gui"))  { %>
							<td><button class="button" type="button" 
							onClick="window.location.href ='delete?user=<%=contact.getFullName()%>';"> <fmt:message key="label.delete"/> </button></td>
						<% }
						else { %>

						<td><button class="button" type="button" onclick="Access_denied()"><fmt:message key="label.delete"/></button></td>
						<% } %>
							<td><button class="button" type="button" 
								onClick="window.location.href ='view?page=1';"> <fmt:message key="label.back"/></button></td>
				</tr>
					
		</table>
			
		</body>
	</html>