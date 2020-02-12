
package com.lxisoft.servlet;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.model.Contact;

import com.lxisoft.sqlrepository.Sqlrepository;

/**
 * @author Admin
 *
 */
@Controller

public class ContactController
{
	Sqlrepository rep = new Sqlrepository();
    @RequestMapping("/Display")
	 public ModelAndView display()
	 { 
		 ArrayList <Contact> contactList = new ArrayList<Contact>();
		 contactList= rep.read();
		 ModelAndView model = new ModelAndView("Display");
		 model.addObject("contactList", contactList);
		 return model;
	 }
    @RequestMapping("/Add")
    public ModelAndView Add(HttpServletRequest request, HttpServletResponse response)
    {
    	Contact contact = new Contact();
		contact.setFirstname(request.getParameter("firstname"));
		contact.setLastname(request.getParameter("lastname"));
		contact.setNumber(request.getParameter("number"));
		rep.write(contact);
		ArrayList <Contact> contactList = new ArrayList<Contact>();
		contactList= rep.read();
		ModelAndView model = new ModelAndView("Display");
		model.addObject("contactList", contactList);
		return model;
		
    }
}
