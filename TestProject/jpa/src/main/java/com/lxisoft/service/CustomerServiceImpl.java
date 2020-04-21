package com.lxisoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.entity.Customer;
import com.lxisoft.exception.ResourceNotFoundException;
import com.lxisoft.repository.CustomerRepository;

@Service
public class CustomerServiceImpl {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public List < Customer > getCustomers() {
        return customerRepository.findAll();
    }

    @Transactional
    public void saveCustomer(Customer theCustomer) {
        customerRepository.save(theCustomer);
    }

    @Transactional
    public Customer getCustomer(int id) throws ResourceNotFoundException {
        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional
    public void deleteCustomer(int theId) {
        customerRepository.deleteById(theId);
    }
}
