package com.lxisoft.servlet;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import com.lxisoft.repository.*;
import com.lxisoft.model.*;
import com.lxisoft.sqlrepository.*;

public class Add extends HttpServlet
{
	Repository rep = (Repository) new Sqlrepository();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException
	{
		Contact contact = new Contact();
		contact.setFirstname(request.getParameter("firstname"));
		contact.setLastname(request.getParameter("lastname"));
		contact.setNumber(request.getParameter("number"));
		rep.write(contact);

		System.out.println("contact saved"+contact.getFirstname());
		RequestDispatcher rd = request.getRequestDispatcher("/Display");
		rd.forward(request,response);

	}
}