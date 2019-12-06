package com.lxisoft.RunWay;

import java.util.List;

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
	public List<Vehicle> fetchVehicledetails() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	

}
