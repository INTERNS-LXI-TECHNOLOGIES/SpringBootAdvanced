package com.lxisoft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
 
    @RequestMapping("/home")
    public ModelAndView listContact(ModelAndView model) throws IOException {
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
    	else
    	{
    		contactService.updateContact(contact);
    	}
    	 return new ModelAndView("redirect:/home");
    }
    @RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) {
        int contactId = Integer.parseInt(request.getParameter("contactId"));
        contactService.deleteContact(contactId);
        return new ModelAndView("redirect:/home");
    }
    @RequestMapping(value = "/editContact", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int contactId = Integer.parseInt(request.getParameter("contactId"));
        Contact contact= contactService.getContact(contactId);
        ModelAndView model = new ModelAndView("AddorEditContact");
        model.addObject("contact", contact);
 
        return model;
    }
//	@RequestMapping("/home")
//	public ModelAndView getAllContactInfo()
//	{
//		ContactService serv=new ContactService();
//		List<Contact> contact=serv.getAllContact();
//		ModelAndView view = new ModelAndView();
//		view.setViewName("ViewAll");
//		view.addObject("allContact",contact);
//		return view;
//	}
	
//	@RequestMapping("/addcon")
//	public String createContact()
//	{
//		return "AddContact";
//	}
//	@RequestMapping(value ="/add", method = RequestMethod.POST)
//	public ModelAndView addContact(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
//	{
//		ContactService serv=new ContactService();
//		Contact cont=new Contact();
//		cont.setContactFirstName(request.getParameter("first name"));
//		cont.setContactLastName(request.getParameter("last name"));
//		cont.setContactNumber(request.getParameter("number"));
//		Contact c=serv.addContact(cont);
//		ModelAndView view = new ModelAndView();
//		view.setViewName("GetContactById");
//		view.addObject("getContactById",c);
//		return view;
//	}
//	@RequestMapping("/getContact")
//	public String getContact(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
//	{
//		ContactService serv=new ContactService();
//		String id=request.getParameter("id");
//		int idd=Integer.parseInt(id);
//		Contact contact=serv.getContact(idd);
//		request.setAttribute("getContactById",contact);
//		HttpSession session=request.getSession(); 
//		session.setAttribute("cont",contact);
//		String rd=null;
//		String value=request.getParameter("crud");
//		switch(value)
//		{
//			case "2":rd="GetContactById"; break;
//			case "3":rd="EditContact"; break;
//			case "4":rd="DeleteContact"; break;
//		}
//		return rd;
//	}
//	@RequestMapping("/delete")
//	public ModelAndView deleteContact(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
//	{
//		String id=request.getParameter("id");
//		int n=Integer.parseInt(id);
//		ContactService serv=new ContactService();
//		serv.deleteContact(n);
//		List<Contact> contact=serv.getAllContact();
//		ModelAndView view = new ModelAndView();
//		view.setViewName("ViewAll");
//		view.addObject("allContact",contact);
//		return view;
//	}
//	@RequestMapping("/editCont")
//	public String edit()
//	{
//		return "EditContact";
//	}
//	@RequestMapping("/editContact")
//	public ModelAndView editContact(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
//	{
//		String id=request.getParameter("id");
//		int n=Integer.parseInt(id);
//		Contact cont=new Contact();
//		cont.setContactFirstName(request.getParameter("first name"));
//		cont.setContactLastName(request.getParameter("last name"));
//		cont.setContactNumber(request.getParameter("number"));
//		ContactService serv=new ContactService();
//		Contact con=serv.editContact(n,cont);
//		ModelAndView view = new ModelAndView();
//		view.setViewName("GetContactById");
//		view.addObject("getContactById",con);
//		return view;
//	}
//	@RequestMapping("/Logout")
//	public String logout(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
//	{
//		HttpSession session=request.getSession(); 
//		session.invalidate();
//		return "Index";
//	}
}