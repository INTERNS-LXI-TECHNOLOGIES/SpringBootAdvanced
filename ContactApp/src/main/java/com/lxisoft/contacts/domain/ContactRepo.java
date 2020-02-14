package com.lxisoft.contacts.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ContactRepo 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String phno;
	
	public void setId(Integer id)
	{
		this.id=id;
	}
	public Integer getId()
	{
		return id;
	}
	
	public void setFirstName(String name)
	{
		this.firstName=name;
	}public void setLastName(String name)
	{
		this.lastName=name;
	}

	public void setNo(String phno)
	{
		this.phno=phno;
	}
	
	public String getFirstName()
	{
		return firstName;
	}public String getLastName()
	{
		return lastName;
	}
	public String getNo()
	{
		return phno;
	}
	

}
