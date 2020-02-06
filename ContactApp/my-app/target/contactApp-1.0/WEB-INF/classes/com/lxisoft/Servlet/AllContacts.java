package com.lxisoft.Servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.lxisoft.Repository.*;
import com.lxisoft.Domain.*;
public class AllContacts extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		DataRepository drr = new DataRepository(); 
		List<Contact>contactList=drr.displayAll();
		request.setAttribute("contact",contactList);
		RequestDispatcher rd = request.getRequestDispatcher("ViewAll.jsp");
		rd.forward(request,response);
	}
}