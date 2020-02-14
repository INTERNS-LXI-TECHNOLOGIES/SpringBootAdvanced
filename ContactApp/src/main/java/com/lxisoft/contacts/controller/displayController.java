package com.lxisoft.contacts.controller;



import java.util.ArrayList;
import org.hibernate.Session;
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
import com.lxisoft.contacts.service.ContactService;
import com.lxisoft.contacts.service.ContactServiceImpl;
import com.lxisoft.contacts.controller.*;
@Controller
public class displayController 
{
	
	 @Autowired
	 ContactService serv;
	@RequestMapping("/viewall")
	public ModelAndView display(HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("ashiqqqqqqqqqqqqqq");
//		 contacts=repo.getAllContacts();
		ArrayList<Contact> contacts=(ArrayList<Contact>) serv.listContacts();
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
         // for(Contact a: contacts)
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
	
}
