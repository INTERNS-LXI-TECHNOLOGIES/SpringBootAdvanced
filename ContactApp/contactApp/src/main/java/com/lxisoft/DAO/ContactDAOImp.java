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
}
