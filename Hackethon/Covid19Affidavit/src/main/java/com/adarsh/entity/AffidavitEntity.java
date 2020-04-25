package com.adarsh.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "Covid19")
public class AffidavitEntity implements Serializable {
	
	private static final long serialVersionUID = -3465813074586302847L;
	
	@Id
    @Column(name="idMa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMa;
	
	@Column(name = "nameMa")
	private String nameMa;
	
	@Column(name = "phoneNumberMa")
	private String phoneNumberMa;
	
	@Column(name="addressMa")
	private String addressMa;
	
	@Column(name = "vehicleNoMa")
	private String vehicleNoMa;
	
	@Column(name = "vehicleType")
	private String vehicleTypeMa;
	
	@Column(name = "startingLocationMa")
	private String startingLocationMa;
	
	@Column(name = "destinationMa")
	private String destinationMa;
	
	@Column(name = "startDateMa")
	private String startDateMa;
	
	@Column(name = "endDateMa")
	private String endDateMa;
	
	@Column(name = "coPassengerNameMa")
	private String coPassengerNameMa;
	
	@Column(name = "relationMa")
	private String relationMa;
	
	@Column(name = "reasonMa")
	private String reasonMa;
	
	@Column(name = "rejectMa")
	private String rejectMa;
	
	public void setidMa(int idMa)
	{
		this.idMa = idMa;
	}
	public int getIdMa()
	{
		return idMa;
	}
	
	public void setNameMa(String nameMa)
	{
		this.nameMa = nameMa;
	}
	
	public String getNameMa()
	{
		return nameMa;
	}
	
	public void setPhoneNumberMa(String phoneNumberMa)
	{
		this.phoneNumberMa = phoneNumberMa;
	}
	
	public String getPhoneNumberMa()
	{
		return phoneNumberMa;
	}
	
	public void setAddressMa(String addressMa)
	{
		this.addressMa = addressMa;
	}
	
	public String getAddressMa()
	{
		return addressMa;
	}
	
	public void setvehicleNoMa(String vehicleNoMa)
	{
		this.vehicleNoMa = vehicleNoMa;
	}
	
	public String getVehicleNoMa()
	{
		return vehicleNoMa;
	}
	
	public void setVehicleTypeMa(String vehicleTypeMa)
	{
		this.vehicleTypeMa = vehicleTypeMa;
	}
	
	public String getVehicleTypeMa()
	{
		return vehicleTypeMa;
	}
	
	public void setStartingLocationMa(String startingLocationMa)
	{
		this.startingLocationMa = startingLocationMa;
	}
	
	public String getStartingLocationMa()
	{
		return startingLocationMa;
	}
	
	public void setDestinationMa(String destinationMa)
	{
		this.destinationMa = destinationMa;
	}
	
	public String getDestinationMa()
	{
		return destinationMa;
	}
	public void setStartDateMa(String startDateMa)
	{
		this.startDateMa = startDateMa;
	}
	
	public String getStartDateMa()
	{
		return startDateMa;
	}
	
	public void setEndDateMa(String endDateMa)
	{
		this.endDateMa = endDateMa;
	}
	
	public String getEndDateMa()
	{
		return endDateMa;
	}
	
	public void setCoPassengerNameMa(String coPassengerNameMa)
	{
		this.coPassengerNameMa = coPassengerNameMa;
	}
	
	public String getCoPassengerNameMa()
	{
		return coPassengerNameMa;
	}
	
	public void setRelationMa(String relationMa)
	{
		this.relationMa = relationMa;
	}
	
	public String getRelationMa()
	{
		return relationMa; 
	}
	
	public void setReasonMa(String reasonMa)
	{
		this.reasonMa = reasonMa;
	}
	
	public String getReasonMa()
	{
		return reasonMa;
	}
	
	public void setRejectMa(String rejectMa)
	{
		this.rejectMa = rejectMa;
	}
	public String getRejectMa()
	{
		return rejectMa;
	}
}
