package com.lxisoft.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxisoft.Domain.*;
import com.lxisoft.Repository.DataRepository;

@Controller
public class ContactController {
	

	@Autowired
	DataRepository drr ;
	 
	@RequestMapping(value="/start")
	public ModelAndView ViewAll(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{  
		
		ArrayList<Contact> contactList = drr.displayAll();
		Contact c =new Contact();
		c.setName (request.getParameter("Name"));
		c.setNumber (request.getParameter("Number"));
		
		ModelAndView view = new ModelAndView();
		view.setViewName("ViewAll");
		view.addObject("contacts",contactList);
		System.out.println(contactList.size());
		return view;
	}

//	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
//	{
//		DataRepository drr = new DataRepository(); 
//		List<Contact>contactList=drr.displayAll();
//		request.setAttribute("contact",contactList);
//		RequestDispatcher rd = request.getRequestDispatcher("ViewAll.jsp");
//		rd.forward(request,response);
//	}
	
	@RequestMapping("add")
	public ModelAndView addContact(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		Contact con=new Contact();
		con.setName(request.getParameter("Name"));
		con.setNumber(request.getParameter("Number"));
		Contact c=drr.add(con);
		ModelAndView view = new ModelAndView();
		view.setViewName("GetContact");
		view.addObject("getContact",c);
		return view;
	}
    
}