package com.lxisoft.contacts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contact")
public class Contacts
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="fname")
	private String fName;
	@Column(name="lname")
	private String lName;
	@Column(name="number")
	private String number;
	
	public void setId(int i)
	{
		this.id=i;
	}
	public int getId()
	{
		return id;
	}
	
	public void setFName(String na)
	{
		this.fName=na;
	}
	public void setLName(String na)
	{
		this.lName=na;
	}
	public String getfName()
	{
		return fName;
	}
	public String getLName()
	{
		return lName;
	}
	public void setNumber(String num)
	{
		this.number=num;
	}
	public String getNumber()
	{
		return number;
	}

}
