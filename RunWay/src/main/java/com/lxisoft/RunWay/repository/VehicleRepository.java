package com.lxisoft.RunWay.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lxisoft.RunWay.model.Vehicle;
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {


	List<Vehicle> findAllByOwnerId(@Param("ownerId")Long ownerId);

	//void deleteByOwnerId(@Param("ownerId")Long ownerId);
		
	 
	@Query (value="select * from vehicle where type=:type and (id NOT IN(select vehicle_id from booked_detail where date=:date))",nativeQuery = true)
	public List<Vehicle> getVehicle(@Param("type")String type,@Param("date") Date date);

}
