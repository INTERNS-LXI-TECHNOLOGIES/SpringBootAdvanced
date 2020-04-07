<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<style>
	.button
	{
		background-color: #4CAF50;
	}
	div
	{
		padding-top: 40px;
		padding-right: 30px;
		padding-left: 80px;
		padding-bottom: 20px;
	}
  </style>
  </head>
<body background="cc.jpg">
<input type = "hidden" name ="indexValue" value ="0">
<div><h1 align="center">MOCKEXAM ${message}</h1>
<center><a href="home"><input type="submit" class="button" value="Opertions"/></a></center>
<h2 align="center">Instructions</h2>
<h4>1.Please read and understand the Test instructions so that you will be able to easily navigate through the Test</h4>
<h4>2. Once you click on the 'Start exam' button the actual test time will begin.</h4>
<h4>3. Only one Question will be displayed on the computer screen at a time. To move to the next question,click on "Next"button.</h4>
<h4>4. You can move between the Test sections to attempt the test section of your choice.</h4>
<h4>5. The questions can be answered in any order. Each question carries 1 mark.</h4>
<h4>6. Once you have answered all the questions please click on the 'Submit' button</h4></div></font>
 
<center><input type="submit" class="button" value="startexam"/></center>

</body>
</html>