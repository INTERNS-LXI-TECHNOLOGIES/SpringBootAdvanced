<!DOCTYPE html>
<html>
<%@page contentType="text/html;charset=UTF-8" pageEncoding = "UTF-8"%>
<head>
  <meta http-equiv="Content_Type" content="text/html;charset=UTF-8"/>
  <title>sample project</title>
  <link rel="stylesheet" href="Style.css"></link>
</head>
<body bgcolor="FloralWhite">
<style>
   body {
  background-image: url('full-hd-colourful-download-trees-simple-jpg.jpg');
    background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  height: 100%
}
.container {
  height: 730px;
  position: relative;
  border: 5px solid midnightblue;
}
.center {
  margin: 0;
  position: absolute;
  top: 25%;
  left: 30%;
  -ms-transform: translate(-30%, -30%);
  transform: translate(-20%, -20%);
}
.button_css
{
	background-color: #3cb371;
  color: white;
  width: 150px;
  height: 40px;
  border-radius: 12px;
   display: inline-block;
  font-size: 16px;
  text-decoration: none;
}
</style>
<div class="container">
<div class="center">
<p>
  <% int mark=Integer.parseInt(session.getAttribute("Result").toString());%>
<h1><font color="midnightblue">Welcome To Result Page!!!</font></h1>
<h1><font color="midnightblue">your Score :<%out.println(mark); %></font></h1>
<br>
<br>
<h1><font color="midnightblue">Have a good Day</font></h1>
</p>

</div>
</div>
<%   %>
</body>
</html>