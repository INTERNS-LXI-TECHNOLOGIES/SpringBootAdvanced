<!DOCTYPE html>
<html>
<head>

</head>
<body>
<% session.invalidate(); 
String root= pageContext.getRequest().getServletContext().getContextPath();
response.sendRedirect(root+"/index.jsp");%>

</body>
</html>
