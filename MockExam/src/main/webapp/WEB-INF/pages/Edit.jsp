<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Question</title>
</head>
<body>
    <div align="center">
        <h1>Edit Question</h1>
        <form:form action="saveExam" method="post" modelAttribute="exam">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Question:</td>
                <td><form:input path="question" /></td>
            </tr>
            <tr>
                <td>Option1:</td>
                <td><form:input path="option1" /></td>
            </tr>
			<tr>
                <td>Option2:</td>
                <td><form:input path="option2" /></td>
            </tr>
			<tr>
                <td>Option3:</td>
                <td><form:input path="option3" /></td>
            </tr>
			<tr>
                <td>Option4:</td>
                <td><form:input path="option4" /></td>
            </tr>
            <tr>
                <td>Answer:</td>
                <td><form:input path="answer" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>