package com.lxisoft.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lxisoft.model.*;
@Repository
public class SqlRepository {
	
	@Autowired
    private SessionFactory sessionFactory;

	public void insertIntoDatabase(Model model)
	{
		this.sessionFactory.getCurrentSession().save(model);
	}
}
