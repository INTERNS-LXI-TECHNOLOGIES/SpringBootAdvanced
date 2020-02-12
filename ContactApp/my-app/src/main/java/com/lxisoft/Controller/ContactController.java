package com.lxisoft.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value="add")
	public void addContact(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		Contact con=new Contact();
		con.setName(request.getParameter("name"));
		con.setNumber(request.getParameter("number"));
        response.sendRedirect("start");
	}
	
	@RequestMapping(value="Delete" )
	public void deleteContact(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{   
		String id = request.getParameter("id");
		int i=Integer.parseInt(id);
		drr.delete(i);
		response.sendRedirect("start");
		
    }
	
	@RequestMapping(value="Edit", method =RequestMethod.POST)
	public ModelAndView editContact(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String number = request.getParameter("number");
		int i=Integer.parseInt(id);
		Contact c=drr.edit(i,name,number);
	//	response.sendRedirect("start");
		
		ModelAndView view = new ModelAndView();
		view.setViewName("Edit");
		view.addObject("contacts",c);
				return view;
	}
} 