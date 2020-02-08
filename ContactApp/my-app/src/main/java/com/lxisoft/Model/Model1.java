package com.lxisoft.Model;

import java.util.ArrayList;

import com.lxisoft.Domain.Contact;

/*
*Model class
*/
public class Model1
{   
	private int id;
	private String name;
 /*
  *to set name
  */
	public void setName(String n)
	{
     this.name=n;
	}
	 /*
  *to get name
  */
	public String getName()
	{
      return this.name;
	}
	 /*
  *to set id
  */
	public void setId(int id)
	{
		this.id=id;
	}
	 /*
  *to get id
  */
	public int getId()
	{
		return this.id;
	}
	public void addAttribute(String string, ArrayList<Contact> contactList) {
		// TODO Auto-generated method stub
		
	}
}