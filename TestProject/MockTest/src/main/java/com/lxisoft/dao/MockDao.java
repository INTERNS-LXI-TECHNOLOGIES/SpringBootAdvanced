package com.lxisoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.model.MockModel;

@Repository("MockDao")
public interface MockDao extends JpaRepository<MockModel, Integer> {

}
