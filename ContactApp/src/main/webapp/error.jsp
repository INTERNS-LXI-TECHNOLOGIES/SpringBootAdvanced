<!DOCTYPE html>
<html>
<head>
	<title>error page</title>
</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="messages" />
 
<html lang="${lang}">
<center><h1><fmt:message key="label.Wrong" /> ! </h1><br><a href="index.jsp"><fmt:message key="label.another" /> ?</a></center>
</body>
</html>