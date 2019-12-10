package com.lxisoft.RunWay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.RunWay.model.Customer;


@Repository
public interface RegisteredUserRepository extends JpaRepository<Customer,Long>{

}
