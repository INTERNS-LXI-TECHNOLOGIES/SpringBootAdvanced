<%@page import = "com.lxisoft.controller.*"%>
<%@page import = "com.lxisoft.repository.*"%>
<%@page import = "com.lxisoft.model.*,java.util.*"%>
<%
session.invalidate();
response.sendRedirect("Display");
%>
