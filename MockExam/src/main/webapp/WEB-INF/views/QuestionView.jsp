<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exam Management Screen</title>
</head>
<body>
    <div align="center">
        <h1>Question</h1>
        <h3>
            <a href="newExam">Question </a>
        </h3>
        <table border="1">
 
            <th>Question</th>
            <th>Option1</th>
			<th>Option2</th>
			<th>Option3</th>
			<th>Option4</th>
            <th>Answer</th>
 
            <c:forEach var="exam" items="${listExam}">
                <tr>
 
                    <td>${exam.question}</td>
                    <td>${exam.option1}</td>
                    <td>${exam.option2}</td>
                    <td>${exam.option3}</td>
					<td>${exam.option4}</td>
					<td>${exam.answer}</td>
                    <td><a href="editExam?id=${exam.id}">Edit</a>
                             <a
                        href="deleteExam?id=${exam.id}">Delete</a></td>
 
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
