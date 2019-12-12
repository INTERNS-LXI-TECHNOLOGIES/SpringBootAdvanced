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
	 
	@Query (value="select vehicle.id,vehicle.mileage,vehicle.model,vehicle.owner_id,vehicle.price,vehicle.seats,vehicle.type from vehicle,booked_detail where vehicle.type='CAR' and booked_detail.vehicle_id!=vehicle.id ");
	public List<Vehicle> getVehicle(@Param("type")String type,@Param("date") Date date);
}
