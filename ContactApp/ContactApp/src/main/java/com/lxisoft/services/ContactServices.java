package com.lxisoft.services;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	public ArrayList<ContactModel> getAllContacts(int pageid,int total) throws SQLException
	{
		
		
		ArrayList<Contact> contactList=repo.getAllContacts(pageid,total);
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

	public ArrayList<Contact> getRepoContacts() throws SQLException
	{
		ArrayList<Contact> contactList=repo.getAllContacts();
		return contactList;
	}

	public void writeContact(HttpServletRequest request, HttpServletResponse response) 
	{
		Contact contact=(Contact) request.getAttribute("contacts");
		repo.addContactDetails(contact);
	}

	public void updateRepo(Contact contact) throws SQLException 
	{
	 repo.updateRepo(contact);
	}

	public void clearRepository() throws SQLException {
		 repo.clearRepository();
		
	}

	public void deleteContact(Contact contact) {
		try {
			repo.deleteContact(contact);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void sortContactByFirstName() 
	{
		try 
		{
			repo.sortContactByFirstName();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void sortContactByLastName() 
	{
		try
		{
			repo.sortContactByLastName();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
