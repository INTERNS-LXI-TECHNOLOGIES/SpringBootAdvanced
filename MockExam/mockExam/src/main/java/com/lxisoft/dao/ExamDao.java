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
    
    public void deleteExam(Integer examSlno) {
        ExamModel exam = (ExamModel) sessionFactory.getCurrentSession().load(
                ExamModel.class, examSlno);
        if (null != exam) {
            this.sessionFactory.getCurrentSession().delete(exam);
        }
 
    }
 
    public ExamModel updateExam(ExamModel exam) {
        sessionFactory.getCurrentSession().update(exam);
        return exam;
    }
    
    public ExamModel getExam(int eid) {
        return (ExamModel) sessionFactory.getCurrentSession().get(
                ExamModel.class, eid);
    }
}
