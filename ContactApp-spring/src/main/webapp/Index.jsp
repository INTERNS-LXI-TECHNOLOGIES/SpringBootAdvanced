<%@page import = "com.lxisoft.servlet.*"%>
<%@page import = "com.lxisoft.repository.*"%>
<%@page import = "com.lxisoft.sqlrepository.*"%>
<%@page import = "com.lxisoft.model.*,java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="Messages" />
 
<!DOCTYPE html>
<html lang="${param.lang}">
<head>
	
	<h1 align="center"> <fmt:message key="label.contactapp" /></h1>
	<title>Index page</title>
		<style> 

</style>     
</head>
<body style="background: lightgreen">
	<h2>
            <fmt:message key="label.welcome" />
        </h2>
       
 <ul>

 <li><a href="Setlang?lang=en">eng</a></li>
 <li><a href="Setlang?lang=fr">française</a></li>
 <li><a href="Setlang?lang=hd">हिंदी</a></li>
  <li><a href="Setlang?lang=ml">മലയാളം</a></li>

 </ul>

	<div>
		<b>
			<center>
	<a style="font-family:fantasy; font size: 70px;"  href="Display"> <fmt:message key="label.displaycontacts" /></a><br>
	

	</center>
	</font>
</b>
</div>	
</body>
</html>