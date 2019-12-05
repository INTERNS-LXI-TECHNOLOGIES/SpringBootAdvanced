package com.lxisoft.RunWay;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {
	@Autowired
	VehicleService vehicleService;
	
	@PostMapping("/create")
	public Vehicle create(@RequestBody Vehicle vehicle)
	{
		return vehicleService.addVehicle(vehicle);
		
		
	}
	

}
