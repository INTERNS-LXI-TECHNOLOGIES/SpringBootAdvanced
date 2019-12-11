package com.lxisoft.RunWay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lxisoft.RunWay.model.RegisteredUser;


@Repository
public interface RegisteredUserRepository extends JpaRepository<RegisteredUser,Long>{
	@Query(value = "select username,password,type from Customer c where c.username = :name AND c.password=:password AND c.type=:type")
	RegisteredUser findByNamedParam(@Param("username") String username, @Param("password") String password,
	        @Param("type") String type);

}
