package com.lxisoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxisoft.domain.Contact;
import com.lxisoft.DAO.ContactDAO;

@Service

public class ContactServiceImp implements ContactService{
	@Autowired
    private ContactDAO contactDAO;
	
	@Override
    
    public void addContact(Contact contact) {
		contactDAO.addContact(contact);
    }
	@Override

	public List<Contact> getAllContact()
	{
		return contactDAO.getAllContact();
	}
//	 @Override
//    public void deleteContact(Integer contactId) {
//        contactDAO.deleteContact(contactId);
//    }
//	 public Contact getContact(int contactId) {
//	        return contactDAO.getContact(contactId);
//	    }
//	 public Contact updateContact(Contact contact) {
//	        // TODO Auto-generated method stub
//	        return contactDAO.updateContact(contact);
//	    }
}
