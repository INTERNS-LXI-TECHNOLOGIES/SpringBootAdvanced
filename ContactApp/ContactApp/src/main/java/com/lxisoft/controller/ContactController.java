package com.lxisoft.controller;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.domain.Contact;
import com.lxisoft.models.ContactModel;
import com.lxisoft.models.ContactsListModel;

import com.lxisoft.repository.Repository;
import com.lxisoft.services.ContactServices;
 
@Controller

public class ContactController 
{
		 @Autowired
		 ContactServices serv;
		 
		 
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
			 ArrayList<ContactModel> contactList=serv.getAllContacts(pageid,total);
			 ModelAndView mv=new ModelAndView();
				mv.setViewName("view");
				mv.addObject("contactmodel",contactList);
			 return mv;
		 }
		 
		 
		 @RequestMapping("/add")
		 public String ContAdd() 
		 {
			return "ContactAdd";
		 }
		 
		 
		 @RequestMapping("/addContact")
		 public String ContactAdd(HttpServletRequest request, HttpServletResponse response) throws SQLException
		 {
			 boolean exists=false;
			 Contact contact=new Contact();
		     contact.setFirstName(request.getParameter("fname"));
		     contact.setLastName(request.getParameter("lname"));
		     contact.setNo(request.getParameter("num"));
			 
		     ArrayList<Contact> contactList=serv.getRepoContacts();
		     for(int i=0;i<contactList.size();i++)
		     {
			      if(contact.getFullName().equals(contactList.get(i).getFullName()))
			       {
			         exists=true;
			       }
		     }
		     if(exists)
		     {
		    	 request.setAttribute("contacts", contact);
		    	 return "redirect:/add";
		     } 
		     else{
			    	 request.setAttribute("contacts", contact);
			    	 serv.writeContact(request, response);
			    	 return "redirect:/view?page=1";
		         }
		 }
		 
		 @RequestMapping("/selectContact")
		 public String SelectedContact(HttpServletRequest request, HttpServletResponse response)
		 {
			 HttpSession session = request.getSession();
			 try {
				 int select=Integer.parseInt(request.getParameter("select"));
				 ArrayList<Contact> contactList=serv.getRepoContacts();
					for(Contact contact:contactList)
					{	
						if(select==contact.getId())
						{
							session.setAttribute("currentcontact",contact);	
							return "redirect:/Edit";
						}
					}
			 }catch(Exception e)
			 {
					 try
						{
							String select=(String)request.getParameter("select");
							ArrayList<Contact> contactList=serv.getRepoContacts();
							for(Contact contact:contactList)
							{	
								if(select.equalsIgnoreCase(contact.getFullName()))
								{
					 				session.setAttribute("currentcontact",contact);
					 				return "redirect:/delete";	
					 			}
							}
						}catch(Exception excep)
						{
							excep.printStackTrace();
						}
			 }
			return null;
		  }
		 
		 
		 @RequestMapping("/Edit")
		 public String Edit() 
		 {
			return "ContactEdit";
		 }
		 
		 
		 @RequestMapping("/delete")
		 public String Delete(HttpServletRequest request,HttpServletResponse response) 
		 {
			 HttpSession session=request.getSession(); 
			 Contact contact= (Contact)session.getAttribute("currentcontact");
			 serv.deleteContact(contact);
			 response.setCharacterEncoding("UTF-8");
			 return "redirect:/view?page=1";
		 }
		 
		 
		 @RequestMapping("/edit")
		 public String ContactEdit(HttpServletRequest request, HttpServletResponse response)
		 {
			 HttpSession session=request.getSession(); 
				Contact contact= (Contact)session.getAttribute("currentcontact");
				 try{
		           contact.setFirstName(request.getParameter("fname"));
		           contact.setLastName(request.getParameter("lname"));
		           contact.setNo(request.getParameter("num"));
		           serv.updateRepo(contact);
		           
		       }catch(Exception e)
		       {
		       	e.printStackTrace();
		       }
				 return "redirect:/view?page=1";
		 }
		 
		 
		 @RequestMapping("/select")
		 public ModelAndView ContactDetails(HttpServletRequest request, HttpServletResponse response) throws SQLException 
		 {
			 ModelAndView mv=new ModelAndView();
			 HttpSession session = request.getSession();

			 String name=(String)request.getParameter("user");
			 ContactsListModel contactlistmodel=new ContactsListModel();
				ArrayList<Contact> contactList=serv.getRepoContacts();
				ArrayList<Contact> currentList=new ArrayList<Contact>();
				for(Contact contact:contactList)
				{	if(name.equalsIgnoreCase(contact.getFullName()))
					{
		 				currentList.add(contact);		
		 			}
				}
				if(currentList.size()==1)
					{
						session.setAttribute("currentcontact",currentList.get(0));
						mv.setViewName("ContactDetails");
						return mv;
					}
				else{
					
					   currentList.clear();
					   for(Contact contact:contactList)
				        {
			 				if((contact.getFullName().toLowerCase()).contains(name.toLowerCase()))
			 					{
						 			currentList.add(contact);
						 		}
						}	
			            if(currentList.size()!=0)
			            { 
			                for(int i=0;i<currentList.size();i++)
			                {
			                  ContactModel contactmodel=new ContactModel();
			                  contactmodel.setId(currentList.get(i).getId());
			                  contactmodel.setFirstName(currentList.get(i).getFirstName());
			                  contactmodel.setLastName(currentList.get(i).getLastName());
			                  contactlistmodel.setAllContacts(contactmodel);
			                }
			            }
			            ArrayList<ContactModel> contacts=contactlistmodel.getAllContacts();
			   			mv.setViewName("view");
			   			mv.addObject("contactmodel",contacts);
			   			return mv;
					}
		 }
		 
		 @RequestMapping("/searchdetails")
		 public String contactDetails() 
		 {
			return "ContactDetails";
		 }
		 
		 @RequestMapping("/DeleteAll")
		 public String DeleteAllContacts() throws SQLException 
		 {
			 serv.clearRepository();
			 return "redirect:/view?page=1";
			
		 }
		 
		 
		 @RequestMapping("/sort")
		 public String ContactSort(HttpServletRequest request, HttpServletResponse response)
		 {
			 String sortvalue=request.getParameter("sortvalue");
		    	try{
						switch(sortvalue)
						{
							case "firstname":serv.sortContactByFirstName();break;
							case "lastname":serv.sortContactByLastName();break;
						}
						 
					}catch(Exception excep)
					{
						excep.printStackTrace();
					}

		    	return "redirect:/view?page=1";
		 }
		 
		 
		 @RequestMapping("/logout")
		 public String userLogout(HttpServletRequest request, HttpServletResponse response) throws SQLException 
		 {
			 HttpSession session=request.getSession();
	         session.invalidate();
	         session=request.getSession(false);
			 return "redirect:/view?page=1";
			
		 }
		 
		 @RequestMapping("/lang")
		 public String languageSelector(HttpServletRequest request, HttpServletResponse response) throws SQLException 
		 {
			 HttpSession session=request.getSession();
			 String lang= request.getParameter("lang");
		     session.setAttribute("currentlocale",lang);
			 return "redirect:/view?page=1";
			
		 }
		 
}
