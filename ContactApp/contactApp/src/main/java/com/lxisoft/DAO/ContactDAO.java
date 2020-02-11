package com.lxisoft.DAO;

import com.lxisoft.domain.Contact;

import java.util.List;

public interface ContactDAO {

	public void addContact(Contact contact);
	public List<Contact> getAllContact();
}
