<%@page contentType = "text/html;charset=UTF-8" pageEncoding = "UTF-8"%>
<html>
<head>
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
     width: 900px;
     height: 600px;
     position: relative;
     margin: 3% auto;
     box-shadow: 2px 18px 70px 0px #9d9d9d;
   }
</style>
</head>
<body>
<div class = "wrapper">
	<!-- <div align = "center"> -->
		<div  align="center" style="background-color: darkmagenta;">
			<br>
			<br>
		<h1><font style="font-size:50px;" color="white">WELCOME TO MOCK EXAM</font></h1>
			<br>
			<br>
			</div>
			<br>
			<br>
			<br>
			<br>
<div style="padding-top: 82px;" align="center">
<form>
<button class="button" formaction ="Admin.jsp">ADMIN</button> <button class="button" formaction="Introduction.jsp" >USER</button>
</form>
</div>
</div>
</body>
</html>
