package com.lxisoft.contacts.model;
import java.util.List;

import com.lxisoft.contacts.domain.Contact;
public interface ContactDao
{
	public void addContact(Contact c);
	public List<Contact> listContacts();
	public Contact getContact(int id);	
	public void deleteContact(Contact c);
}