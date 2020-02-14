package com.lxisoft.Models;
public class ViewListModel
{
	private int id;
	private String firstName;
	private String lastName;
	private String fullName;

	public void setId(int id)
	{
		this.id=id;
	}
	public int getId()
	{
		return id;
	}
	public void setFirstName(String name)
	{
		this.firstName=name;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public void setLastName(String name)
	{
		this.lastName=name;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setFullName(String name)
		{
			this.fullName=name;
		}
		public String getFullName()
		{
			return fullName;
		}
}
