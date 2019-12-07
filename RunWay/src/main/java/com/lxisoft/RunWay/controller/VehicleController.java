package com.lxisoft.RunWay.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lxisoft.RunWay.model.Vehicle;
import com.lxisoft.RunWay.service.VehicleService;

@Controller
public class VehicleController {
	@Autowired
	VehicleService vehicleService;
	
	@GetMapping("/addDetails")
	public String s(Vehicle vehicle,Model model)
	{
		model.addAttribute("vehicle",new Vehicle());
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

}
