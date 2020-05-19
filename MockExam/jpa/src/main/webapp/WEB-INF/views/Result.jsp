<%@ page import="com.lxisoft.entity.Customer"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en" dir="ltr">
<head>
	<meta charset="utf-8">
	<title>nav</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="https://kit.fontawesome.com/a076d05399.js"></script>
	<link type="text/css"  href="${pageContext.request.contextPath}/resources/css/list.css" rel="stylesheet">
</head>
<body background="${pageContext.request.contextPath}/resources/images/78.png">
<div class="wrapper fadeInDown">
<section class="container">
<nav>
	<label for="check" class="checkbtn"></label>
	<label class="logo">MockExam</label>
	<ul>
		<li><a href="javascript:document.getElementById('logout').submit()">LOGOUT</a></li>
		<li><a href="/jpa" class="active">HOME</a></li>
	</ul>
</nav>
<br>
<div class="center">
<div class="login-header1">
    <h2>Welcome To Result Page!!!</h2>
  </div>
  <br>
   <% ArrayList<Integer> model=new ArrayList<Integer>();
        model =(ArrayList<Integer>)session.getAttribute("select");%>
         <% ArrayList<Customer> model1=new ArrayList<Customer>();
        model1 =(ArrayList<Customer>)session.getAttribute("exam");%>
  <% int mark=Integer.parseInt(session.getAttribute("Result").toString());%>
   <div class="ex1">
        <table class="table-fill">
        <thead>
         <tr>
            <th class="text-left">Questions</th>
            <th class="text-left">selected answer</th>
            <th class="text-left">right answer</th>
            </tr>
            </thead>
<tbody class="table-hover">
      <!-- loop over and print our customers -->
     <%for(int i=0;i<model1.size();i++){ %>

       <tr>
        <td class="text-left"><%out.println(model1.get(i).getQn()); %></td>
        <td class="text-left">Option <% out.println(model.get(i));%></td>
        <td class="text-left">Option <%out.println(model1.get(i).getAns()); %></td>
  
		 </tr>
<%} %>
</tbody>
     </table>
     <br>
     <%if(mark<5){ %>
     <div class="login-header">
     <h2>FAILED !!!</h2>
     </div>
     <br>
     <%}else{ %>
      <div class="login-header">
     <h2>PASSED !!!</h2>
     </div>
     <br>
     <%} %>
     <div class="login-header">
     <h2>your Score :<%out.println(mark); %></h2>
     </div>
<br>
<br>
<div class="login-header">
<h2>Have a good Day!!!</h2>
</div>
     </div>
<c:url value="/logout" var="logoutUrl" />
<form id="logout" action="${logoutUrl}" method="POST" >
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<c:if test="${pageContext.request.userPrincipal.name != null}">
</c:if>
    </div>
</section>
</div>
</body>
</html>