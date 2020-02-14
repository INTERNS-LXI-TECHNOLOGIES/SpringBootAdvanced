package com.lxisoft.Servlet;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.lxisoft.Repository.*;
import com.lxisoft.Models.*;

import com.lxisoft.Domain.*;


public class SortServlet extends HttpServlet
{
	static MysqlRepository repo=new MysqlRepository();
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
   		response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=utf-8");
        try {

        		ArrayList<Contact> contacts=repo.getAllContacts();
        		String type=(String)request.getParameter("sort");
        		switch(type)
        		{
        		case "first" : repo.sortByFirstName();break;
        		case "last" : repo.sortByLastName();break;
        		case "id" : repo.sortById();break;
        		}
        		response.sendRedirect("viewall");
        		PrintWriter out=response.getWriter();
        		out.println(type);

        	}catch(Exception e)
        	{

        	}
    }
}