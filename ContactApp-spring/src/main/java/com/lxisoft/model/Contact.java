package com.lxisoft.model;
//import com.lxisoft.controller.*;
import java.util.Scanner;
import com.lxisoft.servlet.*;

public class Contact //implements Comparable <Contact>
{
	public String firstname,number,lastname;
	public int id;

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
