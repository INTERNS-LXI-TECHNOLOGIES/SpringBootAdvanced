package com.lxisoft.RunWay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
@Autowired
CustomerRepository repo;
public Customer saveCustomer(Customer customer) {
	return repo.save(customer);
}
}
