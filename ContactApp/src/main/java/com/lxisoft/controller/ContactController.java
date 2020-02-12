package com.lxisoft.controller;
import com.lxisoft.domain.*;
import com.lxisoft.service.ContactService;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController 
{
	{System.out.println("controller");}
	@Autowired
	ContactService service;
	
	@RequestMapping(value="/showAll")
	public String findAll(Model model)
	{
		ArrayList<Contact> contactList=service.findAllService();
		model.addAttribute("list",contactList);
		System.out.println(contactList.size());
	      return "ViewAll"; 
	}
	
//	@RequestMapping(value="/selectContact")
//	public String select(@RequestParam String selectId,@RequestParam String type,Model model,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
//	{
//		Contact contact=service.findIdService(selectId);
//		model.addAttribute("contact",contact);
//		HttpSession session = request.getSession();
//		session.setAttribute("contact",contact);
//		if(type.equals("e"))
//		{
//			System.out.println("edit");
//			return "redirect:/editPage";
//		}
//		else if(type.equals("d"))
//		{
//			System.out.println("delete");
//			return "redirect:/delete";
//		}
//		else
//		{
//			System.out.println("select");
//			return "Select";
//		}	
//	}
//	
//	@RequestMapping(value="/editPage")
//	public String editPage()
//	{
//		return "Edit";
//	}
	
	@RequestMapping(value="/delete")
	public String delete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		Contact contact=(Contact) session.getAttribute("contact");
		System.out.println("gsdh=="+contact.getId());
		service.deleteService(contact);
		return "redirect:/showAll";
	}
	
	@RequestMapping(value="/addContact")
	public String save()
	{
		return "Save";
	}
	
	@RequestMapping(value="/save")
	public String save(@RequestParam String firstName,@RequestParam String lastName,@RequestParam String number)
	{
		Contact contact=new Contact();
		contact.setFName(firstName);
		contact.setLName(lastName);
		contact.setNumber(number);
		service.saveService(contact);
		return "redirect:/showAll";
	}
//	
//	@RequestMapping(value="/edit", method = RequestMethod.POST )
//	public String edit(HttpServletRequest request,HttpServletResponse response,@RequestParam String firstName,@RequestParam String lastName,@RequestParam String number) throws ServletException, IOException
//	{
//		HttpSession session = request.getSession();
//		Contact contact=(Contact) session.getAttribute("contact");
//		System.out.println("gsdh=="+contact.getId());
//		String[] newContact = new String[3];
//		newContact[0]=firstName;
//		newContact[1]=lastName;
//		newContact[2]=number;
//		service.editService(contact,newContact);
//		return "redirect:/showAll";
//	}
}
