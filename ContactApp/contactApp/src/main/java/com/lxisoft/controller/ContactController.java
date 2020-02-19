package com.lxisoft.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.domain.Contact;
import com.lxisoft.service.ContactService;
@Controller
public class ContactController
{  
	@Autowired
    private ContactService contactService;
	
	 @ModelAttribute("listContact")
	 @RequestMapping("/home")
    public ModelAndView getAllContact(ModelAndView model) throws IOException 
    {
		 List<Contact> listContact = contactService.getAllContact();
		 model.addObject("listContact", listContact);
	     model.setViewName("ViewAll");
	     return model;
        
    }
    @RequestMapping(value = "/addcon", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
    	Contact contact = new Contact();
        model.addObject("contact", contact);
        model.setViewName("AddorEditContact");
        return model;
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView saveContact(@ModelAttribute Contact contact) {
    	if (contact.getContactId() == 0)
    	{
    	contactService.addContact(contact);
    	}
//    	else
//    	{
//    		contactService.updateContact(contact);
//    	}
    	 return new ModelAndView("redirect:/home");
    }
//    @RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
//    public ModelAndView deleteContact(HttpServletRequest request) {
//        int contactId = Integer.parseInt(request.getParameter("contactId"));
//        contactService.deleteContact(contactId);
//        return new ModelAndView("redirect:/home");
//    }
//    @RequestMapping(value = "/editContact", method = RequestMethod.GET)
//    public ModelAndView editContact(HttpServletRequest request) {
//        int contactId = Integer.parseInt(request.getParameter("contactId"));
//        Contact contact= contactService.getContact(contactId);
//        ModelAndView model = new ModelAndView("AddorEditContact");
//        model.addObject("contact", contact);
// 
//        return model;
//    }
//    @RequestMapping("/Logout")
//    public String Logout(HttpServletRequest request,HttpServletResponse response)
//	{
//    	HttpSession session=request.getSession(); 
//		session.invalidate();
//		  return "index";
//	}
}