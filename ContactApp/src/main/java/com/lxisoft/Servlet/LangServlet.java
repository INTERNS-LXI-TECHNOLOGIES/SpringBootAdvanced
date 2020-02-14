package com.lxisoft.Servlet;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.lxisoft.Repository.*;
import com.lxisoft.Models.*;

import com.lxisoft.Domain.*;


public class LangServlet extends HttpServlet
{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("lang");
		HttpSession session=request.getSession();
		session.setAttribute("lang",name);
		response.sendRedirect("viewall");
		
	}
}
