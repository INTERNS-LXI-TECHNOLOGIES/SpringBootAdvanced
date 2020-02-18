package com.lxisoft.dao;
 
import java.util.ArrayList;
import java.util.List;
import com.lxisoft.model.Contact;
 
public interface Contactdao {
 
	public void sqlrepository();
	public void delete(int id);
	public void write(Contact contact);
	public void clear();
	public  ArrayList <Contact> read();
	public void edit(Contact contact);
	public ArrayList<Contact> search(String name);
 
   
}