<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.adarsh.entity.AffidavitEntity" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Approved Page</title>
</head>
<body>
<div align = "center">
<%AffidavitEntity entity =  (AffidavitEntity)session.getAttribute("mark");
out.println("Name : "+entity.getNameMa());
out.println("Approval : "+entity.getRejectMa());
%>
</div>
</body>
</html>