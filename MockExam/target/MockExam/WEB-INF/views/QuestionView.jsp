<!DOCTYPE html>
<%@page contentType = "text/html;charset=UTF-8" pageEncoding = "UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="java.util.List"%>
<%@page import="com.lxisoft.model.ExamModel" %>
<html>
<head>
  <title><h1>Questions</h></title> 
<style>
.container {
  height: 700px;
  position: relative;
  border: 5px solid oldlace;
}
.center {
  margin: 0;
  position: absolute;
  top: 25%;
  left: 30%;
  -ms-transform: translate(-30%, -30%);
  transform: translate(-20%, -20%);
}
.button_css
{
  background-color: midnightblue;
  color: white;
  width: 150px;
  height: 40px;
}

</style>

</head>
<body>
       <%
       List<ExamModel> questionLists = (List<ExamModel>)session.getAttribute("exam");
       int i=Integer.parseInt(request.getParameter("count"));
       %>
    <div class="wrapper">
        
        <div align="center" style="background-color: grey;" >
            <br>
            <br>
            <h1><font size="50px" color="midnightblue" >Exam Question</font></h1>
            <br>
            <br>
        </div>
        <%if(i< questionLists.size())
            {%>
  <div align="left" style="padding-left: 2%;">
  <form method="GET" action="selectOption">
        <h1><label>Question No <%out.print(i+1+" : "); out.print(questionLists.get(i).getQuestion()); %></label></h1><br>

        <h2><input type="radio" name="option" value=1 id="opt1">
        <label for="option1"><%out.print(questionLists.get(i).getOpt1()); %></label><h2><br>

        <h2><input type="radio"  value="2" name="option" id="opt2" >
        <label for = "option2"><%out.print(questionLists.get(i).getOpt2()); %></label></h2><br>

        <h2><input type="radio"  value="3" name="option" id="opt3" >
        <label for = "option3"><%out.print(questionLists.get(i).getOpt3()); %></label></h2><br>

        <h2><input type="radio"  value="4" name="option" id="opt4" >
        <label for = "option4"><%out.print(questionLists.get(i).getOpt4()); %></label></h2><br>

      <% i++; %>
        <div align="center">
               
        <!-- <input type="hidden"class="button" name="count" value=<%out.println(i);%>
        <button type="submit">Next</button>
         --><button onclick="check()" id="submitBtn" class="button" name ="count" value = <%out.print(i);%>>Next</button>
        
    
    </div>
        </form>
    </div>
    <%
        }
        else
        {
            response.sendRedirect("result");
        }
    %>
    
</div>
</body>
</html>
