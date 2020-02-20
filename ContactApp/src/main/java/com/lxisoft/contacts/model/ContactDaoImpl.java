package com.lxisoft.contacts.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.contacts.domain.Contact;

@Transactional
@Repository
public class ContactDaoImpl implements ContactDao 
{
	 // Injected database connection:
    @PersistenceContext private EntityManager em;

 // Stores a new guest:
    
    public void persist(Contact contact) {
        em.persist(contact);
    }

    // Retrieves all the guests:
    public List<Contact> getAllContacts() {
        TypedQuery<Contact> query = em.createQuery( "SELECT g FROM Contact g ORDER BY g.id", Contact.class);
        return query.getResultList();
    }
    public void delete(Contact c) {
    	em.remove(em.contains(c)?c :em.merge(c));
    }
}