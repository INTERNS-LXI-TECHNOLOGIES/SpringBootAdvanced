package com.lxisoft.controller;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.domain.Contact;
import com.lxisoft.models.ContactModel;
import com.lxisoft.models.ContactsListModel;
//import com.lxisoft.repository.MysqlRepo;
import com.lxisoft.repository.Repository;
import com.lxisoft.services.ContactServices;
 
@Controller

public class ContactController 
{
	@Autowired
	ContactServices serv;
//	Repository repo;
 @RequestMapping("/view")
 public ModelAndView getAllContactInfo(HttpServletRequest request, HttpServletResponse response) throws SQLException
 { 
	 String spageid=request.getParameter("page");  
	 int pageid=Integer.parseInt(spageid);  
	 int total=5;  
	 if(pageid==1){ }  
	 else{  
	       pageid=pageid-1;  
	       pageid=pageid*total+1;  
	 }
	 ArrayList<ContactModel> contactList=serv.getAllContacts();
	 ModelAndView mv=new ModelAndView();
		mv.setViewName("view.jsp");
		mv.addObject("contactmodel",contactList);
	 return mv;
 }
 
 
 @RequestMapping("/add")
 public ModelAndView ContactAdd(HttpServletRequest request, HttpServletResponse response) throws SQLException
 {
	 ModelAndView mv=new ModelAndView();
		mv.setViewName("ContactAdd.jsp");
	 return mv;
 }
 
 
}
