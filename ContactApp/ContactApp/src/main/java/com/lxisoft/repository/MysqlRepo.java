package com.lxisoft.repository;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.lxisoft.domain.Contact;

@Repository
public class MysqlRepo implements MysqlRepository
{

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public List<Contact> getAllContacts() {
		
		return sessionFactory.getCurrentSession().createQuery("from Contact").list();
	}

	@Override
	public void addContacts(Contact contact) {
		System.out.println(contact);
		 sessionFactory.getCurrentSession().saveOrUpdate(contact);
		
	}

	@Override
	public void deleteContact(Contact contact) 
	{
            sessionFactory.getCurrentSession().delete(contact);
		
	}

	@Override
	public Contact getContact(int id) {
		return (Contact) sessionFactory.getCurrentSession().get(Contact.class, id);
	}

	@Override
	public Contact updateContact(Contact contact) {
		 sessionFactory.getCurrentSession().update(contact);
		return contact;
	}

	@Override
	public void deleteAllContacts() {
		sessionFactory.getCurrentSession().createSQLQuery ("truncate table contactlist"). executeUpdate ();
		
	}



}
