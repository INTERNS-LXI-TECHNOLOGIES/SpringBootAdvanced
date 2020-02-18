package com.lxisoft.repository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.lxisoft.domain.Contact;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class MysqlRepo 
{	
	@PersistenceContext
    private EntityManager manager;
     
    @SuppressWarnings("unchecked")
	public ArrayList<Contact> findAll() 
    {
        return ( ArrayList<Contact>) manager.createQuery("Select a From Contact a").getResultList();
    }
    
    public void save(Contact contact) {
		manager.persist(contact);
	}
    
    public void delete(Contact contact) {
		manager.remove(contact);
	}
    
    public void edit(Contact newContact) {
		manager.merge(newContact);
	}
	
    public Contact findId(int id) {
		return manager.find(Contact.class, id);
	}
}
