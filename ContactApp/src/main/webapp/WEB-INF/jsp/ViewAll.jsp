<%@page import="com.lxisoft.controller.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.lxisoft.domain.*"%>
<%@page import="com.lxisoft.model.*"%>
<%@page import="com.lxisoft.repository.*"%>
<%@page import="java.util.*"%>
<%@page import="com.lxisoft.config.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
  <%
	String lang=(String)session.getAttribute("lang");
	International inter=new International();
  %>
<title><%out.println(inter.getLocale("contacts",lang,"IN"));%></title>
<body style="background-color:#E6EC73;">
	<style>
		#b1 {
		  background-color: blue;
		  border-radius: 70%;
		  color: white;
		  padding: 30px;
		  font-size: large;
		 float: right;	
		  margin: 25px 75px;
		}
		#b2{
			background-color: red;
			font-size: larger;
		 float: right;	
		      margin: -2px 75px;
		}
		#b3{
			background-color: red;
			font-size: larger;
		 margin: -1px 75px;
		}
		img{
			vertical-align: middle;
		}
	</style>

  <div>
		<button id="b2" onclick="window.location.href='index.jsp'"><%out.println(inter.getLocale("close",lang,"IN"));%>(X)</button>
	</div>
	

	<select id="b3" name="sample" onchange="javascript:handleSelect(this)">
		<option value="" selected="selected"><%out.println(inter.getLocale("options",lang,"IN"));%></option>
		 <option value="sort?sortType=f"><%out.println(inter.getLocale("firstname",lang,"IN"));%></option>
		 <option value="sort?sortType=l"><%out.println(inter.getLocale("lastname",lang,"IN"));%></option>
		 <option value="<%=request.getContextPath()%>/jsp/Logout.jsp"><%out.println(inter.getLocale("logout",lang,"IN"));%></option>
	</select>

	<form action="search" style="text-align-last: center; padding:4px" method="get">
		<input type="text" name="searchName" placeholder="enter name to search">
		<button type="submit" ><%out.println(inter.getLocale("search",lang,"IN"));%></button>
	</form>
	 
	<script type="text/javascript">
	function handleSelect(elm){
		window.location = elm.value;
	}
	</script>
	
<br>
<table style="border: 0.5px solid #F4714D; background-color: #C4F48A; width: 35%;" align="center" tabindex="center ">
		<tr><td><h1 style="text-align: center; color:initial;"><b>&emsp;&emsp;&emsp;&emsp;<%out.println(inter.getLocale("contacts",lang,"IN"));%></b></h1></td></tr>
	<c:forEach items="${list}" var="contact">
	<tr>
	<td>
	<h2><a style="margin-left: 30px;" href="<%=request.getContextPath()%>/selectContact?selectId=${contact.getId()}&type=s">
	<img src="person.jpg" width="50" height="50">  ${contact.getFName()}&nbsp;${contact.getLName()}</a>
	</h2>
	</td>
		<td><form action="<%=request.getContextPath()%>/selectContact?selectId=${contact.getId()}&type=d">
			 <input type="submit" value="<%=inter.getLocale("delete",lang,"IN")%>" onclick="return confirm('Are you sure you want to delete?')" />
			</form><br></td>
		<td>
		<button onclick="window.location.href='<%=request.getContextPath()%>/selectContact?selectId=${contact.getId()}&type=e'"><%=inter.getLocale("edit",lang,"IN")%></button>
		</td>
		</tr>
	</c:forEach>
</table>

<form action="<%=request.getContextPath()%>/addContact">
 <button id="b1">+</button>
</form>


</body>
</html>