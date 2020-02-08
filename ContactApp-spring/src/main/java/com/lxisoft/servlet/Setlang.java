package com.lxisoft.servlet;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import com.lxisoft.repository.*;
import com.lxisoft.model.*;
import com.lxisoft.sqlrepository.*;

public class Setlang extends HttpServlet
{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException
	{
		String locallang = (String)request.getParameter("lang");
		 HttpSession session = request.getSession();
		session.setAttribute("locallang",locallang);
		RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
		rd.forward(request,response);

    }
}
