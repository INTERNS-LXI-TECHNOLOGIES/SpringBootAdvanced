package com.lxisoft.RunWay.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lxisoft.RunWay.model.User;


public interface UserRepository extends JpaRepository<User, Integer>
{
    Optional<User> findByEmail(String email);
}
