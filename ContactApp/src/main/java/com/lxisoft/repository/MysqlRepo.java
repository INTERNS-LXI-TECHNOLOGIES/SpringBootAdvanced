package com.lxisoft.repository;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.lxisoft.domain.Contact;

public class MysqlRepo {

	@Autowired
	private SessionFactory sessionFactory;
	

	@SuppressWarnings("unchecked")
	public List<Contact> findAll() {

		return sessionFactory.getCurrentSession().createQuery("from contacts").list();
	}

}
