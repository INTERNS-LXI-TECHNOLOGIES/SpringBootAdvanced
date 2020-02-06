package com.lxisoft.Servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.lxisoft.Domain.*;
import com.lxisoft.Repository.*;
import com.lxisoft.Servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/Delete")
public class Delete extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		String id = request.getParameter("id");
		System.out.println(id+"sdkjndivndivnio");
		DataRepository drr = new DataRepository();
		int i=Integer.parseInt(id);
		drr.delete(i);
		RequestDispatcher rs=request.getRequestDispatcher("start");
	 	rs.forward(request,response);                              
	}
}
  
 