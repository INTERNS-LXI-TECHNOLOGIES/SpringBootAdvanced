package com.lxisoft.RunWay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lxisoft.RunWay.model.RegisteredUser;
import com.lxisoft.RunWay.service.RegisteredUserService;

@RestController
public class RegisteredUserController {
@Autowired
RegisteredUserService service;
@PostMapping("/registereduser")
public RegisteredUser saveOwner(@RequestBody RegisteredUser user) {
	return service.saveUser(user);
}
}
