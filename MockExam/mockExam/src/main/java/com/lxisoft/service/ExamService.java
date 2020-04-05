package com.lxisoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.dao.ExamDao;
import com.lxisoft.model.ExamModel;
 
@Service
@Transactional
public class ExamService {
 
    @Autowired
    private ExamDao examDao;
 
  
    @Transactional
    public void addExam(ExamModel exam) {
        examDao.addExam(exam);
    }
 
  
    @Transactional
    public List<ExamModel> getAllExam() {
        return examDao.getAllExam();
    }
    
    @Transactional
    public void deleteExam(Integer examSlno) {
        examDao.deleteExam(examSlno);
    }
    
    public ExamModel updateExam(ExamModel exam) {
        // TODO Auto-generated method stub
        return examDao.updateExam(exam);
    }
 
   public void setExamDao(ExamDao examDao) {
        this.examDao = examDao;
    }
   
   public ExamModel getExam(int eid) {
       return examDao.getExam(eid);
   }
 
}

