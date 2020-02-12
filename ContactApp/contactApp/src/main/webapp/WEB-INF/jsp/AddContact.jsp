<%@page import="com.lxisoft.domain.*,com.lxisoft.config.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>

<body>
	 <div align="center">
        <h1>New/Edit Contact</h1>
        <form:form action="add" method="post" modelAttribute="contact">
        <table>
            
            <tr>
                <td>First Name:</td>
                <td><form:input path="contactFirstName" /></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><form:input path="contactLastName" /></td>
            </tr>
            <tr>
                <td>Number:</td>
                <td><form:input path="contactNumber" /></td>
            </tr>
            <tr>
                <td><a href="add"><input type="submit" value="save"/></a>
            </tr>
        </table>
        </form:form>
    </div>
    </body>
</head>
</html>