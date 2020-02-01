package com.lxisoft.controller;
import com.lxisoft.service.*;
import com.lxisoft.domain.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController 
{	
	{
		System.out.println("controller");
	}
	
//	@Autowired
//	Service service;
	@RequestMapping(value="/showAll")
	public String findAll()
	{
//		ArrayList<Contact> contactList=((Object) service).findAllService();
		System.out.println("dddddddddd");
	      return "ViewAll";
	      
	}
//	@RequestMapping(value="/", method = RequestMethod.GET)
//	public String findAll()
//	{	
//		ModelAndView model = new ModelAndView();
//		ArrayList<Contact> contactList= service.findAllService();
//		model.addAttribute("contactList",contactList);
//		return "viewAll";
//	}
			
	
	

}
