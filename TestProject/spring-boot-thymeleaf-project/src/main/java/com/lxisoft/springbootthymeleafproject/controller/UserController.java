package com.lxisoft.springbootthymeleafproject.controller;

import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;    
import org.springframework.stereotype.Controller;    

import com.lxisoft.springbootthymeleafproject.Entity.*;

@Controller
public class UserController {
	
	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		return "Hello world";
	}
	
	@RequestMapping("/")
	public String index()
	{
		return "index";
	}
	
@RequestMapping(value="/save",method = RequestMethod.POST)
public ModelAndView save(@ModelAttribute UserEntity user)
{
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("user-data");
	modelAndView.addObject("user", user);
	return modelAndView;
}

}
