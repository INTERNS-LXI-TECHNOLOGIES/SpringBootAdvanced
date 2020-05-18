<%@ page import="com.lxisoft.entity.Customer"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
	<meta charset="utf-8">
	<title>nav</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="https://kit.fontawesome.com/a076d05399.js"></script>
	<link type="text/css"  href="${pageContext.request.contextPath}/resources/css/exam.css" rel="stylesheet">
</head>
<body background="${pageContext.request.contextPath}/resources/images/78.png">
<div class="wrapper fadeInDown">
<section class="container">
<nav>
	<label for="check" class="checkbtn"></label>
	<label class="logo">MockExam</label>
	<ul>
		<li><a href="javascript:document.getElementById('logout').submit()">LOGOUT</a></li>
		<li><a href="/" class="active">HOME</a></li>
	</ul>
</nav>
<br>
<div class="center">
        <% ArrayList<Customer> model=new ArrayList<Customer>();
        model =(ArrayList<Customer>)session.getAttribute("exam"); 
        int qcount = Integer.parseInt(request.getParameter("qcount"));
        int size=model.size();
         if(qcount != size) {

        %>
		<div class="login-header1">
        <h2><%out.println("Question :"+(qcount + 1));%></h2>
        </div>
        <br>
		<div class="login-header3">
        <h1><%out.println(model.get(qcount).getQn());%></h1>
       </div>
		<br>
           <form action="start" method="get" name="qform">
            <table>
            
            <tr>
            
        <td><div class="login-header2"><h1><input type="radio" name="opt" value="1"/>
          <label for="1"><% out.println(model.get(qcount).getOpt1());%></label></h1></div></td>
          </tr>
          <tr>
          <td><div class="login-header2"><h1><input type="radio" align="center" name="opt" value="2"/>
          <label for="2"><% out.println(model.get(qcount).getOpt2());%></label></h1></div></td>
          </tr>
          <tr>
         <td><div class="login-header2"><h1><input type="radio" name="opt" value="3"/>
          <label for="3"><% out.println(model.get(qcount).getOpt3());%></label></h1></div></td>
          </tr>
          <tr>
        <td><div class="login-header2"><h1><input type="radio" name="opt" value="4"/>
          <label for="4"><% out.println(model.get(qcount).getOpt4());%></label></h1></div></td>
          </tr>
            <%qcount++; %>
            <input type="hidden" name="qcount" value= <%out.println(qcount);%>/>
            <br>
            </table>
            <br>
            <br>
             <td colspan="2" align="center"><input type="submit" onclick="myFunction()" class="button button1" value="NEXT"></td>
          	<td colspan="2" align="center"><input type="submit" class="button button2" value="SKIP"></td>
          </form>
           <script>
function myFunction() {
	if (!$("input[name='html_elements']:checked").val()) {
		   alert('Nothing is checked!');
		}
		else {
		  alert('One of the radio buttons is checked!');
		}
}
</script>
          <%    
         } else {

             response.sendRedirect("result");
             

      } %>
      </div>
</section>
</div>
</body>
</html>