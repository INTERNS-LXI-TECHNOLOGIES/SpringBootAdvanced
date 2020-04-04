package com.lxisoft.service;

import java.util.List;

import com.lxisoft.model.ExamModel;

public interface ExamService {
	
	public void addQueston(ExamModel models);

	public List<ExamModel> findAllQuestions();

	
}
