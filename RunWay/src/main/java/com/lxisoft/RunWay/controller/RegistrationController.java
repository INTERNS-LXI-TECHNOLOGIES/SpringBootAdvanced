package com.lxisoft.RunWay.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lxisoft.RunWay.model.Customer;
import com.lxisoft.RunWay.service.CustomerService;

@Controller
public class RegistrationController {
@Autowired
CustomerService service;
@GetMapping("/registration")
public String showRegistrationForm(Customer customer) {
    return "registration";
}
@PostMapping("/registration")
	public String registerUserAccount(@ModelAttribute Customer customer,BindingResult result) {


	        if (result.hasErrors()) {
	            return "registration";
	        }

	        service.saveCustomer(customer);
	        return "redirect:/registration?success";
	}
}
