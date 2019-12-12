package com.lxisoft.RunWay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.lxisoft.RunWay.service.RegisteredUserService;

@RestController
public class RegisteredUserController {
@Autowired
RegisteredUserService service;
}
