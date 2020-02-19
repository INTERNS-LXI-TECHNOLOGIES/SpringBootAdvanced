package com.lxisoft.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.domain.Contact;
import java.util.List;
@Repository
@Transactional
public class ContactDAOImp implements ContactDAO {

	 @PersistenceContext
	 private EntityManager manager;
	     
	    public List<Contact> getAllContact() 
	    {
	    	List<Contact> contactlist = manager.createQuery("Select a From Contact a", Contact.class).getResultList();
	        return contactlist;
	    }	     
	    public void addContact(Contact contact)  
	    {
	        manager.persist(contact);
	    }
    
}
