package com.lxisoft.domain;

public class Contact implements Comparable<Contact>
{
	private String id;
	private String firstName;
	private String lastName;
	private String number;

	public void setId(String id)
	{
		this.id=id;
	} 

	public String getId()
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