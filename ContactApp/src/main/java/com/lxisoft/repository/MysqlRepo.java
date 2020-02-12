package com.lxisoft.repository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.lxisoft.domain.Contact;
@Repository
public class MysqlRepo {

	@Autowired
	private SessionFactory sessionFactory;
	{System.out.println("mysql{{{{{{{{{{");}
	
	public void save(Contact contact) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(contact);	
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

}
