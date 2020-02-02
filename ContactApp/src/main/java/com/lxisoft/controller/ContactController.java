package com.lxisoft.controller;
import com.lxisoft.domain.*;
import com.lxisoft.repository.DbRepository;
import com.lxisoft.service.ContactService;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController 
{
	@Autowired
	ContactService service;
	@RequestMapping(value="/showAll")
	public String findAll(Model model)
	{
		ArrayList<Contact> contactList=service.findAllService();
		System.out.println("size=="+contactList.size());
		model.addAttribute("list",contactList);
	      return "ViewAll"; 
	}
	
	@RequestMapping(value="/selectContact")
	public String select(@RequestParam String selectId,@RequestParam String type,Model model)
	{
		Contact contact=service.findIdService(selectId);
		model.addAttribute("contact",contact);
		if(type.equals("e"))
		{
			System.out.println("edit");
			return "Edit";
		}
		else if(type.equals("d"))
		{
			System.out.println("delete");
			return "Delete";
		}
		else if(type.equals(null))
		{
			System.out.println("select");
			return "Select";
		}
		else
			return "select";
	}
			
	
	

}
