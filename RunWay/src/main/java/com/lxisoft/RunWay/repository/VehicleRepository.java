package com.lxisoft.RunWay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lxisoft.RunWay.model.Vehicle;
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {


	List<Vehicle> findAllByOwnerId(@Param("ownerId")Long ownerId);
	
	
}
