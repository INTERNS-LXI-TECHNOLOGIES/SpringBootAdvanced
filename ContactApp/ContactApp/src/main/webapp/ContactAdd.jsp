
    <%@ page import="java.util.ResourceBundle"%>
    <%@ page import="com.lxisoft.domain.Contact"%>
	<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<%@ page isELIgnored="false" %>
    
<!DOCTYPE html>
<html>
<head>
<title>Adding Contacts</title>

			 <link rel="stylesheet" type="text/css" href="styles.css">
			<fmt:setLocale value="${currentlocale}" />
			<fmt:setBundle basename="messages"/>
			<title> <fmt:message key="label.AddContacts"/> </title>
</head>
<body>
	<center>
				 <h3><fmt:message key="label.AddContacts"/> </h3>
			</center>
			</br></br> <a href="logout" style="float:right;"><fmt:message key="label.logout"/></a>

			<% Contact contact =(Contact)request.getAttribute("contacts"); 
			if(contact!=null) 
			{ %>
				<button align="left" type="button" onClick="window.location.href = 'View';"><fmt:message key='label.back'/></button>
				<form action="addContact" name="form1" method="GET" onSubmit=" return validateForm()">
					<center>
						<input type="text"  name="fname" placeholder= "<fmt:message key='label.fName'/>">
						<font color="red">*</font> <br><br> 
						<input type="text"  name="lname" placeholder= "<fmt:message key='label.lName'/>">
						<font color="red">*</font><br><br> 
						<input type="number"  name="num" placeholder= "<fmt:message key='label.phno'/>">
						<font color="red">*</font><br><br>
						<input type="submit" value="<fmt:message key='label.save'/>">
						<!-- <button onclick="validateForm() "><fmt:message key='label.save'/>"></button> -->
						<input type="reset" value="<fmt:message key='label.reset'/>">
						
					</center>
				</form>
					<script>
						msg()
						function msg(){
						alert(" <fmt:message key='label.Cexist'/>");}
					</script>
		<% } 
		  else
			{ %>
				<!-- <button align="left" type="button" onClick="window.location.href = 'View';">Back</button> -->
				<a href="View" ><img src="images/back.png" height="40px"; width="40px";></a> 
				<form  name="form1" action="addContact" method="GET" onsubmit="return validateForm()">
					<center>
						<input type="text"  name="fname" placeholder="<fmt:message key='label.fName'/>">
					<font color="red">*</font> <br><br> 
						<input type="text"  name="lname" placeholder= "<fmt:message key='label.lName'/>">
					<font color="red">*</font> <br><br> 
						<input type="text" id="num1" name="num" placeholder= "<fmt:message key='label.phno'/>">
					<font color="red">*</font> <br><br> 
					<!-- <button onclick="validateForm() "><fmt:message key='label.save'/></button> -->
						<input type="submit" value="<fmt:message key='label.save'/>">
						<input type="reset" value="<fmt:message key='label.reset'/>">
						
					</center></form>
		<% } %>
			<script>	
				function validateForm() 
				{
	 				var fn = document.form1.fname.value;
	 				var ln=	document.form1.lname.value;
	 				var ph=document.form1.num.value;
	  				if (fn == "" ||ln== "" || ph== " ") 
	  				{ 
	  					alert("it can't be blank you must fill it!");
	  					return false;
	  				}
	    			 // x = document.getElementById("num1").value;
					if (isNaN(ph) || ph.toString().length != 10)
					{ 
					 alert("invalid phno"); 
					  return false;
					}
	   					
  				}
  			</script>
			
</body>
</html>