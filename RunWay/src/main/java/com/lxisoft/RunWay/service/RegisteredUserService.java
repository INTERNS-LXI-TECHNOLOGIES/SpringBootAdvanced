package com.lxisoft.RunWay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxisoft.RunWay.model.Customer;
import com.lxisoft.RunWay.model.RegisteredUser;
import com.lxisoft.RunWay.repository.RegisteredUserRepository;

@Service
public class RegisteredUserService {
@Autowired
RegisteredUserRepository repo;
/*
public RegisteredUser saveRegisteredUser(Customer customer)
{
	return repo.save(customer);
}*/
}
