<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
 
<fmt:setBundle basename="Messages"/>
 
<html>
<head>
    <title>Translation</title>
</head>
<body>
    <h2>
        <fmt:message key="label.welcome" />
        <fmt:setLocale value="fr"/>
        <fmt:setBundle basename="messages" />
    </h2>
</body>
</html>