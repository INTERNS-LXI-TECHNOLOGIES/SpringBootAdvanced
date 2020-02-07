<%@page import="com.lxisoft.domain.*"%>
<%@page import="com.lxisoft.model.*"%>
<%@page import="com.lxisoft.config.*"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%@page import="com.lxisoft.domain.*,com.lxisoft.config.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<head>
<html>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<style>
	#b1
	{
		background-color: green;
	    color: white;
	    margin: 8px 0;
	    border: none;
	    box-sizing: border-box;
	    width: 100;
	}
	#b2
	{
		background-color: #3CBC8D;
	    color: white;
	    margin-left: 1000px;
	    border-radius: 50%;
	    height: 5%; 
	    width: 3%;
	}
	#b3
	{
		background-color: black;
	 	border :none;
	    color: white;
	    height: 10%; 
	    width: 50%;
	}
</style>
<%
  Localizer lo=new Localizer();
  String lang=(String)session.getAttribute("langu");
%>
<title><%=(lo.getWord("contacts",lang,"IN"))%></title>
</head>

<h1><center><%=(lo.getWord("contactlist",lang,"IN"))%></center></h1>
<body style="background-color: white">
    <%
	if(request.isUserInRole("admin"))
	{%>
	<a href="AddContact.jsp"><input type="submit" id="b2"name="submit" value="+" /></a>
	<%}%>
	<form action= "sort" method="get">
	<select name="sort">
    <option value="1"><%=(lo.getWord("byname",lang,"IN"))%></option>
    <option value="2"><%=(lo.getWord("bynumber",lang,"IN"))%></option>
    <option value="3"><%=(lo.getWord("byid",lang,"IN"))%></option>
    <input type="submit" name="submit" value="<%=(lo.getWord("sort",lang,"IN"))%>"/>
  </select>
</form>
	<%
	List<ContactModel> c=(List<ContactModel>) request.getAttribute("allContact");
	%>
	<form action= "search" method="get">
	<table align="center" border="1" width="10%" height="5%" >
		<tr>
			<td><input type="text" name="name" placeholder="<%=(lo.getWord("search",lang,"IN"))%>"/>
		
			<a href="search"><input type="submit" value="<%=(lo.getWord("submit",lang,"IN"))%>"></a></td>
		</tr>
	</table>
</form>
	<table align="center" width="60%"  border color= "blue" bgcolor="#3CBC8D">
		<tr>
			<th><%=(lo.getWord("contacts",lang,"IN"))%></th>
		</tr>
<%
for(int i=0;i<c.size();i++)
{
%>
		<form action= "getContact" method="get">
		<input type="hidden" name="id" value="<%=(c.get(i).getId())%>"/>
	<tr>
		<td>
			<img src="user-icon-jpg-13.jpg" width="20%" height="30%"> 
		<input type="submit" id="b1" value="<%=(c.get(i).getFirstName())%>&nbsp;<%=(c.get(i).getLastName())%>"/>
		<input type="hidden" name="crud" value="2"/>
</form>
	</td>
		<td>
			<%if(request.isUserInRole("admin"))
			{%>
			<div class="w3-container">
			<button onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-black"><%=(lo.getWord("delete",lang,"IN"))%></button>
			<div id="id01" class="w3-modal">
			    <div class="w3-modal-content">
			      <div class="w3-container">
			        <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-display-topright">&times;</span>
			        <p><%=(lo.getWord("theselectedcontactwillberemoved",lang,"IN"))%></p>
			        <form action="delete" method ="get">
						<input type="hidden" name="id" value="<%=(c.get(i).getId())%>">
						<input type="submit" value="<%=(lo.getWord("deletecontact",lang,"IN"))%>"/>
					</form>
					<a href="home"><%=(lo.getWord("cancel",lang,"IN"))%></a>
			      </div>
			    </div>
			  </div>
			</div>
			<form action= "getContact" method="get">
				<input type="hidden" name="id" value="<%=(c.get(i).getId())%>"/>
				<input type="submit" id="b3" value="<%=(lo.getWord("edit",lang,"IN"))%>">
				<input type="hidden" name="crud" value="3"/>
			</form>
			<%}%>
		</td>
	</tr>
<%
}
%>
<form action="Logout" method="post">
    <input type="submit" value="Logout">
</form>
</table>
</body>
</html>