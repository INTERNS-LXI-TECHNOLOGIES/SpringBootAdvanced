package com.lxisoft.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.model.MockModel;

@Repository("MockRepository")
public interface MockRepository extends JpaRepository<MockModel, Integer> {

}