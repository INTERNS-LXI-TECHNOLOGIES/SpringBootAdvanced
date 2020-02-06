package com.lxisoft.domain;
import java.util.*;
/**
 *pojo: class for set and get contact details
 */
public class Contact
{
	/**
	 *instance variables id, first name, last name and number
	 */
	private int contactId;
	private String contactFirstName;
	private String contactLastName;
	private String contactNumber;
	/**
	 *to set contact id
	 *
	 *@param id
	 */
	public void setContactId(int contactId)
	{
		this.contactId=contactId;
	}
	/**
	 *to get contact id
	 *
	 *@return contactId
	 */
	public int getContactId()
	{
		return contactId;
	}
	/**
	 *to set contact first name
	 *
	 *@param contactFirstName
	 */
	public void setContactFirstName(String contactFirstName)
	{
		this.contactFirstName=contactFirstName;
	}
	/**
	 *to get contact first name
	 *
	 *@return contactFirstName
	 */
	public String getContactFirstName()
	{
		return contactFirstName;
	}
	/**
	 *to set contact last name
	 *
	 *@param contactLastName
	 */
	public void setContactLastName(String contactLastName)
	{
		this.contactLastName=contactLastName;
	}
	/**
	 *to get contact last name
	 *
	 *@return contactLastName
	 */
	public String getContactLastName()
	{
		return contactLastName;
	}
	/**
	 *to set contact number
	 *
	 *@param contactNumber
	 */
	public void setContactNumber(String contactNumber)
	{
		this.contactNumber=contactNumber;
	}
	/**
	 *to get contact number
	 *
	 *@return contactNumber
	 */
	public String getContactNumber()
	{
		return contactNumber;
	}
}