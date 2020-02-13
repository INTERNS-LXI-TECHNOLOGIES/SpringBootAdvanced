package com.lxisoft.repository;


import java.util.List;

import com.lxisoft.domain.Contact;

public interface MysqlRepository 
{
	 public void addContacts(Contact contact);
	 
    public List<Contact> getAllContacts();
    public void deleteAllContacts();

  public void deleteContact(Contact contact);
  
  public Contact updateContact(Contact contact);
 
  public Contact getContact(int id);


}
