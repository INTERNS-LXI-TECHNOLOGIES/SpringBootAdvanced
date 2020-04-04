<%@page contentType = "text/html;charset=UTF-8" pageEncoding = "UTF-8"%>
<html>
<link rel="stylesheet" href="Style.css"></link>
<head>
	<meta http-equiv="Content_Type" content="text/html;charset=UTF-8"/>
</head>
<body>
<form>
	<div class = "wrapper">
	
		<div  align="center" style="background-color: tomato;">
			<br>
			<br>
		<h1 style="font-size:50px;">ADMIN</h1>
			<br>
			<br>
		</div>
			<br>
		<div align="center" style="padding-top: 80px;">
		<button formaction="displayAll" class="button">VIEW</button>
		<button formaction="addQuestion" class="button">ADD</button>
		<button formaction="Update.jsp" class="button">UPDATE</button>
		<button formaction="Delete.jsp" class="button">DELETE</button>
		<button formaction="Introduction.jsp" class="button">EXAM START</button> <button formaction="Logout.jsp" class="button">BACK</button>
		<br>
		<br>
	</div> 
</div>
</form>
</body>
