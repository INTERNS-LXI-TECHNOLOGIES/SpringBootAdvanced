package com.lxisoft.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;

@Controller
public class MockController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage()
	{
		return "Home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getadministeration()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean hasUserRole = authentication.getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
		if(hasUserRole)
		{
			return "Admin";
		}
		else
		{
			return "Introduction";
		}
		
	}
	
	@RequestMapping(value = "/user",method = RequestMethod.GET)
	public String getUser()
	{
		return "Introduction";
	}
	
	@RequestMapping(value = "/logoutUser",method = RequestMethod.GET)
	public String userLogOut()
	{
		return "Logout";
	}
	
	 @RequestMapping(value="/logout", method=RequestMethod.GET)  
	    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
	        if (auth != null){      
	           new SecurityContextLogoutHandler().logout(request, response, auth);  
	        }  
	         return "redirect:/";  
	     }  
	

}
