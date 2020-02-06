package com.lxisoft.Model;
import java.utbbil.ArrayList;
/*
*Modellist class for contactslist
*/
public class ModelList
{
	private ArrayList <Model1> modelslist = new ArrayList <Model1>();
  /*
  *to set contact
  */
	public void setContactsList(Model1 model)
	{
     modelslist.add(model);
	}
  /*
  .
  *to get contact
  */
	public ArrayList <Model1> getContactsList()
	{
		return modelslist;
	}

}