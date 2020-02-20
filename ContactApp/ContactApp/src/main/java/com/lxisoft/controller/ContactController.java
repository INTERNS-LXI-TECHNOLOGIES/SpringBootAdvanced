package com.lxisoft.controller;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.domain.Contact;
import com.lxisoft.models.ContactModel;
import com.lxisoft.models.ContactsListModel;

import com.lxisoft.services.ContactService;
 
@Controller
//@SessionAttributes("Contact")
public class ContactController 
{
		 @Autowired
		 ContactService serv;
		 
//		 @ModelAttribute("contactmodel")
		 @RequestMapping("/view")
		 public ModelAndView getAllContactInfo(HttpServletRequest request, HttpServletResponse response) throws SQLException
		 { 
//			 HttpSession session = request.getSession();
		/*
		 * String spageid=request.getParameter("page"); int
		 * pageid=Integer.parseInt(spageid); int total=5; if(pageid==1){ } else{
		 * pageid=pageid-1; pageid=pageid*total+1; }
		 */
			 
			 
			   		    	
		    	
			 ArrayList<Contact> contactList=(ArrayList)serv.getAllContacts();
//			 session.setAttribute("page",spageid);
			 ContactsListModel contactlistmodel=new ContactsListModel();
			    if(contactList!=null)
			    { 
			      for(int i=0;i<contactList.size();i++)
			      {
			        ContactModel contactmodel=new ContactModel();
			        contactmodel.setId(contactList.get(i).getId());
			        contactmodel.setFirstName(contactList.get(i).getFirstName());
			        contactmodel.setLastName(contactList.get(i).getLastName());
			        contactlistmodel.setAllContacts(contactmodel);
			      }
			    }
			    ArrayList<ContactModel> contacts=contactlistmodel.getAllContacts();
				
			 ModelAndView mv=new ModelAndView();
				mv.setViewName("view");
				mv.addObject("contactmodel",contacts);
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
				 
			     ArrayList<Contact> contactList=(ArrayList)serv.getAllContacts();
			     for(int i=0;i<contactList.size();i++)
			     {
				      if(contact.getFullName().equals(contactList.get(i).getFullName()))
				       {
				    	  System.out.println("dfsf");
				         exists=true;
				        
				       }
			     }
			     if(exists)
			     {
			    	 System.out.println("exists");
			    	 request.setAttribute("contacts", contact);
			    	 return "redirect:/add";
			     } 
			     else{
			    	 System.out.println("No");
				    	 request.setAttribute("contacts", contact);
				    	 serv.addContact(contact);
				    	 return "redirect:/view?page=1";
			         }
			 }
		  
		  @RequestMapping("/select")
			 public ModelAndView ContactDetails(HttpServletRequest request, HttpServletResponse response) throws SQLException 
			 {
				 ModelAndView mv=new ModelAndView();
				 HttpSession session = request.getSession();

				 String name=(String)request.getParameter("user");
				 ContactsListModel contactlistmodel=new ContactsListModel();
					ArrayList<Contact> contactList=(ArrayList)serv.getAllContacts();
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
		  
		  @RequestMapping("/selectContact")
			 public String SelectedContact(HttpServletRequest request, HttpServletResponse response)
			 {
				 HttpSession session = request.getSession();
				 try {
					 int select=Integer.parseInt(request.getParameter("select"));
					 ArrayList<Contact> contactList=(ArrayList)serv.getAllContacts();
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
								ArrayList<Contact> contactList=(ArrayList)serv.getAllContacts();
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
			 
			 @RequestMapping("/DeleteAll")
			 public String DeleteAllContacts() throws SQLException 
			 {
				 serv.clearRepository();
				 return "redirect:/view?page=1";
				
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
			           serv.updateContact(contact);
			           
			       }catch(Exception e)
			       {
			       	e.printStackTrace();
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
