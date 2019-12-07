package com.lxisoft.RunWay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxisoft.RunWay.model.LoginUser;
import com.lxisoft.RunWay.repository.LoginUserRepository;

@Service
public class LoginUserService {
@Autowired
LoginUserRepository repo;
public LoginUser saveUser(LoginUser user)
{
	return repo.save(user);
}
}
