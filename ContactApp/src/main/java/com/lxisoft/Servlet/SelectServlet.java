package com.lxisoft.Servlet;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.lxisoft.Repository.*;
import com.lxisoft.Models.*;

import com.lxisoft.Domain.*;


public class SelectServlet extends HttpServlet
{
	// public void init()throws ServletExecption
	// {
	// }
        static MysqlRepository repo=new MysqlRepository();
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
   		response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=utf-8");
        try {

        		ArrayList<Contact> contacts=repo.getAllContacts();
        		String type=(String)request.getParameter("type");
        		String name=(String)request.getParameter("name");
        		for(Contact a: contacts)
	            {
	               if(a.getFullName().equalsIgnoreCase(name))
	               {
	                  	HttpSession session=request.getSession();
						session.setAttribute("users",a);
	               }

	            }
	            switch(type)
	            {
	            	case "delete":response.sendRedirect("delete");break;
	                case "edit":  response.sendRedirect("/ContactApp/edit.jsp");break;
	                default:
	            }
        		PrintWriter out=response.getWriter();
        		out.println(name+" "+ type);
        	}catch(Exception e)
        	{

        	}
    }
}