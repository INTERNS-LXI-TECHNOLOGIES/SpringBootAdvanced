package com.lxisoft.DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lxisoft.domain.Contact;
import java.util.List;
@Repository
public class ContactDAOImp implements ContactDAO {

	 @Autowired
    private SessionFactory sessionFactory;
 
    public void addContact(Contact contact) {
        sessionFactory.getCurrentSession().saveOrUpdate(contact);
 
    }
    @SuppressWarnings("unchecked")
    public List<Contact> getAllContact() {
 
        return sessionFactory.getCurrentSession().createQuery("from Contact")
                .list();
    }
    @Override
    public void deleteContact(Integer contactId) {
       Contact contact = (Contact) sessionFactory.getCurrentSession().load(
                Contact.class, contactId);
        if (null != contact) {
            this.sessionFactory.getCurrentSession().delete(contact);
        }
    }
    public Contact getContact(int contactId) 
    {
        return (Contact) sessionFactory.getCurrentSession().get(
                Contact.class, contactId);
    }
    @Override
    public Contact updateContact(Contact contact) {
        sessionFactory.getCurrentSession().update(contact);
        return contact;
    }
    
}
