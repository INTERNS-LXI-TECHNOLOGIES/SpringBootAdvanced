package com.lxisoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import com.lxisoft.repository.*;
import com.lxisoft.model.*;
import com.lxisoft.domain.*;
@Controller
public class ContactController
{
	@RequestMapping("/home")
	public ModelAndView getContact()
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
}