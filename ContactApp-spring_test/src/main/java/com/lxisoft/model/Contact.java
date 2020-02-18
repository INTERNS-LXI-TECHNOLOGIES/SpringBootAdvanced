package com.lxisoft.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Scanner;
import com.lxisoft.controller.*;

@Entity
@Table(name = "contact")
public class Contact //implements Comparable <Contact>
{
//	public String firstname,number,lastname;
//	public int id;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
 
    @Column
    public String firstname;
 
    @Column
    public String number;
 
    @Column
    public String lastname;
 
    
	public void setFirstname(String firstname)
	{
		this.firstname= firstname;
	}      
	public String getFirstname()
	{
		return this.firstname;
	}
	public void setLastname(String lastname)
	{
		this.lastname= lastname;
	}      
	public String getLastname()
	{
		return this.lastname;
	}
	public void setNumber(String number)
	{
		this.number= number; 
	}
	public String getNumber()
	{
		return this.number;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getId()
	{
		return this.id;
	}
	// public int compareTo(Contact c)
	// {
	// 	int z= this.getName().compareTo(c.getName());
	// 	return z;
	// }
}