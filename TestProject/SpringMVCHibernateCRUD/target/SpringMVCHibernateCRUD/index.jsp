<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 
<html>
<head>
    <title>Add Employee Form</title>
    <style>
    .error 
    {
        color: #ff0000;
        font-weight: bold;
    }
    </style>
</head>
 
<body>
    <h2> text="Add New Employee" /></h2>
    <br/>
    <form:form action="saveEmployee" method="post" modelAttribute="employee">
        <table>
            <tr>
                <td> text="Name" /></td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>< text="Address" /></td>
                <td><form:input path="address" /></td>
            </tr>
            <tr>
                <td> text="Email Id" /></td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td> text="Telephone" /></td>
                <td><form:input path="telephone" /></td>
            </tr>
            <tr>
                <td colspan="3"><input type="submit" value="Add Employee"/></td>
            </tr>
        </table>
    </form:form>
</body>
</html>