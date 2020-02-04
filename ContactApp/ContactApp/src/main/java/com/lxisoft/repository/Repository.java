package com.lxisoft.repository;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;

import com.lxisoft.domain.Contact;

@Controller
public interface Repository
{
public ArrayList<Contact> getAllContacts()throws SQLException;
//public void addContactDetails(Contact contact)throws SQLException;
//public void insertContactDetails(Contact contact,boolean tbexists)throws SQLException;
//public void updateRepo(Contact contact)throws SQLException;
//public void deleteContact(Contact c)throws SQLException;
//public void clearRepository()throws SQLException;
//public void sortContactByFirstName()throws SQLException;
//public void sortContactByLastName()throws SQLException;
//public boolean validateUser(String username,String password);


}
