<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
	<meta charset="utf-8">
	<title>nav</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="https://kit.fontawesome.com/a076d05399.js"></script>
	<link type="text/css"  href="${pageContext.request.contextPath}/resources/css/instructions.css" rel="stylesheet">
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
<div class="login-header1">
    <h2>Result Page</h2>
  </div>
<p>
  <% int mark=Integer.parseInt(session.getAttribute("Result").toString());%>
<h1><font color="midnightblue">Welcome To Result Page!!!</font></h1>
<h1><font color="midnightblue">your Score :<%out.println(mark); %></font></h1>
<br>
<br>
<h1><font color="midnightblue">Have a good Day</font></h1>
</p>
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