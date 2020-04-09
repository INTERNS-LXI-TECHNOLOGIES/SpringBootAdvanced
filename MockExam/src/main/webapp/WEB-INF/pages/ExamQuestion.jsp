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
        <input type="checkbox" id="<%=qn.get(i).getOption1()%>" name="option" value="<%=qn.get(i).getOption1()%>"/>
    	<label for="<%=qn.get(i).getOption1()%>"><%=qn.get(i).getOption1()%></label><br>
    	<input type="checkbox" id="<%=qn.get(i).getOption2()%>" name="option" value="<%=qn.get(i).getOption2()%>"/>
    	<label for="<%=qn.get(i).getOption2()%>"><%=qn.get(i).getOption2()%></label><br>
    	<input type="checkbox" id="<%=qn.get(i).getOption3()%>" name="option" value="<%=qn.get(i).getOption3()%>"/>
    	<label for="<%=qn.get(i).getOption3()%>"><%=qn.get(i).getOption3()%></label><br>
    	<input type="checkbox" id="<%=qn.get(i).getOption4()%>" name="option" value="<%=qn.get(i).getOption4()%>"/>
    	<label for="<%=qn.get(i).getOption4()%>"><%=qn.get(i).getOption4()%></label><br>
      <%i++; %>
	  <input type="hidden" name ="indexValue" value="<%out.print(i);%>">
      <button type ="submit" name="indexValue" value ="<%out.print(i);%>">Next</button>
        </form>
    <%}
	else
	{
    response.sendRedirect("result");
    }%>
</body>
</html>