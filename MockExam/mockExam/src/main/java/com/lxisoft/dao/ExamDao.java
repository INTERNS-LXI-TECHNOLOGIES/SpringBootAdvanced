package com.lxisoft.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lxisoft.model.ExamModel;
 
@Repository
public class ExamDao {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    public void addExam(ExamModel exam) {
        sessionFactory.getCurrentSession().saveOrUpdate(exam);
 
    }
 
    @SuppressWarnings("unchecked")
    public List<ExamModel> getAllExam() {
 
        return sessionFactory.getCurrentSession().createQuery("from ExamModel")
                .list();
    }
 
}
