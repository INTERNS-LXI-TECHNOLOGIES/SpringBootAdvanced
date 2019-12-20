package com.lxisoft.RunWay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lxisoft.RunWay.model.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{

}
