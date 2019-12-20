package com.lxisoft.RunWay.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id; 
	private Long ownerId;
	private String model;
	private Double mileage;
	private Integer seats;
	private Double price;

	
	
	public Long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	private String type;
	public Double getPrice() {
		return price;
	}
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", ownerId=" + ownerId + ", model=" + model + ", mileage=" + mileage + ", seats="
				+ seats + ", price=" + price + ", type=" + type + "]";
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getMileage() {
		return mileage;
	}
	public void setMileage(Double mileage) {
		this.mileage = mileage;
	}
	public Integer getSeats() {
		return seats;
	}
	public void setSeats(Integer seats) {
		this.seats = seats;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}



}
