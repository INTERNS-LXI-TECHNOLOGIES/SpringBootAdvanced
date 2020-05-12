<%@page contentType = "text/html;charset=UTF-8" pageEncoding = "UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="java.util.List"%>
<%@page import="com.lxisoft.entity.MockEntity" %>
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
     width: 86%;
     height: 687px;
     position: relative;
     margin: 3% auto;
     box-shadow: 2px 18px 70px 0px #9d9d9d;
   }
</style>
<script type="text/javascript">

		function selectRadio() {
			document.getElementById('submitBtn').type = "submit";
		}

		function check() {
		var checkRadio = document.querySelector( 
                'input[name="option"]:checked'); 
                if(!checkRadio) {
            		alert("Please Select a Option");
            	}
		}
<%
String clock = "20";
%>
var timeout = <%=clock%>;
function timer()
{
	if( --timeout > 0 )
	{
		document.getElementById('clock').innerHTML = timeout;
		window.setTimeout( "timer()", 1000 );
	}
	else
	{
		let count = document.getElementById('submitBtn').value;
		window.location = '/MockTest1/selectOption?count='+count;
	}
}
</script>
</head>
<body>
<div align="right" style = "padding-right: 7%;">
<h1 > Seconds Remaining : <span id="clock"><%=clock%></span> </h1>
</div>
<script type="text/javascript">
timer();
</script>

	   <%
	   List<MockEntity> questionList = (List<MockEntity>)session.getAttribute("listQuestions");
       int count = Integer.parseInt(request.getParameter("count"));
       %>
	<div class="wrapper">
        
		<div align="center" style="background-color: darkmagenta;" >
            <br>
            <br>
      		<h1><font  size="50px" color="white" >Exam Question </font></h1>
            <br>
            <br>
        </div>

        <%if(count < questionList.size())
        	{%>
  <div align="left" style="padding-left: 2%;">
  <form method="GET" action="selectOption">
        <h1><label>Question No <%out.print(count+1+" : "); out.print(questionList.get(count).getQuestion()); %></label></h1><br>
        <h2><input onclick="selectRadio()" type="radio" value="1" name="option" id="option1" >
        <label for = "option1"><%out.print(questionList.get(count).getOption1()); %></label></h2><br>
        <h2><input onclick="selectRadio()" type="radio" value="2" name="option" id="option2" >
        <label for = "option2"><%out.print(questionList.get(count).getOption2()); %></label></h2><br>
        <h2><input onclick="selectRadio()" type="radio" value="3" name="option" id="option3" >
        <label for = "option3"><%out.print(questionList.get(count).getOption3()); %></label></h2><br>
        <h2><input onclick="selectRadio()" type="radio" value="4" name="option" id="option4" >
        <label for = "option4"><%out.print(questionList.get(count).getOption4()); %></label></h2><br>
      <%count++; %>
        <div align="center">
        <button onclick="check()" type="button" id="submitBtn" class="button" name ="count" value = <%out.print(count);%>>Next</button>
        </div>
        </form>
    </div>
    <%
        }
        else
        {
        	//System.out.println("Question Completed");
        	response.sendRedirect("result");
        }
    %>
    
</div>
</body>
</html>