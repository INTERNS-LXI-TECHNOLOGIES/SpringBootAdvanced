package com.lxisoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lxisoft.repository.*;
import com.lxisoft.service.ContactService;
import com.lxisoft.model.*;
import com.lxisoft.domain.*;
@Controller
public class ContactController
{  
	private ContactService  serv;
	@RequestMapping("/home")
	public ModelAndView getAllContactInfo()
	{
		serv=new ContactService();
		List<ContactModel> contact=serv.getAllContact();
		ModelAndView view = new ModelAndView();
		view.setViewName("ViewAll");
		view.addObject("allContact",contact);
		return view;
	}
	
	@RequestMapping("/addcon")
	public String createContact()
	{
		return "AddContact";
	}
	@RequestMapping(value ="/add", method = RequestMethod.POST)
	public ModelAndView addContact(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		serv=new ContactService();
		Contact cont=new Contact();
		cont.setContactFirstName(request.getParameter("first name"));
		cont.setContactLastName(request.getParameter("last name"));
		cont.setContactNumber(request.getParameter("number"));
		Contact c=serv.addContact(cont);
		ModelAndView view = new ModelAndView();
		view.setViewName("GetContactById");
		view.addObject("getContactById",c);
		return view;
	}
	@RequestMapping("/getContact")
	public String getContact(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		serv=new ContactService();
		String id=request.getParameter("id");
		int idd=Integer.parseInt(id);
		Contact contact=serv.getContact(idd);
		request.setAttribute("getContactById",contact);
		HttpSession session=request.getSession(); 
		session.setAttribute("cont",contact);
		String rd=null;
		String value=request.getParameter("crud");
		switch(value)
		{
			case "2":rd="GetContactById"; break;
			case "3":rd="EditContact"; break;
			case "4":rd="DeleteContact"; break;
		}
		return rd;
	}
	@RequestMapping("/delete")
	public String delete()
	{
		return "DeleteContact";
	}
	@RequestMapping("/editContact")
	public String edit()
	{
		return "EditContact";
	}
}