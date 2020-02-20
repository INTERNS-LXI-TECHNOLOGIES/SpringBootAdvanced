package com.lxisoft.contacts.service;

import java.util.List;

import com.lxisoft.contacts.domain.Contact;

public interface ContactService 
{
	public void persist(Contact contact);
	public List<Contact> getAllContacts();
	public void delete(Contact c);

}
