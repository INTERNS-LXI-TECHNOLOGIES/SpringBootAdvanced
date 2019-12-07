package com.lxisoft.RunWay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.RunWay.model.Vehicle;
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	

}
