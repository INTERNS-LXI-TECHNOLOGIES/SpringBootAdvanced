<%@page contentType = "text/html;charset=UTF-8" pageEncoding = "UTF-8"%>
<html>
<link rel="stylesheet" href="Style.css"></link>
<head>
	<meta http-equiv="Content_Type" content="text/html;charset=UTF-8"/>
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
<form>
	<div class = "wrapper">
	<!-- <div align = "center"> -->
		<div  align="center" style="background-color: darkmagenta;">
			<br>
			<br>
		<h1 style="font-size:50px;">!! WELCOME ADMIN !!</h1>
			<br>
			<br>
		</div>
			<br>
		<div align="center" style="padding-top: 80px;">
		<button formaction="displayAll" class="button">VIEW</button>
		<button formaction="addQuestion" class="button">ADD</button>
		<button formaction="Update.jsp" class="button">UPDATE</button>
		<button formaction="Delete.jsp" class="button">DELETE</button>
		<button formaction="Introduction.jsp" class="button">TEST EXAM</button> <button formaction="/" class="button">BACK</button>
		<br>
		<br>
	</div> 
</div>
</form>
</body>
</html>