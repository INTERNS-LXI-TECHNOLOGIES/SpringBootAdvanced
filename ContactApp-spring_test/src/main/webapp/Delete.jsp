<!DOCTYPE html>
<html>
<head>
	<title>
		
	</title>
</head>
<body style="background: orange">
  
<%@page import = "com.lxisoft.controller.*"%>
<%@page import = "com.lxisoft.dao.*"%>
<%@page import =" java.util.*"%>
<%@page import = "com.lxisoft.controller.*"%>
<%@page import = "java.util.ArrayList"%>
<%@page import ="com.lxisoft.dao.*"%>

<form action="Delete" method="get">
	<% String id= request.getParameter("id");%>
	 <input type="hidden" name="id" value="<%=id%>">
	<center>
		 <h1>
		 Are you sure?  <br>
		</h1>
		<button onclick="window.location.href='Display'">YES</button>	 
	</center>
	</form>
<center><br>
	
		<button onclick="goBack()">NO</button>
		<script>
		function goBack()
		 {
		   window.history.back();
		}
		</script>
</center>
	
</body>
</html>



