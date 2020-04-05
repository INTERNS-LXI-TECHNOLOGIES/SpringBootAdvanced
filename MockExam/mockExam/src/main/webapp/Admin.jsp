<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminMenu</title>
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
  height: 700px;
  position: relative;
  border: 5px solid midnightblue;
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

.button3 {
  background-color: white; 
  color: black; 
  border: 2px solid #f44336;
  border-radius: 12px;
}

.button3:hover {
  background-color: #f44336;
  color: white;
}

.button4 {
  background-color: white;
  color: black;
  border: 2px solid #e7e7e7;
  border-radius: 12px;
}

.button4:hover {background-color: #e7e7e7;}

.button5 {
  background-color: white;
  color: black;
  border: 2px solid #555555;
  border-radius: 12px;
}

.button5:hover {
  background-color: #555555;
  color: white;
}
</style>

<div class="container">
<div class="center">

<center>
  <font size="7" color=" midnightblue"><i><b>Welcome To AdminMenu</b></i></font>
  <br>
  <br>
  <font size="6" color=" midnightblue">Choose From The Following</font>
  <br>
  <br>
  <form>
  <input type="submit" formaction="add" class="button button1" name="ADD" value="ADD" >
  <input type="submit" formaction="delete" class="button button2" name="DELETE" value="DELETE" >
  <input type="submit" formaction="update" class="button button3" name="UPDATE" value="UPDATE" >
  <input type="submit" formaction="display" class="button button4" name="DISPLAY" value="DISPLAY">
  <input type="submit" formaction="index.jsp" class="button button5" name="BACK" value="BACK" >
</form>
</center>
</div>
</div>
</div>

</body>
</html>