package com.lxisoft.Servlet;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.lxisoft.Repository.*;
import com.lxisoft.Models.*;

import com.lxisoft.Domain.*;
/**
*class to add a contact
*/

public class ContactAddServlet extends HttpServlet
{

        static MysqlRepository repo=new MysqlRepository();

        /**
        *
        */
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
      response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=utf-8");
   		
         try {
             boolean exist=true;
         HttpSession session=request.getSession();
         Contact contact=new Contact();
   		contact.setFirstName(request.getParameter("firstname"));
         contact.setLastName(request.getParameter("lastname"));
         contact.setNo(request.getParameter("number"));
         ArrayList<Contact> contacts=repo.getAllContacts();
         for(Contact c:contacts)
         {
            if(c.getFullName().toLowerCase().equals(contact.getFullName().toLowerCase()))
            {
               exist=false;
         
            }
         }
         if(exist==false)
            {
               String name=contact.getFullName();
               request.setAttribute("newcontacts",name);
               request.getRequestDispatcher("addnew.jsp").forward(request, response);
            }
         else
         {
            request.setAttribute("newcontacts",new Contact());
            repo.writeNewContact(contact,true);
            contacts=repo.getAllContacts();

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
            session.setAttribute("contacts",listView);
            request.getRequestDispatcher("main.jsp").forward(request, response);
            // PrintWriter out = response.getWriter();
            // out.println("<h1>" +contact.getName()+ "</h1>");
         }
         }catch(Exception e)
         {
System.out.println("exception "+e);
         }
      	
	}
}