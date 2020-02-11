package com.lxisoft.Servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxisoft.Repository.DataRepository;

/*import javax.servlet.annotation.*;
@WebServlet("/Delete")*/
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
  
 