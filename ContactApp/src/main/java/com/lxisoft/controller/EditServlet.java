package com.lxisoft.controller;
import com.lxisoft.model.*;
import java.util.*;
import com.lxisoft.repository.*;
import com.lxisoft.domain.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
/**
 *edit servlet class
 */
public class EditServlet extends HttpServlet
{
	Repository repository=new DbRepository();
	/**
	 *dopost method
	 */
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		EditModel editModel=new EditModel();
		HttpSession session=request.getSession();
		SelectModel selectModel=(SelectModel) session.getAttribute("selectModel");
		editModel.setContact(selectModel.getContact());
		String[] newValue=new String[3];
		newValue[0]=(String) request.getParameter("firstName");
		newValue[1]=(String) request.getParameter("lastName");
		newValue[2]=(String) request.getParameter("number");
		repository.edit(editModel,newValue);
		response.sendRedirect("showAll");
	}
}
