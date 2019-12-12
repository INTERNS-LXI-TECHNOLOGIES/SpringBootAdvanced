package com.lxisoft.RunWay.controller;

	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lxisoft.RunWay.service.HomeService;

	@Controller
	public class HomeController {

		@Autowired
	    HomeService service;

	    @GetMapping("/login")
	    public String home(Model model) {
	        model.addAttribute("msgs", service.home(model));
	        return "login";
	    }

}
