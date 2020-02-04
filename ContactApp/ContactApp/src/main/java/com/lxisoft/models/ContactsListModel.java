package com.lxisoft.models;

import java.util.ArrayList;

public class ContactsListModel 
{
	
		public ArrayList<ContactModel> contact=new ArrayList<ContactModel>();
		
		public void setAllContacts(ContactModel contactmodel)
		{
				contact.add(contactmodel);
		}
		
		public ArrayList<ContactModel> getAllContacts()
		{
			return contact;
		}

}
