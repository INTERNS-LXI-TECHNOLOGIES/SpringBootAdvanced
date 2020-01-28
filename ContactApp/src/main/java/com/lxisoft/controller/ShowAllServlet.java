package com.lxisoft.controller;
import com.lxisoft.model.*;
import java.util.*;
import com.lxisoft.repository.*;
import com.lxisoft.domain.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
/**
 *show all servlet class
 */
public class ShowAllServlet extends HttpServlet
{
	Repository repository=new DbRepository();
	/**
	 *doGet method
	 */
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		ArrayList<Contact> contactList=new ArrayList<Contact>();
		contactList=repository.findAll();
		request.setAttribute("list",contactList);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/ViewAll.jsp");
		rd.forward(request,response);
	}
}
