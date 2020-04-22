package com.lxisoft.service;

import java.util.List;

import com.lxisoft.entity.Exam;
import com.lxisoft.exception.ResourceNotFoundException;

public interface ExamService {

    public List <  Exam > getExams();

    public void saveCustomer(Exam theExam);

    public  Exam getCustomer(int theId) throws ResourceNotFoundException;

    public void deleteCustomer(int theId) throws ResourceNotFoundException;
}