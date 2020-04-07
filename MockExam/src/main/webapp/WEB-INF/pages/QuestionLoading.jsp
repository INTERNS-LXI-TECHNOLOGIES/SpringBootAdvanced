<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action= "ExamQuestion.jsp">
<%
out.println("Count : "+request.getParameter("count"));
int count = Integer.parseInt(request.getParameter("count"));
%>
<input type = "hidden" name = "count" value = <%out.print(count); %>>
<h1>Loading.......</h1>
<button>Done</button>
</form>

</body>
</html>