package com.lxisoft.repository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.lxisoft.domain.Contact;
@Repository
public class MysqlRepo {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(Contact contact) 
	{
		sessionFactory.getCurrentSession().save(contact);	
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Contact> findAll()
	{
		ArrayList<Contact> contactList=(ArrayList<Contact>) sessionFactory.getCurrentSession().createQuery("from Contact").list();
		return contactList;
	}
	
	public void delete(Contact contact) {
		sessionFactory.getCurrentSession().delete(contact);
	}
	
	public Contact findId(String id)
	{
		Contact contact=(Contact)sessionFactory.getCurrentSession().get(Contact.class,Integer.parseInt(id));
		return contact;
	} 
	
	public void edit(Contact newcontact)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(newcontact);
	}

}
