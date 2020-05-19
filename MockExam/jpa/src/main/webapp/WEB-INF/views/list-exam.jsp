<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
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
		<li><a href="add">ADD</a></li>
		<li><a href="user">EXAM</a></li>
		<li><a href="javascript:document.getElementById('logout').submit()">LOGOUT</a></li>
		<li><a href="/jpa" class="active">HOME</a></li>
	</ul>
</nav>
<br>
<br>
  <div class="center">
<div class="login-header">
    <h1>Display Page</h1>
  </div>
  <br>
  <br>
  <div class="ex1">
        <table class="table-fill">
        <thead>
         <tr>
            <th class="text-left">Questions</th>
            <th class="text-left">Option 1</th>
            <th class="text-left">Option 2</th>
            <th class="text-left">Option 3</th>
            <th class="text-left">Option 4</th>
            <th class="text-left">Answer</th>
            <th class="text-left">Action</th>
            </tr>
            </thead>
<tbody class="table-hover">
      <!-- loop over and print our customers -->
      <c:forEach var="tempExam" items="${exam}">

       <!-- construct an "update" link with customer id -->
       <c:url var="updateLink" value="/updateForm">
        <c:param name="examId" value="${tempExam.slno}" />
       </c:url>

       <!-- construct an "delete" link with customer id -->
       <c:url var="deleteLink" value="/delete">
        <c:param name="examId" value="${tempExam.slno}" />
       </c:url>
       <tr>
        <td class="text-left">${tempExam.qn}</td>
        <td class="text-left">${tempExam.opt1}</td>
        <td class="text-left">${tempExam.opt2}</td>
        <td class="text-left">${tempExam.opt3}</td>
        <td class="text-left">${tempExam.opt4}</td>
        <td class="text-left">${tempExam.ans}</td>

        <td class="text-left">
         <!-- display the update link --> <a href="${updateLink}" class="button button2">Update</a>
         <a href="${deleteLink}" class="button button1"
         onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
        </td>

       </tr>

      </c:forEach>
</tbody>
     </table>
     </div>
     
<c:url value="/logout" var="logoutUrl" />
<form id="logout" action="${logoutUrl}" method="post" >
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<c:if test="${pageContext.request.userPrincipal.name != null}">
</c:if>

    </div>
</section>
</div>
</body>
</html>