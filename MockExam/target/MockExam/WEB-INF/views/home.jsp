<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Management </title>
</head>
<body>
	<div align="center">
		<h1>Admin Management</h1>
		
		<table border="1">

			<th>Question</th>
			<th>Option1</th>
			<th>Option2</th>
			<th>Option3</th>
			<th>Option4</th>
			<th>Answer</th>

			<c:forEach var="examModel" items="${listExam}">
				<tr>

					<td>${examModel.question}</td>
					<td>${examModel.opt1}</td>
					<td>${examModel.opt2}</td>
					<td>${examModel.opt3}</td>
					<td>${examModel.opt4}</td>
					<td>${examModel.answer}</td>
					<td><a href="editExam?id=${examModel.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteExam?id=${examModel.id}">Delete</a>
					</td>

				</tr>
			</c:forEach>
		</table>
		<h4>
			Add new Question <a href="newExam">here</a><br><br>
			<a href="Login.jsp">back</a>
			<button formaction="/" class="button">BACK</button>
		</h4>
	</div>
</body>
</html>