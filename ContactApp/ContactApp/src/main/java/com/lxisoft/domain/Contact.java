package com.lxisoft.domain;
import javax.persistence.*;
@Entity
@Table(name="contacts")
public class Contact 
{
	@Column(name="ID")
	private int id;
	private String firstName;
	private String lastName;
	private String fullName;
	private String phno;
	
	public void setId(int id)
	{
		this.id=id;
	}
	public void setFirstName(String firstName)
	{ 
		this.firstName=firstName;
	}
	public void setLastName(String lastName)
	{ 
		this.lastName=lastName;
	}
	public void setNo(String phno)
	{
		this.phno=phno;
	}
	public int getId()
	{
		return this.id;
	}
	public String getFirstName()
	{
		return this.firstName;
	}
	public String getLastName()
	{
		return this.lastName;
	}
	public String getFullName()
	{
		return this.firstName+ " " +this.lastName;
	}
	public String getNo()
	{
		return this.phno;
	}
	public boolean equals(Object obj)
	{
		Contact contact=(Contact)obj;
		if(this.fullName.equals(contact.getFullName()))
			return true;
		else return false;
	}
}
