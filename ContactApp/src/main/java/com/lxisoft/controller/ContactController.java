package com.lxisoft.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController 
{	
	@RequestMapping(value="/add")
	public String findAll()
	{
		System.out.println("dddddddddd");
	      return "Fail";
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
