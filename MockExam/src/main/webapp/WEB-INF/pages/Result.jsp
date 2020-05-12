<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.lxisoft.entity.MockEntity" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
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
     width: 78%;
     height: 745px;
     position: relative;
     margin: 3% auto;
     box-shadow: 2px 18px 70px 0px #9d9d9d;
     overflow-y: auto;
   }
.resultDiv{
    border: solid;
    border-color: darkmagenta;
    width: 98%;
}
</style>
</head>
<body>
<div class = "wrapper">
		<div  align="center" style="background-color: darkmagenta;">
			<br>
			<br>
		<h1><font style="font-size:50px;" color="white">MOCK EXAM RESULT</font></h1>
			<br>
			<br>
			</div>
<div style="padding-left: 40px;" align="left">
<%
List<MockEntity> listQuestions = (List<MockEntity>)session.getAttribute("listQuestions");
int result = Integer.parseInt(session.getAttribute("Result").toString());
%>
<br>
<br>
<div class ="resultDiv">
<h1><label>RESULT : <%out.println(result); %></label></h1><br><%
if(result<=6)
{
	%><h1><label>FAILED &#128542 BETTER LUCK NEXT TIME &#129296</label></h1><br><%	
}
else 
{
	%><h1><label>CONGRADULATIONS YOU PASS &#128522</label></h1><br><%
}
for(int i = 0 ;i<listQuestions.size();i++)
{
%>
</div>
<h1><label>Question No <%out.print(i+1+" : "); out.print(listQuestions.get(i).getQuestion()); %></label></h1>
<div style="font-size: 20px;">
<label>&#9632 <%out.println(listQuestions.get(i).getOption1()); %></label><br>
<label>&#9632 <%out.println(listQuestions.get(i).getOption2()); %></label><br>
<label>&#9632 <%out.println(listQuestions.get(i).getOption3()); %></label><br>
<label>&#9632 <%out.println(listQuestions.get(i).getOption4()); %></label><br>
<%
	if (listQuestions.get(i).getAnswer().equals(listQuestions.get(i).getSelectedOption()))
	{
	%>
	<label style="background-color: chartreuse;font-size: larger;">Selected Option : <%out.println(listQuestions.get(i).getSelectedOption()); %></label><br>	
	<%
	} 
	else
	{
	%>
	<label style="background-color: red;font-size: larger;">Selected Option : <%out.println(listQuestions.get(i).getSelectedOption()); %></label>&nbsp;&nbsp;
	<label style="background-color: chartreuse;font-size: larger;">Correct Option : <%out.println(listQuestions.get(i).getAnswer()); %></label><br>
	<%
	}
}
%>
</div>
</div>
<div align="center">
<form action="introduction">
<button class="button">THANK YOU</button>
</form>
</div>
<br>
</div>
</body>
</html>