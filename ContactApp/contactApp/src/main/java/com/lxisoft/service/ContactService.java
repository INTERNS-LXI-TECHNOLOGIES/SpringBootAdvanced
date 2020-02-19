package com.lxisoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxisoft.domain.Contact;

@Service 

public interface ContactService {
	
	@Autowired
	public void addContact(Contact cont);
	public List<Contact> getAllContact();
//	public void deleteContact(Contact contact);
//	public Contact getContact(int contactId);
//	public Contact updateContact(Contact contact);

}
