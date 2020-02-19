package com.lxisoft.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.domain.Contact;
import com.lxisoft.repository.MysqlRepository;

@Service
public class ContactServiceImpl implements ContactService 
{
	@Autowired 
	MysqlRepository repo;
	
	@Override
	public List<Contact> getAllContacts() {
		return repo.getAllContacts();
	}

	@Override
	public void addContact(Contact contact) {
		repo.addContacts(contact);
		
	}
//
//	
//	@Override
//	public void deleteContact(Contact contact) {
//		repo.deleteContact(contact);
//		
//	}
//
////	@Override
////	public Contact getContact(int id) {
////		  return repo.getContact(id);
////	}
//
//	@Override
//	public Contact updateContact(Contact contact) {
//		return repo.updateContact(contact);
//	}
//
//	@Override
//	public Contact getContact(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void clearRepository() {
//		repo.deleteAllContacts();
//		
//	}



}
