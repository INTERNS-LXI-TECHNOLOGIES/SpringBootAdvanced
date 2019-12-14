package com.lxisoft.RunWay.model;
 

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class BookedDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private Long bookId;
private Long customerId;
private Long ownerId;
private Long vehicleId;
private Float amount;
@Temporal(TemporalType.TIMESTAMP)
private Date date;
public Long getCustomerId() {
	return customerId;
}
public void setCustomerId(Long customerId) {
	this.customerId = customerId;
}
public Long getOwnerId() {
	return ownerId;
}
public void setOwnerId(Long ownerId) {
	this.ownerId = ownerId;
}
public Long getVehicleId() {
	return vehicleId;
}
public void setVehicleId(Long vehicleId) {
	this.vehicleId = vehicleId;
}
public Float getAmount() {
	return amount;
}
public void setAmount(Float amount) {
	this.amount = amount;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
}
