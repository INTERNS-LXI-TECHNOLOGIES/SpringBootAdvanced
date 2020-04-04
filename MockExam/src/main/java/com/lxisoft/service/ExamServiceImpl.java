package com.lxisoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.dao.ExamDAO;
import com.lxisoft.model.ExamModel;

@Service
@Transactional
public class ExamServiceImpl implements ExamService {

	@Autowired
	private ExamDAO examDAO;

	@Override
	@Transactional
	public void addQuestion(ExamModel models) {
		examDAO.addQuestion(models);
	}

	@Override
	@Transactional
	public List<ExamModel> findAllQuestions() {
		return examDAO.findAllQuestions();
	}

	
}



