<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
<fmt:setLocale value="${locallang}" />
<fmt:setBundle basename="Messages" />

<!DOCTYPE html>
<html lang="${param.lang}">
<head>
	<title>
		
	</title>
</head>
<body button style ="background: lightgreen">

	
<%String lang=(String)session.getAttribute("locallang");%>
<form method="POST" action="j_security_check">
	<center>
		    <p><fmt:message key="label.username" />: <input type="text" name="j_username" size="20"/></p>
            <p><fmt:message key="label.password" />: <input type="password" size="20" name="j_password"/></p>
            <p>  <input type="submit" value="Submit"/></p>
	</center>
        </form>       
</body>
</html>