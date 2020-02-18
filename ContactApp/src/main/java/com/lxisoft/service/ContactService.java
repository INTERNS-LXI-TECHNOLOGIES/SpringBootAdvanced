package com.lxisoft.service;
import com.lxisoft.domain.*;
import com.lxisoft.model.EditModel;

import java.util.*;
import com.lxisoft.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService
{
	@Autowired
	MysqlRepo repo;
	
	public ArrayList<Contact> findAllService()
	{
		return repo.findAll();
	}
	
	public void saveService(Contact contact)
	{
		repo.save(contact);
	}
	
	public void deleteService(Contact contact) {
		repo.delete(contact);
	}
	
	public Contact findIdService(String id)
	{
		int idnum=Integer.parseInt(id);
		return repo.findId(idnum);
	}
	
	public void editService(Contact newcontact)
	{
		repo.edit(newcontact);
	}
}
