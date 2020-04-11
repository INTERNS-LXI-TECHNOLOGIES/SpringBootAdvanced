<%@page contentType = "text/html;charset=UTF-8" pageEncoding = "UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="java.util.List"%>
<%@page import="com.lxisoft.model.Exam" %>
<html>
<head>
<title>Exam Question View</title>
<meta http-equiv="Content_Type" content="text/html;charset=UTF-8"/>
</head>
<body>
	   <%
	   List<Exam> qn = (List<Exam>)session.getAttribute("listExam");
       int i = Integer.parseInt(request.getParameter("indexValue"));
       %>
	
        
		<h1 align="center">Questions</h1>
            
        <%if(i < qn .size())
        	{%>
		<form method="GET">
		
		<label><%out.print(qn.get(i).getQuestion()); %></label><br>
        <input type="checkbox" value="a" name="option" id="option1" >
        <label for = "option1"><%out.print(qn.get(i).getOption1()); %></label><br>
        <input type="checkbox" value="b" name="option" id="option2" >
        <label for = "option2"><%out.print(qn.get(i).getOption2()); %></label><br>
        <input type="checkbox" value="c" name="option" id="option3" >
        <label for = "option3"><%out.print(qn.get(i).getOption3()); %></label><br>
        <input type="checkbox" value="d" name="option" id="option4" >
        <label for = "option4"><%out.print(qn.get(i).getOption4()); %></label><br>
		 <%i++; %>
	  <input type="hidden" name ="indexValue" value="<%out.print(i);%>">
      <button formaction="result" name="indexValue" value ="<%out.print(i);%>">Next</button>
        </form>
			<%}%>
    
</body>
</html>