package com.lxisoft.contacts.controller;



import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.contacts.domain.*;
import com.lxisoft.contacts.model.ViewList;
import com.lxisoft.contacts.model.ViewListModel;
import com.lxisoft.contacts.controller.*;
@Controller
public class displayController 
{
	
	@Autowired
    repoController repo;
	ArrayList<Contact> contacts;
	@RequestMapping("/viewall")
	public ModelAndView display(HttpServletRequest request,HttpServletResponse response)
	{
		 contacts=repo.getAllContacts(); 
         ViewList view=new ViewList();
         ArrayList<ViewListModel> listView=null;
         if(contacts!=null)
         {
            view.clearArray();
            for(int i=0;i<contacts.size();i++)
            {
               view.setContact(contacts.get(i));
            }
            listView=view.getAllContacts();
         }
   		//PrintWriter out = response.getWriter();
         // fosr(Contact a: contacts)
         // out.println("<h1>"+a.getName()+"</h1>");
         HttpSession session=request.getSession();
        // session.setAttribute("contacts",listView);
//   		 request.setAttribute("contacts",listView);
//           response.setCharacterEncoding("UTF-8");
//            response.setContentType("text/html; charset=utf-8");
   		//response.sendRedirect("main.jsp");
            ModelAndView mv=new ModelAndView();
   		mv.setViewName("main.jsp");
   		mv.addObject("contacts",listView);
		return mv;
	}
	@RequestMapping("/logout")
	 public ModelAndView log(HttpServletRequest request, HttpServletResponse response) 
	 {
		HttpSession session=request.getSession();
		response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=utf-8");
		session.invalidate();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index.jsp");
		//response.sendRedirect("viewall");
		return mv;

	 }
	
	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView mv= new ModelAndView();
		
		HttpSession session=request.getSession();
		Contact c=new Contact();
		c=(Contact) session.getAttribute("users");
		String fName=(String) request.getParameter("newFirstName");
		c.setFirstName(fName);
		String lName=(String) request.getParameter("newLastName");
		c.setLastName(lName);
		String number=(String) request.getParameter("newNo");
		c.setNo(number);
		// PrintWriter out=response.getWriter();
		response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=utf-8");
		repo.editContact(c,1);
//		response.sendRedirect("viewall");
		mv.setViewName("viewall");
		return mv;
	}
	@RequestMapping("/lang")
	public ModelAndView lang(HttpServletRequest request,HttpServletResponse response )
	{
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
//        PrintWriter out=response.getWriter();
        String name=request.getParameter("lang");
        HttpSession session=request.getSession();
        session.setAttribute("lang",name);
//        response.sendRedirect("viewall");
        ModelAndView mv=new ModelAndView();
		mv.setViewName("viewall");
		return mv;
	}
	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mv=new ModelAndView();
		 response.setCharacterEncoding("UTF-8");
         response.setContentType("text/html; charset=utf-8");
		try {
			HttpSession session=request.getSession();
			Contact contact=(Contact) session.getAttribute("users");
			repo.deleteContact(contact);
			

			mv.setViewName("viewall");
			// PrintWriter out = response.getWriter();
			// out.println("<h1>" +"asdfffff"+ "</h1>");
     
		}catch(Exception e)
		{
			System.out.println("exception "+e);
		}
		
		return mv;
	}
	@RequestMapping("/sort")
	public ModelAndView sort(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mv=new ModelAndView();
		
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
    try {

    		
    		String type=(String)request.getParameter("sort");
    		switch(type)
    		{
    		case "first" : repo.sortByFirstName();break;
    		case "last" : repo.sortByLastName();break;
    		case "id" : repo.sortById();break;
    		}
//    		response.sendRedirect("viewall");
    		
//    		PrintWriter out=response.getWriter();
//    		out.println(type);
    		mv.setViewName("viewall");

    	}catch(Exception e)
    	{

    	}
		
		return mv;
	}
	
	@RequestMapping("/deleteAll")
	public ModelAndView deleteall(HttpServletRequest request, HttpServletResponse response)
	{
		 response.setCharacterEncoding("UTF-8");
         response.setContentType("text/html; charset=utf-8");
         ModelAndView mv=new ModelAndView();
		try {
			repo.clearAllContacts();
			HttpSession session=request.getSession();
			session.setAttribute("contacts",new ArrayList<ViewListModel>());
      
			response.sendRedirect("viewall");
			mv.setViewName("viewall");
//			PrintWriter out = response.getWriter();
//			out.println("<h1>" +"asdfffff"+ "</h1>");
     
			}catch(Exception e)
			{
			System.out.println("exception "+e);
			}return mv;
	}
	@RequestMapping("/addnew")
	public ModelAndView add()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("addnew.jsp");
		return mv;
	}
	@RequestMapping("/select")
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mv= new ModelAndView();
		
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
    try {

    		ArrayList<Contact> contacts=repo.getAllContacts();
    		String type=(String)request.getParameter("type");
    		String name=(String)request.getParameter("name");
    		for(Contact a: contacts)
            {
               if(a.getFullName().equalsIgnoreCase(name))
               {
                  	HttpSession session=request.getSession();
					session.setAttribute("users",a);
               }

            }
            switch(type)
            {
            	case "delete":mv.setViewName("delete");;break;
                case "edit":  mv.setViewName("edit.jsp");break;
                default:
            }
//    		PrintWriter out=response.getWriter();
//    		out.println(name+" "+ type);
    	}catch(Exception e)
    	{

    	}
		
		
		return mv;
	}
	
	@RequestMapping("/search")
	public ModelAndView search(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mv= new ModelAndView();
		
		
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");	
     try 
     {
        Contact contact=null;
        String name=(String)request.getParameter("user");
        HttpSession session=request.getSession();
        // session.setAttribute("use",a);
        // ViewListModel cont=(ViewListModel)session.getAttribute("use");
        ArrayList<Contact> contacts=repo.getAllContacts();
        ArrayList<Contact> users=new ArrayList<Contact>();
        ArrayList<Contact> dupUsers=new ArrayList<Contact>();
        for(Contact a: contacts)
        {
           if(a.getFullName().equalsIgnoreCase(name))
           {
              users.add(a);
           }

        }
        if(users.size()==1)
        {
           session.setAttribute("users",users.get(0));
//           mv.addObject("users",users.get(0));
//          request.getRequestDispatcher("user.jsp").forward(request, response);
           mv.setViewName("user.jsp");
           

        }
        else
        {
            for(Contact a: contacts)
           {
              if((a.getFullName().toLowerCase()).contains(name.toLowerCase()))
              {
                 dupUsers.add(a);
              }

           }
           for(Contact a: dupUsers)
          {
//        PrintWriter out = response.getWriter();
//        out.println(a.getFullName());}
          }
         if(dupUsers.size()!=0) 
          {
             ViewList view=new ViewList();
              ArrayList<ViewListModel> listView=null;
              view.clearArray();
              for(int i=0;i<dupUsers.size();i++)
              {
                 view.setContact(dupUsers.get(i));
              }
              listView=view.getAllContacts();
              request.setAttribute("contacts",listView);
              request.setAttribute("search",true);
//              mv.addObject("contacts", listView);
//              mv.addObject("search", true);
//              request.getRequestDispatcher("main.jsp").forward(request, response);
              mv.setViewName("main.jsp");
              
              
           }
           else
           {
//              session.setAttribute("contacts",new ArrayList<ViewListModel>());
//              request.getRequestDispatcher("main.jsp").forward(request, response);

              mv.addObject("contacts",new ArrayList<ViewListModel>());
              mv.setViewName("main.jsp");
              
           }
        }
       }catch(Exception e)
	    {
	        System.out.println("exception "+e);
	    }
		return mv;
	}
	@RequestMapping("/createNewContact")
	public ModelAndView create(HttpServletRequest request, HttpServletResponse response)
	{
		
		ModelAndView mv=new ModelAndView();
		try {
            boolean exist=true;
        HttpSession session=request.getSession();
        Contact contact=new Contact();
  		contact.setFirstName(request.getParameter("firstname"));
        contact.setLastName(request.getParameter("lastname"));
        contact.setNo(request.getParameter("number"));
        ArrayList<Contact> contacts=repo.getAllContacts();
        for(Contact c:contacts)
        {
           if(c.getFullName().toLowerCase().equals(contact.getFullName().toLowerCase()))
           {
              exist=false;
        
           }
        }
        if(exist==false)
           {
              String name=contact.getFullName();
//              request.setAttribute("newcontacts",name);
//              request.getRequestDispatcher("addnew.jsp").forward(request, response);
              mv.setViewName("addnew.jsp");
              mv.addObject("newcontacts",name);
      		  return mv;
           }
        else
        {
           request.setAttribute("newcontacts",new Contact());
           repo.writeNewContact(contact,true);
           contacts=repo.getAllContacts();

           ViewList view=new ViewList();
           ArrayList<ViewListModel> listView=null;
           if(contacts!=null)
           {
              view.clearArray();
              for(int i=0;i<contacts.size();i++)
              {
                 view.setContact(contacts.get(i));
              }
              listView=view.getAllContacts();
           }
//           session.setAttribute("contacts",listView);
//           request.getRequestDispatcher("main.jsp").forward(request, response);
           mv.setViewName("viewall");
           mv.addObject("contacts",listView);
   		
           // PrintWriter out = response.getWriter();
           // out.println("<h1>" +contact.getName()+ "</h1>");
        }
        }catch(Exception e)
        {
        	System.out.println("exception "+e);
        }
		 return mv;
	}
}
