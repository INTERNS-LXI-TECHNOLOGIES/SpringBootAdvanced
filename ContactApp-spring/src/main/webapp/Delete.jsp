<!DOCTYPE html>
<html>
<head>
	<title>
		
	</title>
</head>
<body style="background: orange">
  
<%@page import = "com.lxisoft.servlet.*"%>
<%@page import = "com.lxisoft.repository.*"%>
<%@page import = "com.lxisoft.sqlrepository.*"%>
<%@page import = "com.lxisoft.model.*,java.util.*"%>
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



