package com.lxisoft.services;

import java.util.List;

import com.lxisoft.domain.Contact;

public interface ContactService 
{
		 public void addContact(Contact contact);
	 
	    public List<Contact> getAllContacts();
//	 
//	  public void deleteContact(Contact contact);
//	  
//	  public Contact getContact(int id);  
//	  public Contact updateContact(Contact contact);
//
//	public void clearRepository();
	 
}
