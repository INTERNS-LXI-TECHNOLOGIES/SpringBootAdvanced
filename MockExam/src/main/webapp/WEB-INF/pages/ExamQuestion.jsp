<%@page contentType = "text/html;charset=UTF-8" pageEncoding = "UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="java.util.List"%>
<%@page import="com.lxisoft.model.MockModel" %>
<html>
<head>
<meta http-equiv="Content_Type" content="text/html;charset=UTF-8"/>
<style type="text/css">
.button {
  height: 52px;
     width: 186px;
     border: none;
     border-radius: 20px;
     background: linear-gradient(to left, #ab68ca, #de67a3);
     color: #fff;
     font-weight: bolder;
     margin-top: 30px;
     cursor: pointer;
     outline: none;
     font-size: 21px;
}
.button:hover {background-color: #3e8e41}

.button:active {
  background-color: #3e8e41;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}

.wrapper {
     width: 900px;
     height: 625px;
     position: relative;
     margin: 3% auto;
     box-shadow: 2px 18px 70px 0px #9d9d9d;
   }
</style>
</head>
<body>
	   <%
	   List<MockModel> questionList = (List<MockModel>)session.getAttribute("listQuestions");
	   out.print("ArraySize : "+questionList.get(1).getSelectedOption());
       int count = Integer.parseInt(request.getParameter("count"));
	   //out.println("Count : "+count);
	   //int count = 1;
       %>
	<div class="wrapper">
        
		<div align="center" style="background-color: darkmagenta;" >
            <br>
            <br>
      		<h1><font size="50px" color="white" >Exam Question</font></h1>
            <br>
            <br>
        </div>
        <%if(count < questionList.size())
        	{%>
  <div align="center" style="padding-left: 2%;">
  <form method="GET">
        <label><%out.print(questionList.get(count).getQuestion()); %></label><br>
        <input type="radio" value="1" name="option" id="option1" >
        <label for = "option1"><%out.print(questionList.get(count).getOption1()); %></label><br>
        <input type="radio" value="2" name="option" id="option2" >
        <label for = "option2"><%out.print(questionList.get(count).getOption2()); %></label><br>
        <input type="radio" value="3" name="option" id="option3" >
        <label for = "option3"><%out.print(questionList.get(count).getOption3()); %></label><br>
        <input type="radio" value="4" name="option" id="option4" >
        <label for = "option4"><%out.print(questionList.get(count).getOption4()); %></label><br>
      <%count++; %>
        <div align="center">
        <button formaction="selectOption" class="button" name ="count" value = <%out.print(count);%>>Next</button>
        </div>
        </form>
    </div>
    <%
        }
        else
        {
        out.print("!!!!! Question Finished !!!!");	
        List<MockModel> listQuestions =  (List<MockModel>) session.getAttribute("listQuestions");
        	for(int i =0;i<listQuestions.size();i++)
        	{
        		out.println("Question : "+listQuestions.get(i).getQuestion());%><br><%
        		out.println("Option1 : "+listQuestions.get(i).getOption1());%><br><%
        		out.println("Option2 : "+listQuestions.get(i).getOption2());%><br><%
        		out.println("Option3 : "+listQuestions.get(i).getOption3());%><br><%
        		out.println("Option4 : "+listQuestions.get(i).getOption4());%><br><%
        		out.println("SelectedOption : "+listQuestions.get(i).getSelectedOption());%><br><%
        	}
        }
    %>
    
</div>
</body>
</html>