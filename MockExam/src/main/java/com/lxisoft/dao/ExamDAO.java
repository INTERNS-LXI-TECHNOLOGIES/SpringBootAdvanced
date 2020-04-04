package com.lxisoft.dao;

import java.util.List;

import com.lxisoft.model.ExamModel;

public interface ExamDAO {

	public void addQuestion(ExamModel models);

	public List<ExamModel> findAllQuestions();

	

	}

