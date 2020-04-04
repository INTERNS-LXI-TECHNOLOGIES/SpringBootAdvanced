package com.lxisoft.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lxisoft.model.ExamModel;

@Repository
public class ExamDAOImpl implements ExamDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addQuestion(ExamModel models) {
		sessionFactory.getCurrentSession().saveOrUpdate(models);

	}

	@SuppressWarnings("unchecked")
	public List<ExamModel> findAllQuestions() {

		return sessionFactory.getCurrentSession().createQuery("from ExamModel")
				.list();
	}

}
	
	