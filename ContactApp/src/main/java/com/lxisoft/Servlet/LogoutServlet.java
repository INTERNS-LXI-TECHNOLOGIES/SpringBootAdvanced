package com.lxisoft.Servlet;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.lxisoft.Repository.*;
import com.lxisoft.Models.*;

import com.lxisoft.Domain.*;


public class LogoutServlet extends HttpServlet
{
	static MysqlRepository repo=new MysqlRepository();
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=utf-8");
		session.invalidate();
		response.sendRedirect("viewall");
	}
}
