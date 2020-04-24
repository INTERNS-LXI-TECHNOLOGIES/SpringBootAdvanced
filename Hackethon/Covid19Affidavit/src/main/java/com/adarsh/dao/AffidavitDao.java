package com.adarsh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adarsh.entity.AffidavitEntity;

@Repository("AffidavitDao")
public interface AffidavitDao extends JpaRepository<AffidavitEntity, Integer>{

}
