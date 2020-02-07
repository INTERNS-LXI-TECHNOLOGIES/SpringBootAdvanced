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
import com.lxisoft.model.*;
import com.lxisoft.domain.*;
@Controller
public class ContactController
{
	@RequestMapping("/home")
	public ModelAndView getAllContact()
	{
		MysqlRepository dbrepo=new MysqlRepository();
		List<Contact>contactList=dbrepo.findAllContact();
		ContactListModel listModel=new ContactListModel();
	
		for(int i=0;i<contactList.size();i++)
	    {
	    	ContactModel contact=new ContactModel();
	    	contact.setId(contactList.get(i).getContactId());
	    	contact.setFirstName(contactList.get(i).getContactFirstName());
	    	contact.setLastName(contactList.get(i).getContactLastName());
	    	listModel.setContactListModel(contact);
	    }
		ModelAndView view = new ModelAndView();
		view.setViewName("ViewAll");
		view.addObject("allContact",listModel.getContactListModel());
		return view;
	}
	
	@RequestMapping(value ="/add", method = RequestMethod.POST)
	public ModelAndView addContact(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		Contact cont=new Contact();
		cont.setContactFirstName(request.getParameter("first name"));
		cont.setContactLastName(request.getParameter("last name"));
		cont.setContactNumber(request.getParameter("number"));
		MysqlRepository dbrepo=new MysqlRepository();
		Contact c=dbrepo.saveContact(cont);
		ModelAndView view = new ModelAndView();
		view.setViewName("GetContactById");
		view.addObject("getContactById",c);
		return view;
	}
	@RequestMapping("/getContact")
	public String getContact(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		MysqlRepository dbrepo=new MysqlRepository();
		String id=request.getParameter("id");
		int idd=Integer.parseInt(id);
		Contact contact=dbrepo.findContactById(idd);
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
}