package com.lxisoft.RunWay;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CustomerController {
@Autowired
CustomerService service;	
@PostMapping("/customer")
public Customer saveCustomer(@RequestBody Customer customer ){
    
    return service.saveCustomer(customer);
}
@GetMapping("/customer/{id}")
public Customer getCustomerById(@PathVariable Long id) {

  return service.getCustomerById(id);

}
}
