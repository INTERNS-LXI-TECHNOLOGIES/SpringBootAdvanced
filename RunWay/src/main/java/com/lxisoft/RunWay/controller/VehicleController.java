package com.lxisoft.RunWay.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.lxisoft.RunWay.model.Vehicle;
import com.lxisoft.RunWay.service.VehicleService;

@Controller
public class VehicleController {
	@Autowired
	VehicleService vehicleService;
	
	@GetMapping("/addDetails/{ownerId}")
	public String showAddForm(Vehicle vehicle,Model model,@PathVariable Long ownerId)
	{
		 vehicle=new Vehicle();
		vehicle.setOwnerId(ownerId);
		model.addAttribute("vehicle",vehicle);
		return "addDetails";
	}

	
	@PostMapping("/create")
	public String create(@ModelAttribute Vehicle vehicle,Model model)
	{
		vehicleService.addVehicle(vehicle);
	
		model.addAttribute("message", "Added Successfully");
		return "result";
		
	}
	
	@GetMapping("/get")
	public List<Vehicle> readVehicleDetails() {
		return vehicleService.fetchVehicledetails();
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) 
	{
		Vehicle vehicle=vehicleService.updateVehicle(id);
		 
		model.addAttribute("vehicle", vehicle );
		return "updateForm";
	}
	
	@PostMapping("/update/{id}")
	public String updateVehicle(@PathVariable("id") Long id, Vehicle vehicle, Model model) {
	   vehicleService.update(vehicle);
		model.addAttribute("message", "Updated Successfully");
		return "messageWindow";
	    
	}
	
	@GetMapping("/delete/{id}")
	public String deleteVehicle(@PathVariable("id") Long id,Model model)
	{
		vehicleService.delete(id);
		model.addAttribute("message","Deleted...");
		return "deletedMessage";
		
	}
	
	@GetMapping("/adminPage/{ownerId}")
	public String view(@PathVariable("ownerId") Long ownerId,Model model)
	{
		List<Vehicle> vehicles =vehicleService.viewDetails(ownerId);
		model.addAttribute("vehicles",vehicles);
		model.addAttribute("ownerId",ownerId);
		return "adminPage";
	}
	
}
