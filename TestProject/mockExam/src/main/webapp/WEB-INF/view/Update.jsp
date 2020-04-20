<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<html>
<head>
  <meta http-equiv="Content_Type" content="text/html;charset=UTF-8"/>
  <title>update</title>
  <link rel="stylesheet" href="Style.css"></link>
</head>
<style>
     body {
  background-image: url('orig_202868.jpg');
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
input[type=text] {
  width: 300%;
  padding: 12px 20px;
  border: 2px solid red;
  border-radius: 4px;
}
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>
<div class="container">
<div class="center">
    <div align="center">
        <font size="6" color="midnightblue"><i><b>Welcome to Update Page</b></i></font><br><br><br>
        <table cellpadding="20">
 			<tr>
            <th>Questions</th>
            <th>Option 1</th>
            <th>Option 2</th>
            <th>Option 3</th>
            <th>Option 4</th>
            <th>Answer</th>
            <th>Action</th>
            </tr>
            <c:forEach items="${listExam}"  var="exam">
                <tr>
 
                    <td>${exam.qn}</td>
                    <td>${exam.opt1}</td>
                    <td>${exam.opt2}</td>
                    <td>${exam.opt3}</td>
                    <td>${exam.opt4}</td>
                    <td>${exam.ans}</td>
                     <td><a href="updateExam?slno=${exam.slno}">update</a></td>
                  
 
                </tr>
            </c:forEach>
        </table>
        <form action="admin">
       <button  class="button button1" onclick="myFunction()" name="done" >DONE</button>
       </form>
               <script>
function myFunction() {
  confirm("successfully updated!");
}
</script>
    </div>
    </div>
    </div>
</body>
</html>