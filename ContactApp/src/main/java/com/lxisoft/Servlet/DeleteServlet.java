package com.lxisoft.Servlet;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.lxisoft.Repository.*;

import com.lxisoft.Models.*;
import com.lxisoft.Domain.*;


public class DeleteServlet extends HttpServlet
{
	static MysqlRepository repo=new MysqlRepository();
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
        response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=utf-8");
		try {
         HttpSession session=request.getSession();
         Contact contact=(Contact) session.getAttribute("users");
         repo.deleteContact(contact);
        ArrayList<Contact> contacts=repo.getAllContacts();
        // HttpSession session=request.getSession();
        ViewList view=new ViewList();
        ArrayList<ViewListModel> listView=null;
        view.clearArray();
        for(int i=0;i<contacts.size();i++)
        {
            view.setContact(contacts.get(i));
        }
        listView=view.getAllContacts();
         session.setAttribute("contacts",listView);
         request.getRequestDispatcher("main.jsp").forward(request, response);
		// PrintWriter out = response.getWriter();
         // out.println("<h1>" +"asdfffff"+ "</h1>");
        
         }catch(Exception e)
         {
System.out.println("exception "+e);
         }
    }
}