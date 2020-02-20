package com.lxisoft.contacts.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.contacts.domain.Contact;
import com.lxisoft.contacts.model.ContactDao;

@Service

public class ContactServiceImpl implements ContactService
{
	@Autowired
	private ContactDao contactDao;
	
	
	@Override
	public void persist(Contact c) {
		contactDao.persist(c);
		
	}

	@Override
	public List<Contact> getAllContacts() {
		// TODO Auto-generated method stub
		return contactDao.getAllContacts();

	}
	public void delete(Contact c)
	{
		contactDao.delete(c);
	}
	

}
