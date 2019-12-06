package com.lxisoft.RunWay;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
@PostMapping("/registration")
public String registration(@ModelAttribute("customer") @Valid CustomerRepository repo,BindingResult result) {
	
	return "registration";
	
}
}
