package com.lxisoft.Servlet;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.lxisoft.Repository.*;
import com.lxisoft.Models.*;

import com.lxisoft.Domain.*;


public class DeleteAllServlet extends HttpServlet
{
	static MysqlRepository repo=new MysqlRepository();
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
        response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=utf-8");
		try {
         
         repo.clearAllContacts();
        HttpSession session=request.getSession();
         session.setAttribute("contacts",new ArrayList<ViewListModel>());
         
         response.sendRedirect("viewall");
		PrintWriter out = response.getWriter();
         out.println("<h1>" +"asdfffff"+ "</h1>");
        
         }catch(Exception e)
         {
System.out.println("exception "+e);
         }
    }
}