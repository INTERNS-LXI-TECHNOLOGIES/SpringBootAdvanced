package com.lxisoft.Models;

import com.lxisoft.Repository.*;
import com.lxisoft.Domain.*;

import com.lxisoft.Models.*;

import java.io.*;
import java.util.*;
/**
*class to contain the model arraylists
*/
public class ViewList
{

	private ArrayList<ViewListModel> viewList =new ArrayList<ViewListModel>();
	/**
	*method to get id and name and set to the new contact model
	*/
	public void setContact(Contact contact)
	{
		ViewListModel list=new ViewListModel();
		list.setId(contact.getId());
		list.setFirstName(contact.getFirstName());
		list.setLastName(contact.getLastName());
		list.setFullName(contact.getFullName());
		viewList.add(list);
	}
	/**
	*method to get contactlist array
	*@return return the array list
	*/
	public ArrayList<ViewListModel> getAllContacts()
	{
		return viewList;
	}
	/**
	*method to get the array clear
	*/
	public void clearArray()
	{
		viewList.clear();
	}
}
