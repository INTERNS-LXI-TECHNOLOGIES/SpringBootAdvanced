package com.lxisoft.contacts.model;

import java.util.ArrayList;

import com.lxisoft.contacts.domain.Contact;

public interface StockBo 
{
	 public void setConnection();
	public void writeNewContact(Contact contact,boolean write);
	public void editContact(Contact contact, int i);
	public void deleteContact(Contact c);
	public ArrayList<Contact> getAllContacts();
	public  void setId();
	public void clearAllContacts();
	public void sortByFirstName();
	public void sortByLastName();
	public void sortById();
	public void sortByNumber();
	public void resetDataBase();9
}
