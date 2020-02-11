package com.lxisoft.DAO;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lxisoft.domain.Contact;

@Repository
public class ContactDaoImpl implements ContactDao
{

	
	@Autowired
    private SessionFactory sessionFactory;
	
	
	/*
	 * @Override public void addContacts(Contact contact) { //
	 * sessionFactory.getCurrentSession()
	 * 
	 * }
	 */

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Contact> getAllContacts() {
		return (ArrayList<Contact>) sessionFactory.getCurrentSession().createQuery("from contactlist").list();
		
	}
	/*
	 * @Override public void deleteContact(Integer id) { // TODO Auto-generated
	 * method stub
	 * 
	 * }
	 */

	/*
	 * @Override public Contact updateContact(Contact contact) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public Contact getContact(int id) { // TODO Auto-generated method
	 * stub return null; }
	 */

}
