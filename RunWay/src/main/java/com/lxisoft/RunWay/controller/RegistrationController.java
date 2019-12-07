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
CustomerService cService;
@Autowired
OwnerService oService;
@GetMapping("/registration")
public String showRegistration() {
    return "registration";
}
@GetMapping("/customerregister")
public String showCustomerForm(Customer customer) {
    return "customerregister";
}
@PostMapping("/customerregister")
	public String registerCustomerAccount(@ModelAttribute Customer customer,BindingResult result) {


	        if (result.hasErrors()) {
	            return "customerregister";
	        }

	        cService.saveCustomer(customer);
	        return "redirect:/customerregister?success";
	}
@GetMapping("/ownerregister")
public String showOwnerForm(Owner owner) {
    return "ownerregister";
}
@PostMapping("/ownerregister")
	public String registerOwnerAccount(@ModelAttribute Owner owner,BindingResult result) {


	        if (result.hasErrors()) {
	            return "ownerregister";
	        }

	        oService.saveOwner(owner);
	        return "redirect:/ownerregister?success";
	}
}
