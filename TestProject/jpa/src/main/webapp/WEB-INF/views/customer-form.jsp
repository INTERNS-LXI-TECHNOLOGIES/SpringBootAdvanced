<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" dir="ltr">
<head>
	<meta charset="utf-8">
	<title>nav</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="https://kit.fontawesome.com/a076d05399.js"></script>
	<link type="text/css"  href="${pageContext.request.contextPath}/resources/css/form.css" rel="stylesheet">
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
    <div align="center">
       <div class="login-header">
    <h1>welcome to add page</h1>
  </div><br><br><br>
        <form:form action="saveCustomer" method="post" modelAttribute="customer">

       <table>
            <form:hidden path="slno"/>
            <tr>
                <td><font size="5" color="midnightblue">Question : </font></td>
                <td><form:input path="qn" /></td>
            </tr>
             <tr>
                <td><font size="5" color="midnightblue">Option 1 : </font></td>
                <td><form:input path="opt1" /></td>
            </tr>
             <tr>
                <td><font size="5" color="midnightblue">Option 2 : </font></td>
                <td><form:input path="opt2" /></td>
            </tr>
             <tr>
                <td><font size="5" color="midnightblue">Option 3 : </font></td>
                <td><form:input path="opt3" /></td>
            </tr>
             <tr>
                <td><font size="5" color="midnightblue">Option 4 : </font></td>
                <td><form:input path="opt4" /></td>
            </tr>
             <tr>
                <td><font size="5" color="midnightblue">Ans : </font></td>
                <td><form:input path="ans" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" onclick="myFunction()" class="button button1" value="add"></td>
            </tr>
        </table>
        </form:form>
        <script>
function myFunction() {
  confirm("successfully added!");
}
</script>
    </div>
    </div>
    </section>
    </div>
</body>
</html>