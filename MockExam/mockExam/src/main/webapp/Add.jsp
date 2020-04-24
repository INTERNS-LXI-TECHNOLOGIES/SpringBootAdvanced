<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add</title>
</head>
<body bgcolor="FloralWhite">
<style>
      body {
  background-image: url('78.png');
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
  left: 30%;
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
  width: 230%;
  padding: 12px 20px;
  border: 2px solid red;
  border-radius: 4px;
}
</style>
    <div align="center">
        <h1>ADD</h1>
        <form:form action="save" method="post" modelAttribute="exam">
        <table>
            <form:hidden path="slno"/>
            <tr>
                <td>Question:</td>
                <td><form:input path="qn" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" class="button button1" value="ADD"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>