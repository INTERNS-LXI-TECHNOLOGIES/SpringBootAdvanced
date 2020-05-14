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
</head>
<body>
<style>
	html {
  background-color:white;

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
  color:#56baed;
  font-family: 'Helvetica Neue', sans-serif;
  letter-spacing: -1px;
  text-align:center;
  font-size:250%;
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
		table, th, td {
  border: 3px solid black;
  border-collapse: collapse;
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
</style>
<div class="wrapper fadeInDown">
<section class="container">
<nav>
	<label for="check" class="checkbtn"></label>
	<label class="logo">MockExam</label>
	<ul>
		<li><a href="javascript:document.getElementById('logout').submit()">LOGOUT</a></li>
		<li><a href="welcome" class="active">HOME</a></li>
	</ul>
</nav>
<br>
        <% ArrayList<Customer> model=new ArrayList<Customer>();
        model =(ArrayList<Customer>)session.getAttribute("exam"); 
        int qcount = Integer.parseInt(request.getParameter("qcount"));
        int size=model.size();
         if(qcount != size) {

        %><font size="5"  color="midnightblue"> <%out.println("<h1>Question :"+(qcount + 1)+"."+model.get(qcount).getQn()+"</h1>");
           %>
           <br>
           <div align="center">
           <form action="start" method="get" name="qform">
        <input type="radio" name="opt" value="1"/>
          <label for="1"><font size="4"  color="midnightblue"><% out.println(model.get(qcount).getOpt1());%></label></font>
          <input type="radio" name="opt" value="2"/>
          <label for="2"><font size="4"  color="midnightblue"><% out.println(model.get(qcount).getOpt2());%></label></font>
         <input type="radio" name="opt" value="3"/>
          <label for="3"><font size="4"  color="midnightblue"><% out.println(model.get(qcount).getOpt3());%></label></font>
         <input type="radio" name="opt" value="4"/>
          <label for="4"><font size="4"  color="midnightblue"><% out.println(model.get(qcount).getOpt4());%></label></font>
            <%qcount++; %>
            <input type="hidden" name="qcount" value= <%out.println(qcount);%>/>
            <input type="submit" class="button button1"   value="<%out.println("next");%>" />
          </form>
          <%    
         } else {

             response.sendRedirect("result");
             

      } %>
    </div>
</section>
</div>
</body>
</html>