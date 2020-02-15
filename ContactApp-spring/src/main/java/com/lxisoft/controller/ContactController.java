
package com.lxisoft.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import com.lxisoft.dao.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lxisoft.model.Contact;
import com.lxisoft.service.ContactService;

/**
 * @author Admin
 *
 */
@Controller

public class ContactController
{
	@Autowired
	ContactService service;
	
    @RequestMapping("/Display")
	 public ModelAndView display()
	 { 
		 ArrayList <Contact> contactList = new ArrayList<Contact>();
		 contactList= service.display();
		 ModelAndView model = new ModelAndView("Display");
		 model.addObject("contactList", contactList);
		 return model;
	 }
    @RequestMapping("/Add")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response)
    {
    	Contact contact = new Contact();
		contact.setFirstname(request.getParameter("firstname"));
		contact.setLastname(request.getParameter("lastname"));
		contact.setNumber(request.getParameter("number"));
		service.add(contact);
		System.out.println("contact saved"+contact.getFirstname());
		ArrayList <Contact> contactList = new ArrayList<Contact>();
		contactList= service.display();
		ModelAndView model = new ModelAndView("Display");
		model.addObject("contactList", contactList);
		return model;
		
    }
    @RequestMapping("/Delete")
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)
    {
    	int id=(Integer.parseInt(request.getParameter("id")));
		service.delete(id);
		ArrayList <Contact> contactList = new ArrayList<Contact>();
		contactList= service.display();
		ModelAndView model = new ModelAndView("Display");
		model.addObject("contactList", contactList);
		return model;
    }
    @RequestMapping("/Search")
    public ModelAndView search(HttpServletRequest request, HttpServletResponse response) 
    {
    	String name = request.getParameter("searchname");
 //		Contact contact= new Contact();
		ArrayList <Contact> searchList = new ArrayList<Contact>();
		searchList=service.search(name);
	    
//	   	PrintWriter out=response.getWriter();
	 	request.setAttribute("searchList",searchList);
	 	ModelAndView model = new ModelAndView("Display");
		model.addObject("searchList", searchList);
	 	return model;
    }
    @RequestMapping("/Update")
    public ModelAndView update(HttpServletRequest request, HttpServletResponse response)
    {
    	Contact contact = new Contact();
		contact.setFirstname(request.getParameter("firstname"));
		contact.setLastname(request.getParameter("lastname"));
		contact.setNumber(request.getParameter("number"));
		contact.setId(Integer.parseInt(request.getParameter("id")));
		service.edit(contact);
		ArrayList <Contact> contactList = new ArrayList<Contact>();
		contactList= service.display();
		ModelAndView model = new ModelAndView("Display");
		model.addObject("contactList", contactList);
		return model;
		
    }
}
