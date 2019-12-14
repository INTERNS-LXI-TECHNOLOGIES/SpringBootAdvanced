package com.lxisoft.RunWay.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxisoft.RunWay.model.Customer;
import com.lxisoft.RunWay.model.Owner;
import com.lxisoft.RunWay.model.Vehicle;
import com.lxisoft.RunWay.service.CustomerService;
import com.lxisoft.RunWay.service.OwnerService;

@Controller
public class WebController {
@Autowired
CustomerService cService;
@Autowired
OwnerService oService;
@Autowired
VehicleController vehControl;
@GetMapping("/registeration")
public String showRegistration() {
    return "registeration";
}
@GetMapping("/customerregister")
public String showCustomerForm(Customer customer) {
    return "customerregister";
}
@PostMapping("/customerregister")
	public String registerCustomerAccount(@ModelAttribute Customer customer,BindingResult result) {


	        if (result.hasErrors()) {
	            return "customerregister";
	        }

	        cService.saveCustomer(customer);
	        return "redirect:/customerregister?success";
	}
@GetMapping("/ownerregister")
public String showOwnerForm(Owner owner) {
    return "ownerregister";
}
@PostMapping("/ownerregister")
	public String registerOwnerAccount(@ModelAttribute Owner owner,BindingResult result) {


	        if (result.hasErrors()) {
	            return "ownerregister";
	        }

	        oService.saveOwner(owner);
	        return "redirect:/ownerregister?success";
	}
@RequestMapping("/CustomerHome")
public String getVehicle(Model model,@ModelAttribute String type ) {
	 String user="ajay";
	 String pass="ajay";
	 model.addAttribute("user", user);
	 model.addAttribute("pass", pass);
 return "CustomerHome" ;
}	
@GetMapping("/customerProfile/{id}")
public String viewCustomerProfile(@PathVariable("id") Long id, Model model) 
{
	Customer customer=cService.viewProfile(id);
	model.addAttribute("customer",customer);
	return "viewCustomerProfile";
}

@GetMapping("/editCustomerProfile/{id}")
public String editCustomerProfile(@PathVariable("id") Long id, Model model,Customer customer)
{
	 customer = cService.editProfile(id);
	 model.addAttribute("customer",customer);
	return "editcustomerProfile";
}
@PostMapping("/updateCustomerProfile/{id}")
public String upateCustomerProfile(@PathVariable("id") Long id, Customer customer, Model model)
{
	cService.updateProfile(customer); 
	model.addAttribute("message", "Updated....");
	return "updateStatus";
}
 
 @GetMapping("/CustomerHome/{type}/{date}")
 public String get(Model model,@PathVariable String type ,@PathVariable("date")@DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
  
	 List<Vehicle> vehicleList = vehControl.readVehicleDetails(type,date );

	 model.addAttribute("vehicleList", vehicleList);
	 
	 return "fragments/myFragment.html::myFragment";
	 
 }
 

@GetMapping("/ownerProfile/{id}")
public String viewOwnerProfile(@PathVariable("id") Long id, Model model)
{
	Owner owner=oService.viewOwnerProfile(id);
	model.addAttribute("owner",owner);
	return "viewOwnerProfile";
}
@GetMapping("/editOwnerProfile/{id}")
public String editOwnerProfile(@PathVariable("id") Long id, Model model,Owner owner)
{
	owner= oService.editOwnerProfile(id);
	model.addAttribute("owner",owner);
	return "editOwnerProfile";
}

@PostMapping("/updateOwnerProfile/{id}")
public String upateOwnerProfile(@PathVariable("id") Long id, Owner owner, Model model)
{
	oService.updateProfile(owner); 
	model.addAttribute("message", "Updated....");
	return "updateMessage";
}
}
