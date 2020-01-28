package com.lxisoft.controller;
import com.lxisoft.model.*;
import java.util.*;
import com.lxisoft.repository.*;
import com.lxisoft.domain.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
/**
 *search servlet class
 */
public class SearchServlet extends HttpServlet
{
	Repository repository=new DbRepository();
	/**
	 *doGet method
	 */
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		String searchName=request.getParameter("searchName");
		ArrayList<Contact> searchList=repository.search(searchName);
		request.setAttribute("list",searchList);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/ViewAll.jsp");
		rd.forward(request,response);
	}
}
