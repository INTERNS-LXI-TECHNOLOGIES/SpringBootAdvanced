package com.lxisoft.service;
import com.lxisoft.domain.*;
import com.lxisoft.model.EditModel;

import java.util.*;
import com.lxisoft.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactService
{
	{System.out.println("services");}
	@Autowired
	MysqlRepo repo;
	
	@Transactional
	public List<Contact> findAllService()
	{
		repo.set();
		return repo.findAll();
	}
	
//	public void saveService(Contact contact)
//	{
//		repo.save(contact);
//	}
//	
//	public void deleteService(Contact contact) {
//		repo.delete(contact);
//	}
//	
//	public ArrayList<Contact> sortService(String type)
//	{
//		return repo.sort(type);
//	}
//	
//	public Contact findIdService(String id)
//	{
//		return repo.findId(id);
//	}
//	
//	public void editService(Contact contact, String[] temp)
//	{
//		repo.edit(contact,temp);
//	}
}
