package com.lxisoft.Servlet;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.lxisoft.Models.*;
import com.lxisoft.Repository.*;

import com.lxisoft.Domain.*;


public class ViewServlet extends HttpServlet
{
	// public void init()throws ServletExecption
	// {
	// }
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
      response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=utf-8");
   		
   		MysqlRepository repo= new MysqlRepository();
         try {
         ArrayList<Contact> contacts=repo.getAllContacts(); 
         ViewList view=new ViewList();
         ArrayList<ViewListModel> listView=null;
         if(contacts!=null)
         {
            view.clearArray();
            for(int i=0;i<contacts.size();i++)
            {
               view.setContact(contacts.get(i));
            }
            listView=view.getAllContacts();
         }
   		PrintWriter out = response.getWriter();
         // fosr(Contact a: contacts)
         // out.println("<h1>"+a.getName()+"</h1>");
         HttpSession session=request.getSession();
         session.setAttribute("contacts",listView);
   		// request.setAttribute("contacts",listView);
           response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=utf-8");
   		response.sendRedirect("main.jsp");
   		}catch(Exception e)
         {
System.out.println("exception "+e);
         }
      	// out.println("<h1>" + request.getParameter("name")+ "</h1>");
	}
}