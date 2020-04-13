<%@ page import="com.lxisoft.model.ExamModel"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Start Exam</title>
</head>
<body bgcolor="FloralWhite">
<style>
      body {
  background-image: url('78.png');
    background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  height: 100%
}
.container {
  height: 700px;
  position: relative;
  border: 5px solid midnightblue;
}

.center {
  margin: 0;
  position: absolute;
  top: 50%;
  left: 30%;
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}
.button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 16px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  transition-duration: 0.4s;
  cursor: pointer;
}

.button1 {
  background-color: white; 
  color: black; 
  border: 2px solid #4CAF50;
  border-radius: 12px;
}

.button1:hover {
  background-color: #4CAF50;
  color: white;
}

input[type=text] {
  width: 230%;
  padding: 12px 20px;
  border: 2px solid red;
  border-radius: 4px;
}
</style>
<div class="container">
<div class="center">
    <div align="center">
        <font align="center" size="6" color="midnightblue"><i><b>Lets Start !!!!!!</b></i></font><br><br><br>
        <% ArrayList<ExamModel> model=new ArrayList<ExamModel>();
        model =(ArrayList<ExamModel>)session.getAttribute("exam"); 
        int qcount = Integer.parseInt(request.getParameter("qcount"));
        int size=model.size();
         if(qcount != size) {

        %><font align="left" color="midnightblue"> <%out.println("<h1>Question :"+(qcount + 1)+"."+model.get(qcount).getQn()+"</h1>");
           %>
           <form action="start" method="get" name="qform">
        <h1><input type="radio" name="opt" value="1"/>
          <label for="1"><font align="left" color="midnightblue"><% out.println(model.get(qcount).getOpt1());%></label></font></h1>
          <h1><input type="radio" name="opt" value="2"/>
          <label for="2"><font align="left" color="midnightblue"><% out.println(model.get(qcount).getOpt2());%></label></font></h1>
          <h1><input type="radio" name="opt" value="3"/>
          <label for="3"><font align="left" color="midnightblue"><% out.println(model.get(qcount).getOpt3());%></label></font></h1>
          <h1><input type="radio" name="opt" value="4"/>
          <label for="4"><font align="left" color="midnightblue"><% out.println(model.get(qcount).getOpt4());%></label></font></h1>
            <%qcount++; %>
            <input type="hidden" name="qcount" value= <%out.println(qcount);%>/>
            <input type="submit" class="button button1"   value="<%out.println("next");%>" />
          </form>
          <%    
         } else {

             response.sendRedirect("result");
             

      } %>
    </div>
    </div>
    </div>
</body>
</html>