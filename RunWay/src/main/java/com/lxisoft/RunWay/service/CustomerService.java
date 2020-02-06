package com.lxisoft.RunWay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxisoft.RunWay.model.Customer;
import com.lxisoft.RunWay.model.Vehicle;
import com.lxisoft.RunWay.repository.CustomerRepository;


@Service
public class CustomerService {
@Autowired
CustomerRepository repo;
public Customer saveCustomer(Customer customer) {
	return repo.save(customer);
}

public Customer getCustomerById(Long id) {
    java.util.Optional<Customer> optionalcustomer = repo.findById(id);
    return optionalcustomer.get();
}


public Customer viewProfile(Long id)
{
	return repo.findById(id).get();
}

public Customer editProfile(Long id)
{
	return repo.findById(id).get();
}

public Customer updateProfile(Customer customer)
{
	return repo.save(customer);
}
}
