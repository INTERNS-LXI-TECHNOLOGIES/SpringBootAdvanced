package com.lxisoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.model.ExamModel;

@Repository("MockDao")
public interface ExamDAO extends JpaRepository<ExamModel, Integer> {

}