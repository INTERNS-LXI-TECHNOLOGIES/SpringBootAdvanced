package com.lxisoft.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lxisoft.DAO.ContactDao;
import com.lxisoft.domain.Contact;

public class ContactServiceImpl implements ContactService 
{

	@Autowired 
	ContactDao contact;
	
	@Override
	public List<Contact> getAllContacts() {
		
		return contact.getAllContacts();
	}

}
