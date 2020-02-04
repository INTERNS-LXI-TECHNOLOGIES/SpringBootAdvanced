package com.lxisoft.services;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxisoft.domain.Contact;
import com.lxisoft.models.ContactModel;
import com.lxisoft.models.ContactsListModel;
import com.lxisoft.repository.Repository;

@Service
public class ContactServices 
{
	@Autowired
	Repository repo;
	
	public ArrayList<ContactModel> getAllContacts() throws SQLException
	{
		
		ArrayList<Contact> contactList=repo.getAllContacts();
		ContactsListModel contactlistmodel=new ContactsListModel();
	    if(contactList!=null)
	    { 
	      for(int i=0;i<contactList.size();i++)
	      {
	        ContactModel contactmodel=new ContactModel();
	        contactmodel.setId(contactList.get(i).getId());
	        contactmodel.setFirstName(contactList.get(i).getFirstName());
	        contactmodel.setLastName(contactList.get(i).getLastName());
	        contactlistmodel.setAllContacts(contactmodel);
	      }
	    }
	    ArrayList<ContactModel> contacts=contactlistmodel.getAllContacts();
		return contacts;
	}
}
