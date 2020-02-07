package com.lxisoft.Servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.lxisoft.Domain.*;
import com.lxisoft.Repository.*;
import javax.servlet.annotation.*;
@WebServlet("/update")

public class update extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String number = request.getParameter("number");
		DataRepository drr = new DataRepository();
		int i=Integer.parseInt(id);
		Contact c=drr.edit(i,name,number);
		request.setAttribute("contact",c);
		RequestDispatcher rs=request.getRequestDispatcher("Contact.jsp");
		rs.forward(request,response);
    }
}