package com.lxisoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.entity.Exam;
import com.lxisoft.exception.ResourceNotFoundException;
import com.lxisoft.repository.ExamRepository;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamRepository examRepository;

    @Override
    @Transactional
    public List < Exam > getExams() {
        return examRepository.findAll();
    }

    @Override
    @Transactional
    public void saveExam(Exam theExam) {
        examRepository.save(theExam);
    }

    @Override
    @Transactional
    public Exam getExam(int id) throws ResourceNotFoundException {
        return examRepository.findById(id).orElseThrow(
            () - > new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public void deleteExam(int theId) {
        examRepository.deleteById(theId);
    }
}