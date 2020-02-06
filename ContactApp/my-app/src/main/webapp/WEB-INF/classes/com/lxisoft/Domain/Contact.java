package com.lxisoft.Domain;
//import com.lxisoft.Controller.Controller;
/*
*pojo - class for set and get contactdetails
*/
public class Contact
{ 
  private String name;
	private String number;
	private int id;
  /*
  *to set name
  */
	public void setName(String n)
	{
      this.name = n;
	}
  /*
  *to get name
  */
	public String getName()
   {
     return this.name;
   }  
  /*
  *to set number TreeSet<String> al=new TreeSet<String>();  
  */
   public void setNumber(String no)
   {
    this.number = no;
   }
  /*
  *to get number
  */
   public String getNumber()
   {
     return this.number;
   }
  /*
  *to set id
  */
     public void setId(int id)
   {
    this.id = id;
   }
  /*
  *to get id
  */
   public int getId()
   {
     return this.id;
   }
  
}