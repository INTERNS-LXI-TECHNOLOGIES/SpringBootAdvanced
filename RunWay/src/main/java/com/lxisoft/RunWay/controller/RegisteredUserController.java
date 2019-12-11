package com.lxisoft.RunWay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lxisoft.RunWay.model.Customer;
import com.lxisoft.RunWay.model.RegisteredUser;
import com.lxisoft.RunWay.service.RegisteredUserService;

@RestController
public class RegisteredUserController {
@Autowired
RegisteredUserService service;
/*
@PostMapping("/customerregister")
public RegisteredUser saveOwner(@RequestBody Customer customer) {
	return service.saveRegisteredUser(customer);
}*/
}
