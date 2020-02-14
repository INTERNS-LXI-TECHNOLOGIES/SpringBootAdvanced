package com.lxisoft.Servlet;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.lxisoft.Repository.*;
import com.lxisoft.Models.*;

import com.lxisoft.Domain.*;


public class SearchServlet extends HttpServlet
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
            Contact contact=null;
            String name=(String)request.getParameter("user");
            HttpSession session=request.getSession();
            // session.setAttribute("use",a);
            // ViewListModel cont=(ViewListModel)session.getAttribute("use");
            ArrayList<Contact> contacts=repo.getAllContacts();
            ArrayList<Contact> users=new ArrayList<Contact>();
            ArrayList<Contact> dupUsers=new ArrayList<Contact>();
            for(Contact a: contacts)
            {
               if(a.getFullName().equalsIgnoreCase(name))
               {
                  users.add(a);
               }

            }
            if(users.size()==1)
            {
               session.setAttribute("users",users.get(0));
               request.getRequestDispatcher("user.jsp").forward(request, response);

            }
            else
            {
                for(Contact a: contacts)
               {
                  if((a.getFullName().toLowerCase()).contains(name.toLowerCase()))
                  {
                     dupUsers.add(a);
                  }

               }
               for(Contact a: dupUsers)
               {
            PrintWriter out = response.getWriter();
            out.println(a.getFullName());}
            }
             if(dupUsers.size()!=0) 
               {
                 ViewList view=new ViewList();
                  ArrayList<ViewListModel> listView=null;
                  view.clearArray();
                  for(int i=0;i<dupUsers.size();i++)
                  {
                     view.setContact(dupUsers.get(i));
                  }
                  listView=view.getAllContacts();
                  session.setAttribute("contacts",listView);
                  request.setAttribute("search",true);
                  request.getRequestDispatcher("main.jsp").forward(request, response);
               }
               else
               {
                  session.setAttribute("contacts",new ArrayList<ViewListModel>());
                  request.getRequestDispatcher("main.jsp").forward(request, response);
               }
            }catch(Exception e)
         {
            System.out.println("exception "+e);
         }

      	// out.println("<h1>" + request.getParameter("name")+ "</h1>");
	}
}