<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  border: 2px solid #56baed;
  border-radius: 12px;
}

.button1:hover {
  background-color: #56baed;
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
}
</style>

<section class="container">

<nav>
	<label for="check" class="checkbtn"></label>
	<label class="logo">MockExam</label>
</nav>

<div class="center">
<div class="login-header">
    <h1>welcome user</h1>
  </div>
  <br>
  <font size="6" color=" midnightblue">Read The Instructions Carefully</font>
  <br>
  <br>
  <ol>
 <h2><font color="midnightblue"><li>mobile phones are not allowed</li></font> </h2>
 <h2><font color="MidnightBlue"><li>any malpractice wil lead to debar</li></font></h2>
 <h2><font color="MidnightBlue"><li>helps will be provided by invigilatores</li></font></h2>
 <h2><font color="MidnightBlue"><li>total time allowed is 20 minutes</li></font></h2>
 <h2><font color="MidnightBlue"><li>keep calm and be quiet</li></font></h2>
</ol>
<br>
<br>
<c:>
  <form>
  <input type="hidden" name = "qcount" value = "0" >
  <input type="submit" formaction="exam" class="button button1" name="next" value="NEXT" >
</form>
</c:>
</div>
</section>

</body>
</html>