package com.lxisoft.Servlet;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.lxisoft.Repository.*;
import com.lxisoft.Models.*;

import com.lxisoft.Domain.*;


public class EditServlet extends HttpServlet
{
	static MysqlRepository repo=new MysqlRepository();
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		
		HttpSession session=request.getSession();
		Contact c=new Contact();
		c=(Contact) session.getAttribute("users");
		String fName=(String) request.getParameter("newFirstName");
		c.setFirstName(fName);
		String lName=(String) request.getParameter("newLastName");
		c.setLastName(lName);
		String number=(String) request.getParameter("newNo");
		c.setNo(number);
		// PrintWriter out=response.getWriter();
		response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=utf-8");
		repo.editContact(c,1);
		response.sendRedirect("viewall");
		// out.println((Contact) session.getAttribute("users"));

	}
}