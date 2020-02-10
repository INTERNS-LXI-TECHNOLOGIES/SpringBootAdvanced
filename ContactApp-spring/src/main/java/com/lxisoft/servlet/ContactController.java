package com.lxisoft.servlet;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.model.Contact;
import com.lxisoft.repository.Repository;
import com.lxisoft.sqlrepository.Sqlrepository;

@Controller

public class ContactController
{
	Repository rep = (Repository) new Sqlrepository();
	
	@RequestMapping("/Display")
	public ModelAndView doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException
	{

		ArrayList <Contact> contactList = new ArrayList<Contact>();
		contactList= rep.read();
		ModelAndView view=new ModelAndView();
		view.setViewName("Display");
		view.addObject("contactList",contactList);
		return view;
					
	}
}  