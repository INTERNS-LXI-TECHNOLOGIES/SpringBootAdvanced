package com.lxisoft.contacts.service;

import java.util.List;

import com.lxisoft.contacts.domain.Contact;

public interface ContactService 
{
	public void addContact(Contact c);
	public List<Contact> listContacts();
	public Contact getContact(int id);	
	public void deleteContact(Contact c);

}
