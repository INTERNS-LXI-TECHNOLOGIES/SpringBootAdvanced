package com.gokul.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gokul.entity.Request;

@Repository("requestRepository")
public interface RequestRepository extends JpaRepository<Request, Integer> {

}
