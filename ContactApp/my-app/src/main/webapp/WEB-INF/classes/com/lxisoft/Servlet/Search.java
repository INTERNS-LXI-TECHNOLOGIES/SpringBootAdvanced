package com.lxisoft.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.lxisoft.Domain.*;
import com.lxisoft.Repository.*;
import javax.servlet.annotation.*;
@WebServlet("/Search")
public class Search extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		DataRepository drr = new DataRepository();
		String name=request.getParameter("name");
		List<Contact>contact=new ArrayList<Contact>();
		List <Contact> contactList=drr.displayAll();
		
		for(int i=0;i<contactList.size();i++)
		{
		   String nameb = (contactList.get(i).getName());
           if(name.contains(nameb))
		     {
			   contact.add(contactList.get(i));
		     }
		}
         request.setAttribute("search",contact);
		 RequestDispatcher rs=request.getRequestDispatcher("search.jsp");
	 	 rs.forward(request,response);
    }
}

