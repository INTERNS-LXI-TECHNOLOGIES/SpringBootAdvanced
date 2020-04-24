<!DOCTYPE html>
<html>
<%@page contentType="text/html;charset=UTF-8" pageEncoding = "UTF-8"%>
<head>
  <meta http-equiv="Content_Type" content="text/html;charset=UTF-8"/>
  <title>sample project</title>
</head>
<body bgcolor="FloralWhite">
<style>
   body {
  background-image: url("resources/images/78.png");
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
<br>
<br>
  <form>
  <input type="submit" formaction="index.jsp" class="button button1" name="done" value="DONE" >
 </form>
</p>
</div>
</div>
<%   %>
</body>
</html>