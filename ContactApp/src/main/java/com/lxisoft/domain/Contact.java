package com.lxisoft.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contactList")
public class Contact implements Comparable<Contact>
{
	@Id
	@Column (name="ID")
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int id;

	@Column(name=" FIRST_NAME")
	private String firstName;

	@Column (name="LAST_NAME")
	private String lastName;

	@Column (name="NUMBER")
	private String number;	
	

	public void setId(int id)
	{
		this.id=id;
	} 

	public int getId()
	{
		return id;
	} 

	public void setFName(String firstName)
	{
		this.firstName=firstName;
	} 

	public void setLName(String lastName)
	{
		this.lastName=lastName;
	} 

	public void setNumber(String number)
	{
		this.number=number;
	} 

	public String getFName()
	{
		return firstName;
	}

	public String getLName()
	{
		return lastName;
	}

	public String getNumber()
	{
		return number;
	}

	public int compareTo(Contact contact)
	{
		String temp=contact.getFName()+" "+contact.getLName();
		return (this.getFName()+" "+this.getLName()).compareTo(temp);
	}
}