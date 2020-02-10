package com.lxisoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxisoft.domain.Contact;
import com.lxisoft.repository.MysqlRepository;

@Service 

public class ContactService {
	
	@Autowired
	public List<Contact> getAllContact()
	{
		MysqlRepository dbrepo=new MysqlRepository();
		List<Contact>contactList=dbrepo.findAllContact();
		return contactList;
	}
	public Contact addContact(Contact cont)
	{
		MysqlRepository dbrepo=new MysqlRepository();
		Contact c=dbrepo.saveContact(cont);
		return c;
	}
	public Contact getContact(int idd)
	{
		MysqlRepository dbrepo=new MysqlRepository();
		Contact contact=dbrepo.findContactById(idd);
		return contact;
	}
	public void deleteContact(int n)
	{
		MysqlRepository dbrepo=new MysqlRepository();
		dbrepo.deleteContact(n);
	}
	public Contact editContact(int n,Contact cont)
	{
		MysqlRepository dbrepo=new MysqlRepository();
		Contact con=dbrepo.updateContact(n,cont);
		return con;
	}

}
