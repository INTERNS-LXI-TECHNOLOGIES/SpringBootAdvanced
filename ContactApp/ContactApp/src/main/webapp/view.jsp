<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="com.lxisoft.models.*"%>
<%@ page import="com.lxisoft.domain.*"%>
<%@ page import="java.util.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contacts</title>
<% String locale=(String)session.getAttribute("currentlocale"); %>
			<fmt:setLocale value="${currentlocale}" />
            <fmt:setBundle basename="messages"/>
			<title> <fmt:message key="label.contacts"/> </title>
			  <link rel="stylesheet" type="text/css" href="../styles.css">
			   <script>
						var beep=new Audio();
						beep.src="../sound2.wav";
				</script>
</head>
<body>
<% String pageid=(String)session.getAttribute("page"); %>
			<h4> Page:<%=pageid %> </h4>  
			<center> <h3> <fmt:message key="label.contacts"/></h3></center>
			<a href="lang?lang=en"><fmt:message key='label.en'/></a> &nbsp; <a href="lang?lang=ml">മലയാളം</a><br/><br/>
			<%if(request.getUserPrincipal()!=null) { %>
				<center> <fmt:message key="label.welcome"/> <%=request.getUserPrincipal().getName()%> </center> <% }
			 else { %> <center> <fmt:message key="label.welcome"/> guest  <% } %> </center>

			 <a href="logout" style="float:right;"><fmt:message key="label.logout"/></a>

			<% if (request.isUserInRole("manager-gui"))  { %>
			<a href="add" ><img src="images/add1.png" height="40px" width="40px"></a> 
			<% }
			else { %>
			<nav>
			<button type="button" onclick="beep.play(); Access_denied();"><img src="images/add1.png" height="40px" width="40px">
			<% } %></button></nav>
			<script>
						function Access_denied(){
						alert("<fmt:message key="label.AccessDenied"/>!!!");
						// window.location="ContactAdd.jsp"
						}
			</script>
			<form action="select" method="GET"><center>
				<input type="text" name="user" placeholder= "<fmt:message key='label.Entername'/>">
				<button> <fmt:message key="label.search"/> </button></center>
			</form>

			<form action="sort" method="GET"><center>
				<select name="sortvalue">
	  				<option value="firstname"><fmt:message key="label.fName"/></option>
	  				<option value="lastname"><fmt:message key="label.lName"/></option>
	  			</select>
	  			<input type="submit" value="<fmt:message key='label.sort'/>"></center>

	  		</form>
  			<% if (request.isUserInRole("manager-gui"))  { %>
				<center> <button  type="button" onClick="window.location.href = 'DeleteAll';"><fmt:message key="label.deleteall"/></button></center>
			<% }
			else { %>
				<center> <button  type="button" onclick="Access_denied()"><fmt:message key="label.deleteall"/></button></center>
			<% } %><br/><br/>
			
			<% 	ArrayList<ContactModel> contactList=( ArrayList<ContactModel>)request.getAttribute("contactmodel");
			  
				 if(contactList.size()==0)
				{%> <script>
						msg()
						function msg(){
						alert("<fmt:message key="label.Nocontactstoshow"/>");
						// window.location="ContactAdd.jsp"
						}
					</script>
					
				<%} %>
				<table align="center" border="10px" width="30%">
				<tr><th colspan="3"><strong>NAME</strong></th></tr>
				<% for(ContactModel contactmodel:contactList)
				{ %>

					<tr>
						<td><button class="button" type="button" onClick="window.location.href ='select?user=<%=contactmodel.getFullName()%>';"><%=contactmodel.getFullName()%>
						</button></td>
					<% if (request.isUserInRole("manager-gui"))  { %>	
						<td><button class="button" type="button" onClick="window.location.href='selectContact?select=<%=contactmodel.getId()%>';"><fmt:message key="label.edit"/></button></td>
					<% }
					else { %>
						<td>
						<button class="button" type="button" onclick="Access_denied()"><fmt:message key="label.edit"/></button></td>
					<% } %>


					<% if (request.isUserInRole("manager-gui"))  { %>	
						<td><button class="button" type="button" onClick="window.location.href='selectContact?select=<%=contactmodel.getFullName()%>';"><fmt:message key="label.delete"/></button></td>
					<% }
					else { %>
							<td>
							<button class="button" type="button" onclick="Access_denied()"><fmt:message key="label.delete"/></button></td>
						<% } %>

					</tr>
				<% } %>
		</table></br>
		
		<center><button type="button" onClick="window.location.href='view?page=1'"><fmt:message key="label.refresh"/></button><br>
		<!-- <% out.println("<fmt:message key='label.cnct'/>"+""+contactList.size());%> -->
		<a href="view?page=1">1</a>  
		<a href="view?page=2">2</a>  
		<a href="view?page=3">3</a>  </center>
</body>
</html>