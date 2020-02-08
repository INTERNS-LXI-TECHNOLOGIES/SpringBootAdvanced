package com.lxisoft.servlet;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import com.lxisoft.repository.*;
import com.lxisoft.model.*;
import com.lxisoft.sqlrepository.*;

public class Delete extends HttpServlet
{
	Repository rep = (Repository) new Sqlrepository();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException
	{
		int id=(Integer.parseInt(request.getParameter("id")));
		rep.delete(id);
		RequestDispatcher rd = request.getRequestDispatcher("/Display");
		rd.forward(request,response);

	}
}