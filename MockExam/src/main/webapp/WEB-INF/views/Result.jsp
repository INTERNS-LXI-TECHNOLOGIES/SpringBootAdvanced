<!DOCTYPE html>
<%@page import="com.lxisoft.controller.*"%>
<%@page import="com.lxisoft.model.*"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<html>
<head>
  <title>Result</title> 
<style>
.container {
  height: 700px;
  position: relative;
  border: 5px solid oldlace;
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
  background-color: midnightblue;
  color: white;
  width: 150px;
  height: 40px;
}

</style>
</head>
<body>
  <h1>Result</h1>
 <h1 align=center>
  <%int m=(int) session.getAttribute("Mark");
  out.println("Mark:"+m);
  %><br>
  <br>
  <%
  if(m>=5)
  {
   out.println("PASSED");
  }
  else
  {
   out.println("FAILED"); 
  }%>
</h1>
</font>
<center><a href="index.jsp">Back</a></center>
</div>
</body>
           </html>