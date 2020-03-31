package com.lxisoft.service;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.model.*;
import com.lxisoft.repository.*;
@Service
public class ModelService {
	
	@Autowired
	private SqlRepository repository;
	
	@Transactional
    public void addQuestionService(Model model) {
        repository.insertIntoDatabase(model);
    }

}
