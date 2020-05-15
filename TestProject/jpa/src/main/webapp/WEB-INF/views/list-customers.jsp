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
</head>
<body>
<style>
	html {
  background-color:white;
  scroll-behavior: smooth;

}
	*{
		padding: 0;
		margin: 0;
		text-decoration: none;
		list-style: none;
		box-sizing: border-box;
	}
	body{
		font-family: monospace;
	}
		
.wrapper {
  display: flex;
  align-items: center;
  flex-direction: column; 
  justify-content: center;
  width: 100%;
  min-height: 100%;
  padding: 20px;
}
	.container{
  width:1250px;
  height:705px;
  background:#fff;
  margin:20px auto;
  border-radius:10px;
  text-align:center;
  position:relative;
    -webkit-border-radius: 10px 10px 10px 10px;
  border-radius: 10px 10px 10px 10px;
  -webkit-box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
  box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
   overflow:hidden;
}

.login-header {
  color:midnightblue;
  font-family: 'Helvetica Neue', sans-serif;
  letter-spacing: -1px;
  text-align:center;
  font-size:200%;
}
	nav{
		background: #56baed;
		height: 100px;
		width: 100%;
	}
	label.logo{
		color: white;
		font-size: 60px;
		line-height: 80px;
		padding:0 80px;
		font-weight: bold;
		float: left;
		margin-left: : 60px;

	}
	
	@media (max-width: 952px)
	{
		label.logo{
			font-size: 30px;
			padding-left: 50px;
		}
	}

	
.center {
  margin: 0;
  position: absolute;
  top: 50%;
  left: 50%;
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

.button2 {
  background-color: white; 
  color: black; 
  border: 2px solid #008CBA;
  border-radius: 12px;
}

.button2:hover {
  background-color: #008CBA;
  color: white;
}
input[type=text] {
  width: 300%;
  padding: 12px 20px;
  border: 2px solid red;
  border-radius: 4px;
}
nav ul{
		float: right;
		margin-right: 60px;
	}
	nav ul li{
		display: inline-block;
		line-height: 80px;
		margin: 0 5px;
	}
	nav ul li a{
		color: white;
		font-size: 18px;
		padding: 7px 13px;
		border-radius: 8px;
		text-transform: uppercase;
	}
	a.active,a:hover{
		background: #1b9bff;
		transition: .5s;
	}
	.checkbtn{
		font-size: 30px;
		color:white;
		float: right;
		line-height: 80px;
		margin-right: 40px;
		cursor: pointer;
		display: none;

	}
	#check{
		display: none;
	}
	@media (max-width: 952px)
	{
		label.logo{
			font-size: 30px;
			padding-left: 50px;
		}
	}
	nav ul li a{
		font-size: 16px;
	}

.fadeInDown {
  -webkit-animation-name: fadeInDown;
  animation-name: fadeInDown;
  -webkit-animation-duration: 1s;
  animation-duration: 1s;
  -webkit-animation-fill-mode: both;
  animation-fill-mode: both;
}

@-webkit-keyframes fadeInDown {
  0% {
    opacity: 0;
    -webkit-transform: translate3d(0, -100%, 0);
    transform: translate3d(0, -100%, 0);
  }
  100% {
    opacity: 1;
    -webkit-transform: none;
    transform: none;
  }
}

@keyframes fadeInDown {
  0% {
    opacity: 0;
    -webkit-transform: translate3d(0, -100%, 0);
    transform: translate3d(0, -100%, 0);
  }
  100% {
    opacity: 1;
    -webkit-transform: none;
    transform: none;
  }
}

/* Simple CSS3 Fade-in Animation */
@-webkit-keyframes fadeIn { from { opacity:0; } to { opacity:1; } }
@-moz-keyframes fadeIn { from { opacity:0; } to { opacity:1; } }
@keyframes fadeIn { from { opacity:0; } to { opacity:1; } }

.fadeIn {
  opacity:0;
  -webkit-animation:fadeIn ease-in 1;
  -moz-animation:fadeIn ease-in 1;
  animation:fadeIn ease-in 1;

  -webkit-animation-fill-mode:forwards;
  -moz-animation-fill-mode:forwards;
  animation-fill-mode:forwards;

  -webkit-animation-duration:1s;
  -moz-animation-duration:1s;
  animation-duration:1s;
}

.fadeIn.first {
  -webkit-animation-delay: 0.4s;
  -moz-animation-delay: 0.4s;
  animation-delay: 0.4s;
}

.fadeIn.second {
  -webkit-animation-delay: 0.6s;
  -moz-animation-delay: 0.6s;
  animation-delay: 0.6s;
}

.fadeIn.third {
  -webkit-animation-delay: 0.8s;
  -moz-animation-delay: 0.8s;
  animation-delay: 0.8s;
}

.fadeIn.fourth {
  -webkit-animation-delay: 1s;
  -moz-animation-delay: 1s;
  animation-delay: 1s;
}

/* Simple CSS3 Fade-in Animation */
.underlineHover:after {
  display: block;
  left: 0;
  bottom: -10px;
  width: 0;
  height: 2px;
  background-color: #56baed;
  content: "";
  transition: width 0.2s;
}

.underlineHover:hover {
  color: #0d0d0d;
}

.underlineHover:hover:after{
  width: 100%;
}



/* OTHERS */

*:focus {
    outline: none;
} 

#icon {
  width:60%;
}

* {
  box-sizing: border-box;
}
.table-fill {
  background: white;
  border-radius:3px;
  border-collapse: collapse;
  height: 320px;
  margin: auto;
  max-width: 600px;
  padding:5px;
  width: 100%;
  -webkit-box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
  box-shadow: 0 5px 5px 0 rgba(0,0,0,0.3);
  animation: float 5s infinite;
}
 
th {
  color:white;
  background:#56baed;
  border-bottom:4px solid #9ea7af;
  border-right: 1px solid #343a45;
  font-size:23px;
  font-weight: 100;
  padding:24px;
  text-align:left;
  text-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);
  vertical-align:middle;
}

th:first-child {
  border-top-left-radius:3px;
}
 
th:last-child {
  border-top-right-radius:3px;
  border-right:none;
}
  
tr {
  border-top: 1px solid #C1C3D1;
  border-bottom-: 1px solid #C1C3D1;
  color:black;
  font-size:16px;
  font-weight:normal;
  text-shadow: 0 1px 1px rgba(256, 256, 256, 0.1);
}
 
tr:hover td {
  background:#EBEBEB;
  color:#FFFFFF;
  border-top: 1px solid #22262e;
}
 
tr:first-child {
  border-top:none;
}

tr:last-child {
  border-bottom:none;
}
 
tr:nth-child(odd) td {
  background:#EBEBEB;
}
 
tr:nth-child(odd):hover td {
  background: white;
}

tr:last-child td:first-child {
  border-bottom-left-radius:3px;
}
 
tr:last-child td:last-child {
  border-bottom-right-radius:3px;
}
 
td {
  background:white;
  padding:20px;
  text-align:left;
  vertical-align:middle;
  font-weight:300;
  font-size:18px;
  text-shadow: -1px -1px 1px rgba(0, 0, 0, 0.1);
  border-right: 1px solid #C1C3D1;
}

td:last-child {
  border-right: 0px;
}

th.text-left {
  text-align: left;
}

th.text-center {
  text-align: center;
}

th.text-right {
  text-align: right;
}

td.text-left {
  text-align: left;
}

td.text-center {
  text-align: center;
}

td.text-right {
  text-align: right;
}
div.ex1 {
  background-color: white;
  width: 1130px;
  height: 430px;
  overflow: auto;
}
.ex1::-webkit-scrollbar {
    display: none;
}
.ex1 {
    -ms-overflow-style: none;
}
</style>
<div class="wrapper fadeInDown">
<section class="container">
<nav>
	<label for="check" class="checkbtn"></label>
	<label class="logo">MockExam</label>
	<ul>
		<li><a href="add">ADD</a></li>
		<li><a href="javascript:document.getElementById('logout').submit()">LOGOUT</a></li>
		<li><a href="*" class="active">HOME</a></li>
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
      <c:forEach var="tempCustomer" items="${customers}">

       <!-- construct an "update" link with customer id -->
       <c:url var="updateLink" value="/updateForm">
        <c:param name="customerId" value="${tempCustomer.slno}" />
       </c:url>

       <!-- construct an "delete" link with customer id -->
       <c:url var="deleteLink" value="/delete">
        <c:param name="customerId" value="${tempCustomer.slno}" />
       </c:url>
       <tr>
        <td class="text-left">${tempCustomer.qn}</td>
        <td class="text-left">${tempCustomer.opt1}</td>
        <td class="text-left">${tempCustomer.opt2}</td>
        <td class="text-left">${tempCustomer.opt3}</td>
        <td class="text-left">${tempCustomer.opt4}</td>
        <td class="text-left">${tempCustomer.ans}</td>

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