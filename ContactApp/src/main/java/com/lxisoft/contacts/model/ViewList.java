package com.lxisoft.contacts.model;
import com.lxisoft.contacts.domain.*;
import com.lxisoft.contacts.model.*;

import java.io.*;
import java.util.*;


public class ViewList {
	
	private ArrayList<ViewListModel> viewList =new ArrayList<ViewListModel>();
	
	public void setContact(Contact contact)
	{
		ViewListModel list=new ViewListModel();
		list.setId(contact.getId());
		list.setFirstName(contact.getFirstName());
		list.setLastName(contact.getLastName());
		list.setFullName(contact.getFullName());
		viewList.add(list);
	}
	
	public ArrayList<ViewListModel> getAllContacts()
	{
		return viewList;
	}
	
	public void clearArray()
	{
		viewList.clear();
	}

}
