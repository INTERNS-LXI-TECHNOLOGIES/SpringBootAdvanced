<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<HTML>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
</head>
<body>
    <div align="center">
        <h1>New/Edit Employee</h1>
        <form action="saveEmployee" method="post" modelAttribute="employee">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Name:</td>
                <td><input type="text" path="name" /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type = "text" path="email" /></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><input type = "text" path="address" /></td>
            </tr>
            <tr>
                <td>Telephone:</td>
                <td><input type = "text" path="telephone" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form>
    </div>
</body>
</html>