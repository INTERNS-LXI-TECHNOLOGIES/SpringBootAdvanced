package com.lxisoft.contacts.model;
import java.util.List;

import com.lxisoft.contacts.domain.Contact;
public interface ContactDao
{
	public void persist(Contact contact);
	public List<Contact> getAllContacts();
	public void delete(Contact c);
}