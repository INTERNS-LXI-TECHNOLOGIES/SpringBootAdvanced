package com.lxisoft.contacts.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.contacts.domain.Contact;
import com.lxisoft.contacts.model.ContactDao;
import com.lxisoft.contacts.model.ContactDaoImpl;

@Service
@Transactional

public class ContactServiceImpl implements ContactService
{
	@Autowired
	private ContactDao contactDao;

	@Override
	public void addContact(Contact c) {
		contactDao.addContact(c);
		
	}

	@Override
	public List<Contact> listContacts() {
		// TODO Auto-generated method stub
		return contactDao.listContacts();
	}

	@Override
	public Contact getContact(int id) {
		// TODO Auto-generated method stub
		return contactDao.getContact(id);
	}

	@Override
	public void deleteContact(Contact c) {
		contactDao.deleteContact(c);
		
	}
	

}
