package com.lxisoft.controller;
import com.lxisoft.model.*;
import java.util.*;
import com.lxisoft.repository.*;
import com.lxisoft.domain.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
/**
 *sort servlet class
 */
public class SortServlet extends HttpServlet
{
	Repository repository=new DbRepository();
	/**
	 *doGet method
	 */
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		String sortType=request.getParameter("sortType");
		ArrayList<Contact> sortList=repository.sort(sortType);
		request.setAttribute("list",sortList);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/ViewAll.jsp");
		rd.forward(request,response);
	}
}
