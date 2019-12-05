package com.lxisoft.RunWay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {
	@Autowired
	VehicleRepository repo;
	public Vehicle addVehicle(Vehicle vehicle)
	{
		return repo.save(vehicle);
	}
	
	

}
