package com.lxisoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.entity.*;

@Repository("MockDao")
public interface MockDao extends JpaRepository<MockEntity, Integer> {

}
