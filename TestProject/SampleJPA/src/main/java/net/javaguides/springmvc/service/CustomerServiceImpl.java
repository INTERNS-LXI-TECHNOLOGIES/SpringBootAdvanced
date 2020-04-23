package net.javaguides.springmvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springmvc.entity.Customer;
import net.javaguides.springmvc.exception.ResourceNotFoundException;
import net.javaguides.springmvc.repository.CustomerRepository;

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
    public Optional <Customer> getCustomer(int id){
        return customerRepository.findById(id);
    }

  
    @Transactional
    public void deleteCustomer(int theId) {
        customerRepository.deleteById(theId);
    }
}
