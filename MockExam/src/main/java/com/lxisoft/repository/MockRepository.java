package com.lxisoft.repository;

import java.util.List;

//import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lxisoft.model.*;

@Repository
public class MockRepository {
	
	@Autowired
    private SessionFactory sessionFactory;

	public void addMockQuestion(MockModel mockMmodel)
	{
		this.sessionFactory.getCurrentSession().saveOrUpdate(mockMmodel);
	}
		
   @SuppressWarnings("unchecked")
   public List<MockModel> getAllQuestions() {
	   
        return sessionFactory.getCurrentSession().createQuery("from MockModel")
                .list();
    }

	public void deleteQuestion(Integer questionId) {
		
		MockModel mockModel = (MockModel) sessionFactory.getCurrentSession().load(
                MockModel.class, questionId);
        if (null != mockModel) {
            this.sessionFactory.getCurrentSession().delete(mockModel);
        }
	}

	public MockModel updateQuestion(MockModel mockModel) {
		 sessionFactory.getCurrentSession().update(mockModel);
	        return mockModel;
	}

	public MockModel getQuestionId(int mockid) {
		return (MockModel) sessionFactory.getCurrentSession().get(
                MockModel.class, mockid);
	}

}
