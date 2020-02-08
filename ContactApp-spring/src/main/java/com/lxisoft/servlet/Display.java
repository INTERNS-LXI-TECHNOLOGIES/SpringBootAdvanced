package com.lxisoft.servlet;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import com.lxisoft.repository.*;
import com.lxisoft.model.*;
import com.lxisoft.sqlrepository.*;

public class Display extends HttpServlet
{
	Repository rep = (Repository) new Sqlrepository();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException
	{

		ArrayList <Contact> contactList = new ArrayList<Contact>();
		contactList= rep.read();
		request.setAttribute("contactList",contactList);
		RequestDispatcher rd = request.getRequestDispatcher("Display.jsp");
		rd.forward(request,response);
					
	}
}  