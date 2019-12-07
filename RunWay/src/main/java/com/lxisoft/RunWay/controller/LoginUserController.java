package com.lxisoft.RunWay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lxisoft.RunWay.model.LoginUser;
import com.lxisoft.RunWay.service.LoginUserService;

@RestController
public class LoginUserController {
@Autowired
LoginUserService service;
@PostMapping("/loginuser")
public LoginUser saveOwner(@RequestBody LoginUser user) {
	return service.saveUser(user);
}
}
