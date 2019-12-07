package com.lxisoft.RunWay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxisoft.RunWay.model.Vehicle;
import com.lxisoft.RunWay.repository.VehicleRepository;

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
