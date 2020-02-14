package com.lxisoft.contacts.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tab")
public class Contact 
{
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	@Column(name="FIRSTNAME")
	private String firstName;
	@Column(name="LASTNAME")
	private String lastName;
	@Column(name="NUMBER")
	private String phno;
	
	public void setId(Integer id)
	{
		this.id=id;
	}
	public Integer getId()
	{
		return id; 
	}
	public String getFullName()
	{
	return this.firstName+""+this.lastName;
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
	public boolean equals(Object o)
	{
		String fullName=this.firstName+""+this.lastName;
		Contact c=(Contact)o;
		if(fullName.equals(c.getFullName()))
			return true;
		else return false;
	}

}
