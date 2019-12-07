package com.lxisoft.RunWay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.RunWay.model.LoginUser;

@Repository
public interface LoginUserRepository extends JpaRepository<LoginUser,Long>{

}
