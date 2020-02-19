package com.lxisoft.DAO;

import com.lxisoft.domain.Contact;

import java.util.List;

public interface ContactDAO {

	public void addContact(Contact contact);
	public List<Contact> getAllContact();
//	public void deleteContact(Integer contactId);
//	public Contact getContact(int contactId);
//	public Contact updateContact(Contact contact);
}
