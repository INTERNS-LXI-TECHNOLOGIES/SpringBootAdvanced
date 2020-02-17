package com.lxisoft.domain;
import javax.persistence.*;


@Entity
@Table(name="contactlist")
public class Contact 

{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="FIRSTNAME")
	private String firstName;
	@Column(name="LASTNAME")
	private String lastName;
	@Column(name="NUMBER")
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
		String fullName=this.firstName+ " " +this.lastName;
		Contact contact=(Contact)obj;
		if(fullName.equals(contact.getFullName()))
			return true;
		else return false;
	}
}
