<%@page import="com.lxisoft.domain.*"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%@page import="com.lxisoft.domain.*,com.lxisoft.config.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<style>
	#b1
	{
		margin-left: 200px;
	}
	#b2
	{
		background-color: white;
	    color: black;
	    margin-left: 550px;
	   
	}
	#b3
	{
		background-color: #3CBC8D;
	 	border :none;
	    color: white;
	    height: 10%; 
	    width: 15%;
	}
</style>
</head>
<%
  Localizer lo=new Localizer();
  String lang=(String)session.getAttribute("langu");
%>
<title><%=(lo.getWord("contact",lang,"IN"))%></title>
<body style="background-color: grey">
<a href="home"><input type="button" id="b2" value="<--"></a>
	<%if(request.isUserInRole("admin"))
{%>
	
	<%}
Contact con=(Contact) request.getAttribute("getContactById");

%>
<a href="editContact"><input type="submit" id="b1" value="<%=(lo.getWord("edit",lang,"IN"))%>"></a><br><br><br>
<font size="15">
<center><img src="user-icon-jpg-12.jpg" width="10%" height="10%"> 
<center><%=(con.getContactFirstName())%></center>
<center><%=(con.getContactLastName())%></center>
<center><%=(con.getContactNumber())%></center>
</font>
<%if(request.isUserInRole("admin"))
{%>
<div class="w3-container">
<button onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-black"><%=(lo.getWord("deletecontact",lang,"IN"))%></button>
<div id="id01" class="w3-modal">
    <div class="w3-modal-content">
      <div class="w3-container">
        <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-display-topright">&times;</span>
        <p><%=(lo.getWord("theselectedcontactwillberemoved",lang,"IN"))%></p>
        <form action="delete" method ="get">
			<input type="hidden" name="id" value="<%=(con.getContactId())%>">
			<input type="submit" value="<%=(lo.getWord("deletecontact",lang,"IN"))%>"/>
		</form>
		<button onclick="window.history.back()"><%=(lo.getWord("cancel",lang,"IN"))%></button>
      </div>
    </div>
  </div>
</div>
<%}%>
</body>
</html>
