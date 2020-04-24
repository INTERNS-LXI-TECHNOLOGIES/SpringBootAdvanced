<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>affidavit</title>
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

input[type=text] {
  width: 230%;
  padding: 12px 20px;
  border: 2px solid red;
  border-radius: 4px;
}
</style>
<div class="container">
<div class="center">
    <div align="center">
        <font size="6" color="midnightblue"><i><b>COVID19 Affidavit Request Form</b></i></font><br><br><br>
        <form:form action="saveRequest" method="post" modelAttribute="request">

       <table>
            <form:hidden path="slnoGok"/>
            <tr>
                <td><font size="5" color="midnightblue">name : </font></td>
                <td><form:input path="nameGok" /></td>
            </tr>
             <tr>
                <td><font size="5" color="midnightblue">Address : </font></td>
                <td><form:input path="adressGok" /></td>
            </tr>
             <tr>
                <td><font size="5" color="midnightblue">mob : </font></td>
                <td><form:input path="mobGok" /></td>
            </tr>
             <tr>
                <td><font size="5" color="midnightblue">vehicle number : </font></td>
                <td><form:input path="vechNoGok" /></td>
            </tr>
             <tr>
                <td><font size="5" color="midnightblue">vehicle type : </font></td>
                <td><form:input path="vehTypeGok" /></td>
            </tr>
             <tr>
                <td><font size="5" color="midnightblue">starting location : </font></td>
                <td><form:input path="startGok" /></td>
            </tr>
              <tr>
                <td><font size="5" color="midnightblue">destination : </font></td>
                <td><form:input path="destGok" /></td>
            </tr>
              <tr>
                <td><font size="5" color="midnightblue">starting DNT : </font></td>
                <td><form:input path="startDateAndTimeGok" /></td>
            </tr>
              <tr>
                <td><font size="5" color="midnightblue">ending DNT : </font></td>
                <td><form:input path="endDateAndTimeGok" /></td>
            </tr>
              <tr>
                <td><font size="5" color="midnightblue">co passenger name : </font></td>
                <td><form:input path="copassGok" /></td>
            </tr>
              <tr>
                <td><font size="5" color="midnightblue">relation : </font></td>
                <td><form:input path="relatnGok" /></td>
            </tr>
              <tr>
                <td><font size="5" color="midnightblue">reason : </font></td>
                <td><form:input path="reasonGok" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" onclick="myFunction()" class="button button1" value="SUBMIT"></td>
            </tr>
        </table>
        </form:form>
        <script>
function myFunction() {
  confirm("successfully submitted!");
}
</script>
    </div>
    </div>
    </div>
</body>
</html>