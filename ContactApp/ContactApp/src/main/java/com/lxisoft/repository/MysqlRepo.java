package com.lxisoft.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.domain.Contact;
//@Component
@Repository
@Transactional
public class MysqlRepo implements MysqlRepository
{
	{System.out.println("list^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");}
	
	@PersistenceContext 
	private EntityManager em;
	

	@Override
	public List<Contact> getAllContacts() {
		
	List<Contact> contactlist = em.createQuery("Select a From Contact a", Contact.class).getResultList();
	        return contactlist;
//	return manager.getCurrentSession().createQuery("from Contact").list();
//		TypedQuery<Contact> query = em.createQuery("SELECT g FROM Contact g ORDER BY g.id", Contact.class);
//	        return query.getResultList();
	}

	@Override
	public void addContacts(Contact contact) {
		        em.persist(contact);
		
	}
//
//	@Override
//	public void deleteContact(Contact contact) 
//	{
//            em.getCurrentSession().delete(contact);
//		
//	}
//
//	@Override
//	public Contact getContact(int id) {
//		return (Contact) em.getCurrentSession().get(Contact.class, id);
//	}
//
//	@Override
//	public Contact updateContact(Contact contact) {
//		 em.getCurrentSession().update(contact);
//		return contact;
//	}
//
//	@Override
//	public void deleteAllContacts() {
//		em.getCurrentSession().createSQLQuery ("truncate table contactlist"). executeUpdate ();
//		
//	}



}
