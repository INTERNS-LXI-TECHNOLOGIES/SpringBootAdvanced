package com.lxisoft.RunWay;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
	

}
