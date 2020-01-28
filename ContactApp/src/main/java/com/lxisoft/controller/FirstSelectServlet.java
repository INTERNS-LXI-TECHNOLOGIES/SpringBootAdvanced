
package com.lxisoft.controller;
import com.lxisoft.model.*;
import java.util.*;
import com.lxisoft.repository.*;
import com.lxisoft.domain.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
/**
 *first select servlet class
 */
public class FirstSelectServlet extends HttpServlet
{
	/**
	 *doGet method
	 */
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		HttpSession session=request.getSession();
		String selectId=(String) request.getParameter("selectId");
		Repository repository=new DbRepository();
		ArrayList<Contact> contactList=new ArrayList<Contact>();
		contactList=repository.findAll();
		SelectModel selectModel=new SelectModel();

		for(Contact contact:contactList)
		{
			if(contact.getId().equals(selectId))
				selectModel.setContact(contact);
		}
		session.setAttribute("selectModel",selectModel);
		String type=(String) request.getParameter("type");
		if(type.equals("e"))
			response.sendRedirect("jsp/Edit.jsp");
		else if(type.equals("d"))
			response.sendRedirect("deleteContact");
		
	}
}