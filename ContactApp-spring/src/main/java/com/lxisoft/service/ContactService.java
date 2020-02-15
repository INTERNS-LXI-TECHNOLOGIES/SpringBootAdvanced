package com.lxisoft.service;
import com.lxisoft.model.*;

import java.util.*;
import com.lxisoft.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ContactService
{
	@Autowired
	Sqlrepository repo;
	
	public ArrayList<Contact> display()
	{
		return repo.read();
	}
	
	public void add(Contact contact)
	{
		repo.write(contact);
	}
	
	public void delete(int id) {
		repo.delete(id);
	}

	public ArrayList<Contact> search(String name)
	{
		return repo.search(name);
	}
	
	public void edit(Contact contact)
	{
		repo.edit(contact);
	}
}