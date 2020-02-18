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
     
    public ArrayList<Contact> findAll() 
    {
        return ( ArrayList<Contact>) manager.createQuery("Select a From contactList a", Contact.class).getResultList();
    }
	
}
