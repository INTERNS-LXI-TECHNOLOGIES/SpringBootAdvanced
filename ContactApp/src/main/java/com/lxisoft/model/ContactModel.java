package com.lxisoft.model;					
/**
 *model class:contact model with contact id and contact name
 */
public class ContactModel
{
	/**
	 *instance variable id and name
	 */
	private int id;
	private String firstName;
	private String lastName;
	/**
	 *to set id for contact
	 *
	 *@param id contact id
	 */
	public void setId(int id)
	{
		this.id=id;
	}
	/**
	 *to get id for contact
	 *
	 *@return id
	 */
	public int getId()
	{
		return id;
	}
	/**
	 *to set first name for contact
	 *@param firstName contact first name
	 */
	public void setFirstName(String firstName)
	{
		this.firstName=firstName;
	}
	/**
	 *@return contact first name
	 */
	public String getFirstName()
	{
		return firstName;
	}
	/**
	 *to set last name for contact
	 *@param lastName contact last name
	 */
	public void setLastName(String lastName)
	{
		this.lastName=lastName;
	}
	/**
	 *@return contact last name
	 */
	public String getLastName()
	{
		return lastName;
	}

}