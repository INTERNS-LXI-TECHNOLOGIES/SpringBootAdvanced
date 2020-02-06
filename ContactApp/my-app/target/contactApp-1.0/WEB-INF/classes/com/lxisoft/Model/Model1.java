package com.lxisoft.Model;
import com.lxisoft.ctr.Controller;
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
}