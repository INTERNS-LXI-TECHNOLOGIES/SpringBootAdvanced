<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>instructions</title>
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

</style>

<div class="container">
<div class="center">

  <font align="center" size="7" color=" midnightblue"><i><b>Welcome User</b></i></font>
  <br>
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
<c:>
  <form>
  <input type="submit" formaction="exam?slno=1" class="button button1" name="next" value="NEXT" >
</form>
</c:>
</div>
</div>
</div>

</body>
</html>